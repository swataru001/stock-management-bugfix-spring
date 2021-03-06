package jp.co.rakus.stockmanagement.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.service.MemberService;

/**
 * メンバー関連処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/member")
@Transactional
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public MemberForm setUpForm() {
		return new MemberForm();
	}

	/**
	 * メンバー情報登録画面を表示します.
	 * 
	 * @return メンバー情報登録画面
	 */
	@RequestMapping(value = "form")
	public String form() {
		return "/member/form";
	}

	/**
	 * メンバー情報を登録します.
	 * 
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト
	 * @param model
	 *            モデル
	 * @return ログイン画面
	 */
	@RequestMapping(value = "create")
	public String create(@Validated MemberForm form, BindingResult result, Model model) {

		String password = form.getPassword();
		String confirmPassword = form.getConfirmPassword();
		
		if(!(password.equals(confirmPassword))) {
			result.rejectValue("password",null, "パスワードと確認用パスワードが違います。");
			
		}
		
		Member valueOfMember = memberService.findByMailAddress(form.getMailAddress());

		
		if (valueOfMember != null) {
			result.rejectValue("mailAddress",null, "メールアドレスが重複しています。");
			
		}
		
		if (result.hasErrors()) {
			return form();
		}

		Member member = new Member();
		BeanUtils.copyProperties(form, member);
		memberService.save(member);
		return "redirect:/";
	}
}
