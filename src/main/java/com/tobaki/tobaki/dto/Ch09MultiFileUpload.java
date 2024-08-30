package com.tobaki.tobaki.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch09MultiFileUpload {
	String title;
	String desc;
	MultipartFile[] attach;
}
