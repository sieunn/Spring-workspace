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
	
	@PostMapping("/modifyProfile")
	public String updateMember (HttpSession session, Member updateMember) {
		
		//현재 로그인이된 세션의 정보를 가지고 와서 멤버정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자
		if(member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(updateMember);
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
	
	//검색하는 화면 보일 수 있도록 @GetMapping
	@GetMapping("/search")
	public String showSearchFor(Model model) {
		return "search";
	}
	
	@PostMapping("/search")
	public String searchMember(Model model, @RequestParam("keyword")String keyword) {
		List<Member> member = memberService.searchMembers(keyword);
		model.addAttribute("results",member);
		return "search";
	}
}











