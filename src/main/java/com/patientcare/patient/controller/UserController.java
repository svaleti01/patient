package com.patientcare.patient.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patientcare.patient.entity.Claims;
import com.patientcare.patient.entity.Drug;
import com.patientcare.patient.entity.User;
import com.patientcare.patient.model.ClaimsRequest;
import com.patientcare.patient.model.HistoryResp;
import com.patientcare.patient.service.ClaimsService;
import com.patientcare.patient.service.DrugService;
import com.patientcare.patient.service.UserService;

@RestController
public class UserController {

	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	ClaimsService claimsService;

	@Autowired
	DrugService drugService;

	List<Drug> drugs = new ArrayList<Drug>();

	@Value("${RXNORM_RXCUI_API}")
	private String RXNORM_RXCUI_API;
	
	@Value("${RXNORM_OPIOIDCHECK_API}")
	private String RXNORM_OPIOIDCHECK_API;
	
	private String RXNORM_API_PATH = "/related.json?rela=tradename_of+has_precise_ingredient";

	@RequestMapping(value = { "/getUserHistory" }, method = RequestMethod.GET)
	public ResponseEntity<List<HistoryResp>> getAllUsers(@RequestParam String username) {
		User user = userService.getUserByUsername(username);
		LOGGER.info(user.getUserid().toString());
		List<Claims> claims = new ArrayList<Claims>();
		claims = claimsService.getClaimsByUserid(user.getUserid());
		drugs = drugService.getDrugByUserid(user.getUserid());
		List<HistoryResp> response = new ArrayList<HistoryResp>();
		claims.forEach((claimsRecord) -> {
			HistoryResp eachResponse = new HistoryResp();
			eachResponse.setClaimsid(claimsRecord.getClaimsid());
			eachResponse.setClaimsdate(claimsRecord.getClaimsdate());
			eachResponse.setOpioidflag(claimsRecord.getOpioidflag());
			eachResponse.setStatus(claimsRecord.getStatus());
			eachResponse.druglist = new ArrayList<Drug>();
			drugs.forEach((drugRecord) -> {
				if (drugRecord.getClaimsid() == claimsRecord.getClaimsid()) {
					eachResponse.druglist.add(drugRecord);
				}
			});
			response.add(eachResponse);
		});

		System.out.println(response);
		return new ResponseEntity<List<HistoryResp>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = { "/claimsRequest" }, method = RequestMethod.POST)
	public ResponseEntity<String> claimsRequest(@RequestBody ClaimsRequest request) {
		if (callOpenAPI(request.getDrug())) {
			return new ResponseEntity<String>("survey needed", HttpStatus.OK);
		} else {
			User user = userService.getUserByUsername(request.getUsername());
			long millis=System.currentTimeMillis(); 
	        Date date = new Date(millis);
			Claims claims = new Claims(user.getUserid(), "PENDING", "N", date, 0);
			Integer claimsid = claimsService.addClaims(claims);
			Drug drug = new Drug(user.getUserid(), claimsid, request.getDrug(), request.getCount());
			drugService.addDrug(drug);
			return new ResponseEntity<String>("request added", HttpStatus.OK);
		}

	}
	
	public Boolean callOpenAPI(String drug) {
		String rxcui = getrxcui(drug);
		if (hasOpioid(rxcui)) {
			return true;
		}
		return false;
	}
	
	public String getrxcui(String drug) {
		String url = RXNORM_RXCUI_API + drug;
		String rxcui = "";
		
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(url, String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objectMapper.readTree(resp);
			rxcui = jsonNode.get("approximateGroup").get("candidate").get(0).get("rxcui").toString();
			rxcui = rxcui.replace("\"", "");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rxcui;
		
	}
	
	public Boolean hasOpioid(String rxcui) {
		String url = RXNORM_OPIOIDCHECK_API + rxcui + RXNORM_API_PATH;
		
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(url, String.class);
		System.out.println(resp);
		
		return (resp.contains("fentanyl") || resp.contains("morphine"));

	}

}
