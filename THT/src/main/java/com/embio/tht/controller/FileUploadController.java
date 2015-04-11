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
import com.embio.tht.common.FileUploader;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method=RequestMethod.POST)
	public void processUpload(@RequestParam MultipartFile image, Model model, HttpSession session) throws IOException {
		model.addAttribute("message", "image '" + image.getOriginalFilename() + "' uploaded successfully");
		try{
			String path = session.getServletContext().getRealPath("/");
			FileUploader.saveFileFromInputStream(image.getInputStream(), path, image.getOriginalFilename());
		}
		catch(Exception ex){
		}
	}
	
}
