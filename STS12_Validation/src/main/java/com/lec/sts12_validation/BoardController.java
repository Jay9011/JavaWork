package com.lec.sts12_validation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	} // end write()
	
	@RequestMapping("writeOk.do")
	public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto,
			BindingResult result) {	// ← validator 가 유효성 검사를 한 결과를 담은 객체
		System.out.println("writeOk(): " + dto.getUid() + " : " + dto.getName());
//		System.out.println("에러 개수 : " + result.getErrorCount());	// 바인딩 과정에서 발생한 에러 개수
//		System.out.print("validate 전 ");
		showErrors(result);
		
		String page = "board/writeOk";

		// Validator 객체 생성
//		BoardValidator validator = new BoardValidator();
//		validator.validate(dto, result);
		System.out.print("validate 후 ");
		showErrors(result);
		
		if(result.hasErrors()) {	// 에러가 있으면
			page = "board/write";	// 원래 폼으로 돌아가기!
		}
		
		return page;
	} // end writeOk()
	
	
	/**
	 * error 에 담겨있는 에러 들을 다 출력해보기
	 */
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 : " + errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList = errors.getFieldErrors();
			for(FieldError err : errList) {
				System.out.println("\t" + err.getField() + "\t|" + err.getCode());
			}
		} else {
			System.out.println("에러 없음.");
		} // end if-else
	} // end showErrors()
	
	/**
	 * Validator 인터페이스를 직접 구현하지 않고
	 * 스프링 프레임워크에서 호출하는 방법.
	 * 이 컨트롤러 클래스의 handler 에서 폼 데이터를 바인딩할 때 검증하는 객체를 지정할 수 있다.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder 로 검증(Validator)할 객체를 지정
		binder.setValidator(new BoardValidator());
	}
}
