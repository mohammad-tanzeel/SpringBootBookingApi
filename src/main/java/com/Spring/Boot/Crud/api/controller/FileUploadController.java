package com.Spring.Boot.Crud.api.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
	
	private static String UPLOAD_DIR = "uploads";
//	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
//	@RequestMapping(value="getpath", method=RequestMethod.GET)	
//	public String getpath() {
//		return uploadDirectory;
//	}
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		try {
//			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			String filename = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + filename;
//			String path = "D:\\Tanzeel\\Java\\ProjectNew2\\spring-boot-fileeupload\\uploads" + File.separator + filename;
			
			saveFile(file.getInputStream(), path);
			return filename;
		} catch (Exception e) {
			return e.getMessage();
		}
//		return null;
	}
	
	private void saveFile(InputStream inputStream, String path) {
		try {
		OutputStream outputStream = new FileOutputStream(new File(path));
		int read = 0;
		byte[] bytes = new byte[1024];
		while((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		outputStream.flush();
		outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
