
<!--渡邊 カレンダー  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">

<link rel="stylesheet" type="text/css" href="/anikare/css/toppage.css">
<script src="./js/toppage.js" defer></script>
</head>
<c:forEach var="e" items="${BackgroundActiveList}">
	<body background="/anikare/img/${e.mail}">
	<div class="wrapper">
		<!-- ポップアップ表示 -->
		 <div class="popup" id="js-popup">
			<div class="popup-inner">
				<div class="close-btn" id="js-close-btn">
					<i class="fas fa-times"></i>
				</div>
				<div class="pChara">
					<a href="#"><img src="img/animal_dance.png" alt="ポップアップ画像"></a>
				</div>
				<p class="login_text">ログインしてくれてありがとう！</p>
				<p class="loginBonus_text">※初回ログイン時は、ログインボーナスが付与されます。</p>
				<form method="POST" name="topPost" action="/anikare/ToppageServlet">
					<input type="submit" name="submit" value="P取得！">
					<c:forEach var="e" items="${cardList}">
						<input type="hidden" name="point_value"
							value="${e.point_value}">
					</c:forEach>
				</form>

			</div>
			<div class="black-background" id="js-black-bg"></div>
		</div>
		<header>
			<div id="aniheader">
				<!--日付表示-->
				<p class="headermoji">
					<span id="time"></span>
				</p>


				<!--- メニューバー --->
				<p class="">
				<div class="drawer">
					<!-- ハンバーガーメニュー表示・非表示切り替え -->
					<input type="checkbox" id="drawer-check" class="drawer-hidden">
					<!-- ハンバーガーアイコン -->
					<label for="drawer-check" class="drawer-open"><span></span></label>
					<nav class="drawer-content">

						<ul class=" drawar-list">
							<li><a href="/anikare/ToppageServlet" class="btn btn-border">トップページ
							</a></li>
							<li><a href="/anikare/ScheduleAddServlet"
								class="btn btn-border">予定・ＴｏＤｏ</a></li>
							<li><a href="/anikare/ScheduleEditServlet"
								class="btn btn-border"> 今日の予定 </a></li>
							<li><a href="/anikare/DiaryServlet" class="btn btn-border">
									日記 一覧 </a></li>
							<li><a href="/anikare/ItemChangeServlet"
								class="btn btn-border">ポイント 交換</a></li>
							<li><a href="/anikare/MypageServlet" class="btn btn-border">
									マイページ </a></li>
							<li><a href="/anikare/LoginServlet" class="btn btn-border">
									ログアウト </a></li>

						</ul>
					</nav>
				</div>

				<!--タイトル-->
				<p class="">
				<h1 class="logo">
					<a href=""><img src="img/logo.png" alt="アニカレロゴ"></a>
				</h1>


				<!--ポイント交換-->
				<!-- <a href ="item_change.jsp">ポイント交換</a></p> -->
				<!-- ポイントデータベースから引っ張ってくる -->

				<a href="/anikare/ItemChangeServlet" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji"><c:forEach var="e" items="${cardList}">${e.point_value}
				</c:forEach>ポイント</p>

			</div>
		</header>



		<div class="maincontents">
			<div class="leftside">
				<!--キャラの吹き出し-->
				<div class="animalcomment">


					<div class="tabbox">
						<!-- ToDo -->
						<input type="radio" name="tabset" id="todoCheck"><label
							for="todoCheck" class="tab">todo</label>

						<!-- 今日の予定 -->
						<input type="radio" name="tabset" id="scheduleCheck" checked><label
							for="scheduleCheck" class="tab">予定</label>

						<!-- 今日の格言 -->
						<input type="radio" name="tabset" id="kakugenCheck"><label
							for="kakugenCheck" class="tab">格言</label>

						<div class="tabcontent" id="schedule"><c:forEach var="e" items="${ScheduleList}" varStatus='status'><a href="/anikare/ScheduleEditServlet"
								>${e.start_time}～${e.title}</a></c:forEach></div>
						<div class="tabcontent" id="todo"><c:forEach var="e" items="${TodolistList}" varStatus='status'><a href="/anikare/ScheduleEditServlet"
								>${e.task} ${e.todo_deadline}まで</a></c:forEach></div>
						<div class="tabcontent" id="kakugen">今日の一言はこちら！<br><c:forEach var="e" items="${KakugenActiveList}" varStatus='status'>${e.mail}</c:forEach><br>今日も一日頑張っていこう！</div>
					</div>
				</div>


				<!--- キャラクター --->
				<div class="animals">
					<c:forEach var="e" items="${CharacterActiveList}">
								<img id="image_chara" src="/anikare/img/${e.mail}">
							</c:forEach>
					<!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
				</div>
			</div>

			<div class="rightside">

				<!--- カレンダー作成　--->

			<div class="calenderwrapper">
				<!-- xxxx年xx月を表示 -->
				<!-- <h1 id="header"></h1> -->

				<!-- ボタンクリックで月移動 -->
				<div id="next-prev-button">
					<button id="prev" onclick="prev()">‹</button>
					<span id="header"></span>
					<button id="next" onclick="next()">›</button>
				</div>

				<!-- カレンダー -->
				<div id="calendar"></div>
			</div>
			</div>
		</div>
	</div>





</body>
</c:forEach>
</html>