<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<style type="text/css">

body{
	margin-top: 0px;
	font-family: 'Gowun Dodum', sans-serif;

}


header{
	position: fixed;
	margin: auto;
	padding-left: 30px;
	padding-right: 30px;
	border-bottom: 1px solid #d3d3d3;
	width: 100%;
	height: 130px;
	background-color: white;
	z-index: 888;
	left: 50%;
	transform: translateX(-50%);
	
}

.header{
	position: fixed;
	left: 50%;
	transform: translateX( -50% );
	width: 1150px;
	margin: auto;
	margin-top: 20px;
	height: 54px;
	float: left;
	z-index: 889;
}

.logo{
	width: 200px;
	float: left;
	margin-left: 70px;
	cursor: pointer;
}
.searchtext{
	width: 450px;
	height: 39px;
	float: left;
	margin-left: 70px;
	margin-right: 50px;
	margin-top: 10px;
	border: 2px solid #20de07;
}
#searchtext{
	float: left;
	width: 400px;
	padding-left: 10px;
	height: 37px;
	border: none;
	outline: none;
	
}
#searchicon{
	width: 25px; 
	height: 25px; 
	margin-top: 7px; 
	margin-left: 7px;

}

#search:focus{
	outline: none;
}

.btn_place{
	margin-top : 12px;
	width: 260px;
	float: left;
	align-items: center;
	cursor: pointer;
}

.btn{  
	text-decoration: none;
	text-align: center;
}

.btn > img {
	vertical-align: middle;
}


.side{
	display: flex;
	padding-top: 130px;
	position: fixed;
	top: 70px;
	right: calc(50% - 650px);
}

li, ul{
	list-style: none;
}

.navi_bar{
	display: inline-block;
	height: 54px;
	clear: both;
	float: left;
	width: 30px;
	margin: auto;
	margin-left: 80px;
	
	margin-top: 15px; 
}


.menu_content{
	list-style:none;	
	width: 150px;
	float: left;
	display : none;
	position : absolute;
	z-index : 1; /*다른 요소들보다 앞에 배치*/
	margin-top : 12px;
	border: 1px solid green;
	background-color : white; 
}


.menu_content a{
	display: block;
	padding: 5px;
	text-decoration: none;
	border: 1px solid green;
}

.navi_bar:hover .menu_content {
  display: block;
}

</style>


<script type="text/javascript">

function send1() {
	
	var search1 = document.getElementById('searchtext').value;
	//검색어가 비었을 때 전체검색
	
	
	if( search1 !="" ){		
		location.href = "list.do?searchtext=" + encodeURIComponent(search1);
	}
	if( search1 == "" ){
		location.href = "list.do";
	}
	
}

$(function() {

	$(".searchtext").on("keyup", function(key) {
		if (key.keyCode == 13) {
			send1();
		}
	});

});
	

</script>

</head>
<body>
<div>

<header>
<!-- 고정헤더 -->
	<div class="header">
	<!-- 로고 -->
		<a class="logo"><img src="../image/상추마켓.png" width="200" height="50" onclick="location.href='../mainpage/list.do'"></a>
	<!-- 검색창 -->
	
		<div class="searchtext" >
			<input id="searchtext" name="searchtext" type="text" >
			<img id="searchicon" src="../image/saerch-icon.png" onclick="send1();">

		</div>
	<c:if test="${ empty sessionScope.user }">
		<div class="btn_place">
			<a class="btn" onclick="location.href='../user/login_form.do'"><img src="../image/mypage.png" width="30px">&nbsp;로그인</a>
			&nbsp;&nbsp;|&nbsp;
			<a class="btn" onclick="location.href='../user/enroll_form.do'"><img src="../image/mypage.png" width="30px">&nbsp;회원가입</a>
		</div>
	</c:if>
	
	
	<!-- 판매,마이페이지 버튼 -->
	<c:if test="${ not empty sessionScope.user }">
		<div class="btn_place">
			<a class="btn" onclick="location.href='../product/insert_form.do'"><img src="../image/sell.png" width="30px">&nbsp;판매하기</a>
			 &nbsp;&nbsp;|&nbsp;
			<a class="btn" onclick="location.href='../mypage/list.do'"><img src="../image/mypage.png" width="30px">&nbsp;마이페이지</a>
		</div>
	</c:if>
	<!-- 반응형 네비게이션 바 -->
		<div class="navi_bar">
			<span class="main_menu"><img src="../image/category.png" width="30px"></span>
			<div class="menu_content">
				<a href="../mainpage/list.do?c_idx=1">남성의류</a>
				<a href="../mainpage/list.do?c_idx=2">여성의류</a>
				<a href="../mainpage/list.do?c_idx=3">도서/문구</a>
				<a href="../mainpage/list.do?c_idx=4">음반/악기</a>
				<a href="../mainpage/list.do?c_idx=5">가전제품</a>
				<a href="../mainpage/list.do?c_idx=6">뷰티/미용</a>
			</div>
		</div>
	</div>
</header>
	<!-- 고정형 사이드바 -->
	<div class="side">
		<%@include file="../sidebar/sideBar.jsp" %>
	</div>
	
	<!--  -->



</div>

</body>
</html>