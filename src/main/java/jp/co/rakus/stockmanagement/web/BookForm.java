package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.NotNull;

import lombok.NonNull;

public class BookForm {

	/** id */
	@NonNull
	private Integer id;
	/** 在庫 */
	@NotNull(message = "値を入力してください")
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
