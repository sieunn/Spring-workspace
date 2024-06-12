package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
			//Bean : 스프링이 알아서 만들고 관리한다는 것
@Controller //응답,요청 제어 역할을 명시 + Bean으로 등록
@RequestMapping("param") // 여기 밑에 작성하는 모든 주소 앞에 param이 기본으로 붙음
@Slf4j //Simple logging facade 4(for) Java의 약자 -> System.out.println 과 비슷한 종류
//System 출력에 비해 logging 사용하는 것이 메모리 부암이 적음 log를 이용한 메세지 출력시 자주 사용
public class ParmeterController {

	//GETMAPPING main
	@GetMapping("main") //para/main 주소로 GET 방식 요청을 만든것
	public String paraMain() {
		return "param/param-main";
		//return 할 때 폴더명/파일명 작성
		//param-main.html은 템플릿 밑에 param이라는 폴더 밑에 존재
		//html 파일을 바라볼 때 기본으로 templates이라는 폴더를 바라보고
		//templates/param/param-main.html 파일을 바라본다는 표시를 작성
	}
	
	@PostMapping("test1") //param/test1 POST 방식 요청
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		//form 밑에 input에서 name으로 inputName으로 존재하는 값을 가져오기 
		//이름 : <input type="text" name="inputName"><br>
		
		String inputAddress = req.getParameter("inputAddress");
		//form 밑에 input에서 name으로 inputAddress으로 존재하는 값을 가져오기 
		//주소 : <input type="text" name="inputAddress"><br>
		
		
		//-> 기본으로 가져오는 값이 String이기 때문에 숫자값인 int로 변환이 필요
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		//form 밑에 input에서 name으로 inputAge으로 존재하는 값을 가져오기 
		//나이 : <input type="number" name="inputAge"><br>
		
		//inputName 과 inputAddress와 inputAge가 제대로 작성됐느지 확인
		System.out.println("이름 확인" + inputName);
		System.out.println("나이 확인" + inputAge);
		System.out.println("주소 확인" + inputAddress);
		
		// -> system 대신 log.debug 를 활용해서 출력하는 것이 메모리 부담 적음
		//-> 코드 오류 해결하기 위한 로그
		//-> 코드 오류는 없는데 정상적으로 수행이 안되거나
		// -> 값이 잘못된 경우 -> 값 추적
		log.info("정보확인하기");
		log.debug("로그로 이름 확인 : " + inputName);
		log.debug("로그로 나이 확인 : " + inputAge);
		log.debug("로그로 주소 확인 : " + inputAddress);
		
		/*
		 * spring 에서 Redirect(재요청) 하는 방법
		 * controller 메서드 반환값에
		 * redirect : 요청주소 작성하면
		 * 되돌아가짐
		 * 
		 * */
		
		return "redirect:/param/main";
	}
	
	
	/*
	 * 2. @RequestParam - 낱개(한개,단수)개 파라미터 얻어오기
	 * 
	 *  - request 객체를 이용한 파라미터 전달 어노테이션
	 *  - 매개 변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 작성됨
	 *  - 작성되는 데이터는 매개변수(파라미터) 타입에 맞게 형변환(parse) 자동으로 수행
	 *  
	 *  [속성 추가 작성법]
	 *  @RequestParam(vlaue="name", required="fasle", defualtvalue="1"
	 * 	
	 * value = 전달받은 input 태그의 name 속성값
	 * 
	 *  required = 입력된 name 속성값 파라미터(매개변수) 필수 여부 지정 (기본값 true)
	 *  		-> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러
	 *  		-> required = true인 파라미터가 null인 경우에도 400 Bad Request 에러
	 *  
	 *  defaultValue = 파라미터 중 일치하는 name 속성값이 없을 경우 대입할 값 지정
	 *  			-> required 가 false일 경우 사용
	 *  
	 * */
	
	//400 Bad Request (잘못된 요청)
	//- 파라미터 불충분하다는 것임
	@PostMapping("test2") //param/test2
	
	/*
	 *  책제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer"><br>
		가 격 : <input type="number" name="price"><br>
		출판사 : <input type="text" name="publisher"><br>
	 * */
	public String paramTest2(@RequestParam(/*value=*/"title"/*required=true*/)String title,
							@RequestParam("writer") String writer,
							@RequestParam("price") int price,
							@RequestParam(value="publisher",defaultValue="교보문고", required=false) String publisher
			) {
		log.info("문제없이 insert 가능한지 확인하기");
		log.debug("title : " + title);
		log.debug("writer : " + writer);
		log.debug("price : " + price);
		log.debug("publisher : " + publisher);
		return "redirect:/param/main";
	}
	
	
	/*3. @RequestParam 여러개 (복수,다수) 파라미터*/
	
	//String()
	//List<자료형>
	//Map<String,Object>
	
	//defaultValue 속성은 사용할 수 없음
	
	@PostMapping("test3")
	public String paramTest3(@RequestParam(value="color",required=false)String[] colorArr,
			@RequestParam(value="fruit",required=false)List<String> fruitList,
			@RequestParam Map<String, Object> paramMap
			) {
		
		log.info("colorArr: " + Arrays.toString(colorArr));
		
		log.info("fruitList : " + fruitList);
		
		log.info("paramMap :" + paramMap);
		//-> key (name 속성값)이 중복되면 덮어쓰기가 됨
		// 같은 name 속성 파라미터가 String[] List로 저장이 되는 것은 힘듬
		
		return "redirect:/param/main";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * DTO와 VO
	 * 
	 * DTO : Data Transfer Object 데이터 캡슐화를 통해 데이터를 전달하고 관리
	 * 		 한 계층에서 다른 계층으로 데이터 전송을 위해 사용 
	 * 		 주로 DTO 사용 예정		 
	 * 
	 * VO : Value Object 값 자체를 표현하는 객체
	 *  	한번 값이 생성되면 그 값을 변경할 수 없음
	 *  	생성자를 통해 값을 설정하고 setter 메서드를 제공하지는 않음
	 * */
	
	/*
	 * @ModelAttribute
	 * - DTO (또는 VO)와 같이 사용하는 어노테이션
	 * 
	 * - 전달받은 파라미터(매개변수)의 name 속성값이
	 * - 같이 사용되는 DTO의 필드명과 같다면
	 * - 자동으로 setter를 호출해서 필드에 값을 저장
	 * 
	 * [주의사항]
	 * - DTO에는 기본생성자가 필수로 존재해야함
	 * - DTO에 setter가 필수로 존재해야함
	 * 
	 * 어노테이션이 자동으로 생략가능
	 * 
	 * @ModelAttribute 이용해 값이 필드에 저장된 객체를 커맨드 객체라고 함
	 * 
	 * */
	
	
	
	@PostMapping("test4")
	public String paramTest4(/*@ModelAttribute*/ MemberDTO inputMember) {
		
		//lombok으로 만든 setter getter로 값 가져오거나 설정하기
		MemberDTO mem = new MemberDTO();
		mem.getMemberAge(); //getter를 통해 나이 가져오기
		mem.setMemberAge(0); //setter를 통해 나이 가져오기
		// 굳이 따로 만들지 않아도 lombok 으로 만들어 가져오기 때문에 사용가능한 것
		
		mem.getMemberId();
		mem.setMemberId("1");
		
		mem.getMemberPw();
		mem.setMemberPw("pass01");
		
		mem.getMemberName();
		mem.setMemberName("가나다");
		
		log.info("inputMember에 대한 set 정보 가져오기 : " + inputMember.toString());
		return "redirect:/param/main";
		
		
/*[THYMELEAF][http-nio-8081-exec-4] Exception processing template "": Error resolving template [], 
 * template might not exist or might not be accessible by any of the configured Template Resolvers
 * 
 * ->return redirect 안써줘서 나오는 에러 
 * */
	}
	
}
