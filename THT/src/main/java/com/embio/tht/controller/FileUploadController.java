package com.embio.tht.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.embio.tht.ajax.AjaxUtils;
import com.embio.tht.beans.*;
import com.embio.tht.common.Checker;
import com.embio.tht.common.FileUploader;
import com.embio.tht.common.ModelFactory;
import com.embio.tht.common.TicketGenerater;

@Controller
@RequestMapping("/form_dish_add_step2")
public class FileUploadController {

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method=RequestMethod.POST)
	public void processUpload(
			@RequestParam MultipartFile image,
			Model model,
			String dishname,
			Double dishprice,
			HttpSession session) throws IOException {
		
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		String image_name = "image_not_found.jpg";
		try{
			String path = session.getServletContext().getRealPath("/") + "/resources/images";
			image_name = TicketGenerater.generateCode()+".jpg";
			FileUploader.saveFileFromInputStream(image.getInputStream(), path, image_name);
		}
		catch(Exception ex){
		}
		model.addAttribute("dishname", dishname);
		model.addAttribute("dishprice", dishprice);
		model.addAttribute("message", "Image '" + image.getOriginalFilename() + "' uploaded successfully");
		model.addAttribute("dishimage", image_name);
	}
	
}
