package jp.co.rakus.stockmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testUpload")
public class TestUploadController {

	@RequestMapping("/upload")
	public String upload(UpLoadForm uploadForm) {
		
		System.out.println(uploadForm.getFile().getOriginalFilename());
		
		System.out.println("testtesttest");
		
		return "book/insert";
	}
	
	
}
