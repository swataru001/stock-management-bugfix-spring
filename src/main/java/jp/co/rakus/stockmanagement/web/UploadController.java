package jp.co.rakus.stockmanagement.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;




@Controller
@RequestMapping("/upload")
public class UploadController {

	@ModelAttribute
	public BookInfoForm setUpBookInfoForm() {
		return new BookInfoForm();
	}

	@RequestMapping("/upload")
	public String upload(UpLoadForm uploadForm) {
		
		System.out.println(uploadForm.getFile().getOriginalFilename());
		
		System.out.println("testtesttest");
		
		return "book/insert";
	}

	@RequestMapping(value = "/uploadImg")
	public String upload(Model model, UpLoadForm uploadForm) {
		System.out.println("test");
	  if (uploadForm.getFile().isEmpty()) {
		  System.out.println("エラー");
	    return "book/list";
	  }
	
	  
	
	  String relativePath = "src\\main\\webapp\\img\\";
	  System.out.println(new File(relativePath).getAbsolutePath());
	  
	  String path = new File(relativePath).getAbsolutePath();
	
	  Path webPath = Paths.get(path);
	  if (!Files.exists(webPath)) {
	    try {
	    	System.out.println("だめーーーーーーーーーー");
	      Files.createDirectory(webPath);
	    } catch (NoSuchFileException ex) {
	      System.err.println(ex);
	    } catch (IOException ex) {
	      System.err.println(ex);
	    }
	  }
	  	System.out.println("オッケー");
	  int dot = uploadForm.getFile().getOriginalFilename().lastIndexOf(".");
	  String extention = "";
	  if (dot > 0) {
	    extention = uploadForm.getFile().getOriginalFilename().substring(dot).toLowerCase();
	  }
	  String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	  Path uploadfile = Paths
	      .get(webPath + filename + extention);

	  try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
	    byte[] bytes = uploadForm.getFile().getBytes();
	    os.write(bytes);
	    
	  } catch (IOException ex) {
	    System.err.println(ex);
	  }

	  return "book/insert";
	}
	
}
