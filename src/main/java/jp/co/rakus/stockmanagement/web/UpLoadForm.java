package jp.co.rakus.stockmanagement.web;

import org.springframework.web.multipart.MultipartFile;

public class UpLoadForm {

	private MultipartFile file;

	  public MultipartFile getFile() {
	    return file;
	  }

	  public void setFile(MultipartFile file) {
	    this.file = file;
	  }
}
