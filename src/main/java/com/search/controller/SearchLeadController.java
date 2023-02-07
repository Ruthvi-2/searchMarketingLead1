package com.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.dto.LeadDto;

@Controller
public class SearchLeadController {
	
	@Autowired
	private LeadRestClient leadRestClient;
	
	//localhost:9090/search
	@RequestMapping("/search")
	 public String viewSearchLead() {
		return "search_lead";
	 }
	
	@RequestMapping("/findById")
	public String findLeadById(@RequestParam("id") long id,ModelMap model) {
		LeadDto leadDto = leadRestClient.getOneLead(id);
		model.addAttribute("leadDto", leadDto);
		return "lead_info";
	}

}
