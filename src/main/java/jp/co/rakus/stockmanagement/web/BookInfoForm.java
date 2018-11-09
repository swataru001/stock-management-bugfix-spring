package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class BookInfoForm {


	/** 書籍名 */
	@NotBlank(message = "名前を入力してください。")
	private String name;
	/** 著者名 */
	@NotBlank(message = "著者名を入力してください。")
	private String author;
	/** 出版社 */
	@NotBlank(message = "出版社名を入力してください。")
	private String publisher;
	/** 価格 */
	@NotBlank(message = "値段を入力してください。")
	private String price;
	/** ISBNコード */
	@NotBlank(message = "ISBNコードを入力してください。")
	private String isbncode;
	/** 発売日 */
	@NotBlank(message = "発売日を入力してください。" )
	private String saledate;
	/** 説明 */
	@NotBlank(message = "説明を入力してください。")
	private String explanation;
	/** 画像 */
	@NotNull
	private MultipartFile file;
	/** 在庫 */
	@NotBlank(message = "値を入力してください")
	private String stock;
	
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIntStock() {
		return Integer.parseInt(stock);
		
	}
	
	public int getIntPrice() {
		return Integer.parseInt(price);
		
	}
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
}
