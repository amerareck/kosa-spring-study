package com.tobaki.tobaki.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tobaki.tobaki.dto.Ch09FileUpload;
import com.tobaki.tobaki.dto.Ch09MultiFileUpload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", "ch09");
	}
	
	@GetMapping("/fileUploadForm")
	public String fileUploadForm() {
		log.info("실행");
		
		return "ch09/fileUploadForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(Ch09FileUpload form, HttpServletResponse res) throws IOException {
		log.info("실행");
		log.info("title: "+form.getTitle());
		log.info("desc: "+form.getDesc());
		
		MultipartFile mf = form.getAttach();
		if(!mf.isEmpty()) {
			log.info("OriginalFilename: "+mf.getOriginalFilename());
			log.info("ContentType: "+mf.getContentType());
			log.info("Size: "+mf.getSize());
			
			String saveLocation = "C:\\2024-oti\\eclipse-workspace\\uploadFiles";
			String saveName = new Date().getTime() + "-" + mf.getOriginalFilename();
			File file = new File(saveLocation, saveName);
			mf.transferTo(file);
		}
		
		return "redirect:/ch09/downloadFileList";
	}
	
	@GetMapping("/downloadFileList")
	public String downloadFileList(Model model) {
		log.info("실행");
		String FilePath = "C:\\2024-oti\\eclipse-workspace\\uploadFiles";
		File file = new File(FilePath);
		String[] FileList = file.list();
		model.addAttribute("fileNames", FileList);
		
		return "ch09/downloadFileList";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(Ch09MultiFileUpload form, HttpServletResponse res) throws IOException {
		log.info("실행");
		log.info("title: "+form.getTitle());
		log.info("desc: "+form.getDesc());
		MultipartFile[] mfList = form.getAttach();
		
		if(mfList != null) {
			for(MultipartFile mf : mfList) {
				log.info("");
				log.info("OriginalFilename: "+mf.getOriginalFilename());
				log.info("ContentType: "+mf.getContentType());
				log.info("Size: "+mf.getSize());
				String saveLocation = "C:\\2024-oti\\eclipse-workspace\\uploadFiles";
				String saveName = new Date().getTime() + "-" + mf.getOriginalFilename();
				File file = new File(saveLocation, saveName);
				mf.transferTo(file);
			}
		}
		
		return "redirect:/ch09/downloadFileList";
	}
	
	@PostMapping("/uploadFileAjax")
	public void DownloadFileAjax(Ch09FileUpload form, HttpServletResponse res) throws IOException {
		log.info("실행");
		log.info("title: "+form.getTitle());
		log.info("title: "+form.getDesc());
		MultipartFile mf = form.getAttach();
		JSONObject json = new JSONObject();
		
		if(mf != null) {
			log.info("OriginalFilename: "+mf.getOriginalFilename());
			log.info("ContentType: "+mf.getContentType());
			log.info("Size: "+mf.getSize());
			String saveLocation = "C:\\2024-oti\\eclipse-workspace\\uploadFiles";
			String saveName = new Date().getTime() + "-" + mf.getOriginalFilename();
			File file = new File(saveLocation, saveName);
			mf.transferTo(file);
			json.put("status", "ok");
		} else {
			json.put("status", "error");
		}
		
		res.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = res.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@GetMapping("/downloadFile")
	public void downloadFile(String fileName, HttpServletRequest req, HttpServletResponse res) throws IOException {
		log.info("실행");
		String saveLocation = "C:\\2024-oti\\eclipse-workspace\\uploadFiles";
		String encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		
		res.setContentType(req.getServletContext().getMimeType(fileName));
		res.setHeader("Content-Disposition", "attachment; filename=\""+encodingFileName+"\"");
		
		Path path = Paths.get(saveLocation + "\\" + fileName);
		log.info(path.toString());

		OutputStream out = res.getOutputStream();
		Files.copy(path, out);
		out.flush();
		out.close();
	}
}
