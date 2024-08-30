package com.tobaki.tobaki.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch09FileUpload {
	String title;
	String desc;
	MultipartFile attach;
}
