package jp.co.rakus.stockmanagement.web;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.service.BookService;
import lombok.Getter;
import lombok.Setter;

/**
 * 書籍関連処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/book")
@Transactional
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private ServletContext application;

	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public BookForm setUpForm() {
		return new BookForm();
	}

	@ModelAttribute
	public BookInfoForm setUpBookInfoForm() {
		return new BookInfoForm();
	}
	

	/**
	 * 書籍リスト情報を取得し書籍リスト画面を表示します.
	 * 
	 * @param model
	 *            モデル
	 * @return 書籍リスト表示画面
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);

		return "book/list";
	}

	/**
	 * 書籍詳細情報を取得し書籍詳細画面を表示します.
	 * 
	 * @param id
	 *            書籍ID
	 * @param model
	 *            モデル
	 * @return 書籍詳細画面
	 */
	@RequestMapping(value = "show/{bookId}")
	public String show(@PathVariable("bookId") Integer id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book/show";
	}

	/**
	 * 書籍更新を行います.
	 * 
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト情報
	 * @param model
	 *            モデル
	 * @return 書籍リスト画面
	 */
	@RequestMapping(value = "update")
	public String update(@Validated BookForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return show(form.getId(), model);
		}
		Book book = bookService.findOne(form.getId());
		book.setStock(form.getStock());
		bookService.update(book);
		return list(model);
	}

	@RequestMapping(value = "insertBookInfo")
	public String insertBookInfo() {

		return "book/insert";
	}

	@RequestMapping(value = "insert")
	public String insert(@Validated BookInfoForm form, BindingResult result, Model model) throws ParseException {
		if (result.hasErrors()) {
			return "book/insert";
		}

		
		if (form.getFile().isEmpty()) {
			  System.out.println("エラー");
		    return "book/list";
		  }
		  
		
		  String path = application.getRealPath("/img/" + form.getFile().getOriginalFilename());
		  Path uploadfile = Paths .get(path);

		  try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
		    byte[] bytes = form.getFile().getBytes();
		    os.write(bytes);
		    
		  } catch (IOException ex) {
		    System.err.println(ex);
		  }


		Book book = new Book();
		
		int maxId = bookService.selectMaxId();
		int id = maxId + 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateValueOfSaleDate = sdf.parse(form.getSaledate());
		
		book.setId(id);
		book.setSaledate(dateValueOfSaleDate);
		book.setPrice(form.getIntPrice());
		book.setStock(form.getIntStock());
		book.setImage(form.getFile().getOriginalFilename());
		BeanUtils.copyProperties(form, book);
		bookService.save(book);
		return list(model);
	}

}
