/*
 * 순수 자바스크립트 형식, 제이쿼리 형식도 넣을 수 있는 공간
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 */



/*<button id="btn">연결 테스트</button>
를 클릭했을 때 나오는 기능*/
document.querySelector("#btn").addEventListener("click",btn);


/*<button id="btn">연결 테스트</button>
를 제이쿼리 형식으로 변경하기*/
$(document).ready(function(){
	$("#btn").click(btn)

})


/*<button onclick="btn()">연결 테스트</button>
를 클릭했을 때 나오는 기능*/
function btn(){
	alert("클릭되었습니다.")
}