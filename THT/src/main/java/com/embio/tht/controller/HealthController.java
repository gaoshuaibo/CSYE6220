package com.embio.tht.controller;

import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.embio.tht.beans.*;
import com.embio.tht.common.Checker;
import com.embio.tht.common.HealthEngine;
import com.embio.tht.common.HealthReportModel;
import com.embio.tht.common.ModelFactory;
import com.embio.tht.common.TrackUnitModel;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/health")
public class HealthController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/view/user", method = RequestMethod.GET)
	public String generateHealthReport(
			@RequestParam(value="userid") Integer _userid,
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		
		HealthReportModel healthReportModel = HealthEngine.AnalysisUser(ui);
		
		String dates = "";
		String calories = "";
		int index = 0;
		for(TrackUnitModel item:healthReportModel.getTrace().getItems()){
			if(dates.isEmpty()){
				dates = "\"" + item.getDisplayDate() + "\"";
				calories = "\"" + item.getCalorie() + "\"";
			}
			else{
				dates += "," + "\"" +  item.getDisplayDate() + "\"";
				calories += "," + "\"" +  item.getCalorie() + "\"";
			}
		}
		
		model.addAttribute("healthReport", healthReportModel);
		model.addAttribute("dates", dates);
		model.addAttribute("calories", calories);
		
		return "view_user_health_report";

	}
}
