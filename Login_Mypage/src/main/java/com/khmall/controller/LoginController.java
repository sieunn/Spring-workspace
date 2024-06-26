package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RestController -> 추후 리액트를 사용할 때 사용할 예정
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m",new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
							@RequestParam("member_name") String member_name,
							@RequestParam("member_phone") String member_phone,
							HttpSession session) {
		
		Member member = memberService.getLogin(member_name, member_phone);
		//만약에 로그인한 정보와 일치한다면 그대로 db에서 담아서 가져올것이기 때문에 null이 아님
		//하지만 애초에 로그인할 정보가 다르면 db에서 출력이 되지 않기 때문에 null
		if(member != null) {
			session.setAttribute("loginSession", member); //setAttribute("임시로저장할변수명",임시저장할 내용")
			return "redirect:/";
		}else { //값이 비어있거나 일치하는 정보가 없다면
			model.addAttribute("e","일치하는 아이디 비밀번호가 없습니다.");
							//html파일 에다가 , java로 넘겨줘 (html-java 연결)
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session/*SessionStatus status 시간 지나면 자동 로그아웃*/) {
		session.invalidate(); //로그인 없던일 만들기
		return "redirect:/";
	}
	
	
	@GetMapping("/mypage")
	public String showMyPage(HttpSession session, Model model) {
		//현재 로그인이된 세션의 정보를 가지고 와서 멤버정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자
		if(member == null) {
			return "redirect:/login";
		}
		//만약에 모델에 정보가 담겨있으면 보여줄 멤버객체
		model.addAttribute("member",member);
		return "mypage";
	}
	
	
	
	/* **********마이페이지 불러오고 수정하는 GET POST ********** */
	@GetMapping("/modifyProfile")
	public String modifyMypage(HttpSession session, Model model) {
		//현재 로그인이된 세션의 정보를 가지고 와서 멤버정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자
		if(member == null) {
			return "redirect:/login";
			}
		//만약에 모델에 정보가 담겨있으면 보여줄 멤버객체
		model.addAttribute("member",member);
		return "modifyProfile";
	}
	
	/*
	 * @PostMapping("/modifyProfile") 코드 설명
	 * Member updateMember 와 Member member
	 * Member updateMember 는 소비자(클라이언트)가 새롭게 작성하고 DB에 덮어쓸 내용이 임시저장되어있음
	 * Member member 는 소비자(클라이언트)가 기존에 DB에 저장한 값 
	 * 
	 * Member member = (Member) session.getAttribute("loginSession");
	 * 			└── session에서 loginSession 이라는 변수명에 저장된 로그인 정보를 가져오기
	 * 				가져와서 member 기존에 DB에 저장된 값을 불러오기
	 * 
	 * updateMember.setMember_id(member.getMember_id()); -- 덮어쓰기
	 * 			└── DB에 저장된 값 중 id는 개발자가 회원가입을 한 순번을 소비자한테 부여한 순서값으로
	 * 				소비자가 가입한 순서는 변경할 수 없기 때문에 (소비자에 의해 변경될수 없기 때문에)
	 * 				id값으로 소비자가 새롭게 input 창 안에 수정해서 작성한 값을 가져와서 임시저장
	 * 
	 * 				setMember_id			member.getMember_id()
	 *
	 * 				member.getMember_id() -- 기존에 DB에 저장된 정보
	 * 				setMember_id		  -- 새롭게 DB에 저장할 정보
	 * 									  아이디(회원가입한 순서)는 똑같지만 밑 내용은 다를 수 잇음
	 * 
	 * memberService.updateMember(updateMember);
	 * 			└── 덮어쓰기 한 내용을 DB에 저장하기	
	 * 
	 * session.setAttribute("loginSession", updateMember);
	 * 			└── 새롭게 DB에 저장된 내용을 loginSession 이라는 변수명에 다시 저장
	 * 
	 * */
	@PostMapping("/modifyProfile")
	public String updateMember (HttpSession session, Member updateMember) {
		
		//현재 로그인이된 세션의 정보를 가지고 와서 멤버정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자
		if(member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(updateMember); //기존내용에서 새로운내용 덮어쓰기
		session.setAttribute("loginSession", updateMember);
		return "redirect:/mypage";
	}

	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session ) {
		//현재 로그인이된 세션의 정보를 가지고 와서 멤버정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
						
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자
		if(member == null) {
			return "redirect:/login";
			}
		
		memberService.deleteMember(member.getMember_id());//session에 저장된 member_id를 가져오겠다
		session.invalidate();//삭제후 로그인 없던일로 처리
		return "redirect:/";
		
	}
	
	
	
	/*
	 * @RequestParam("keyword") String keyword
	 * 
	 * <input type="text" name="keyword" placeholder="이름 또는 전화번호 입력" required> -> search.html
	 * 
	 * @RequestParam("input이나 태그에 작성한 name 또는 th로 작성된 변수명") String keyword
	 * input 에서 name값이 "keyword" 이기 때문에 @RequestParam("keyword") 이라고 쓴것
	 * input 에서 name, th:field 로 작성된 변수명과 무조건 일치해야함 @RequestParam("      ")
	 * 
	 * String keyword는 input에서 바라보는 keyword라는 값을 가져와서
	 * 자바에서 가져온 값을 담을 공간
	 * */
	
	//검색하는 화면 보일 수 있도록 @GetMapping
	@GetMapping("/search")
	public String showSearchFor(Model model) {
		return "search";
	}
	
	@PostMapping("/search")
											//String keyword안에 @RequestParam으로 받아온 소비자가 작성한 keyword값 담겨있음
	public String searchMember(Model model, @RequestParam("keyword")String keyword) {
		List<Member> member = memberService.searchMembers(keyword);
		model.addAttribute("results",member);
		//member 안에 DB에서 검색으로 가져온 결과들이 있음 
		//results는 검색결과가 member라는 이름으로 담겨있는 그릇
		//model.addAttribute는 results를 search.html 로 넘겨주는 운송하는 수단
		return "search";
	}
}











