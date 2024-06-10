package kh.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex1") /*form action 에 작성해준 경로 연결 방법*/
/*자바 파일ㅇ 여러파일, form 연결이 다수일 경우 / 위치로 연결*/
public class ExampleServlet2 extends HttpServlet {
       
	//GET방식 요청을 (method = "get"인 form 태그 제출) 처리하는 메서드
	@Override //HttpServlet에서 가져와서 개발자에 맞게 다시 작성해주는 것이기 때문에 재사용 Override 작성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 매개변수 req, resp
		 
		 HttpServletRequest
		 - 클라이언트 요청시 자동으로 생성되는 객체
		 
		 - 요청시 전달된 데이터, 요청한 클라이언트 정보, 요청을 유연하게 처리하기 위한 객체 등을 제공
		 
		 HttpServletResponse
		 - 클라이언트 요청시 자동으로 생성되는 객체
		 
		 - 서버가 클라이언트에게 응답할 수 있는 방법 제공
		 (서버->클라이언트 출력 스트림을 이용(PrintWriter)
		 
		 
		 -- index.html 만들어서 제출된 이름과 나이 얻어오기
		 --> 제출된 이름,나이 = 전달 매개변수(parameter) == 전달된 값 보여줄것
		 
		 --> 요청에 담긴 특정 파라미터 가져오기 할 때 name 쓸 것
		 --> String HttpServletRequest.getParameter("name속성값");
		 
		 */
		// <input type="text" name="inputName"> 에 작성되어 제출된 값 얻어오기
		String inputName = request.getParameter("inputName");
		//			--> 고객들이 작성된 값을 getParameter에서 name에 지정한 별칭으로 가져오기
		
		//<input type="number" name="inputAge"> 에 작성되어 제출된 값 얻어오기
		String inputAge = request.getParameter("inputAge");
		
		
		System.out.println("[서버] / ex1 요청을 받음");
		System.out.println("전달받은 inputName : " + inputName);
		System.out.println("전달받은 inputAge : " + inputAge);
		
		/*
		 http 
		 
		 404 : 웹 페이지 찾을 수 없을 때 -> 프로젝트 위치나 이름이 다를 때 (거의 경로지정 문제)
 		 -> index.html ExampleServlet2 서로 파일 위치 찾지 못해서 발생하는 에러
 		 -> springboot 에서는 이런 에러 발생하지않음
 		 */
		
		//----------------------------
		/*응답처리*/
		
		/*서버 (현재 프로젝트)  -> 클라이언트(브라우저)
		 * 
		 HTML 코드(문서) 출력 -> 출력받은 HTML 코드를 해석해서 화면에 구성
		 
		 1) 응답하는 문서 (데이터)의 형식과 문자 인코딩 지정
		 
		 2) 출력용 스트림 얻어오기
		 
		 3) 스트림을 이용해서 html 코드 출력하기
		 */
		
		//1) 응답하는 문서(데이터) 형식과 문자 인코딩 지정
		response.setContentType("text/html; charset=utf-8");
		
		//2) 출력용 스트림 얻어오기
		PrintWriter out = response.getWriter();
		
		//3) 스트림을 이용해서 html 코드 출력
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!Dodtype html>");
		sb.append("<html");
		
		sb.append("<head>");
		sb.append("<title> / ex1 응답페이지 </title>");
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append(String.format("<h1> %s님의 나이는 %s입니다. </h1>", inputName, inputAge));
		
		sb.append("</body>");
		sb.append("</html>");
		
		//sb에 누적된 html 코드를 스트림을 이용해서 출력
		out.print(sb.toString());
		
			
		// --> 사용하지 않는 방법
	}

}
