<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>アニカレ</title>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
<link rel="stylesheet" type="text/css" href="/anikare/css/diary.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
</head>
<c:forEach var="e" items="${BackgroundActiveList}">
	<body background="/anikare/img/${e.mail}">
	<div class="wrapper">
		<header>
			<div id="aniheader">
				<!--日付表示-->
				<p class="headermoji">
					<span id="time"></span>
				</p>


				<!--- メニューバー --->

				<div class="drawer">
					<!-- ハンバーガーメニュー表示・非表示切り替え -->
					<input type="checkbox" id="drawer-check" class="drawer-hidden">
					<!-- ハンバーガーアイコン -->
					<label for="drawer-check" class="drawer-open"><span></span></label>
					<nav class="drawer-content">
						<!-- リンクをつなげる -->
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

				<h1 class="logo">
					<a href="/anikare/ToppageServlet"><img src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
				</h1>



				<!--ポイント交換-->
				<!-- <a href ="item_change.jsp">ポイント交換</a></p> -->
				<!-- ポイントデータベースから引っ張ってくる -->

				<!-- <a href="" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji">ポイント</p> -->

				<a href="/anikare/ItemChangeServlet" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji"><c:forEach var="e" items="${cardList}">${e.point_value}ポイント
				</c:forEach></p>
			</div>
		</header>


		<main>
			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">
						<!-- <img scr="ma"><img scr="ma"> -->

						<!-- ToDo -->

						<!-- 今日の予定 -->
						<p>今までの日記を確認してね！</p><br>
						<p>→マークから詳細を確認できるよ</p>

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
					<!--- カレンダー --->
					<div class="main">
					<h2 class="h2"><img src="/anikare/img/diarylist.png" alt="日記一覧"></h2>
						<!-- 月表示 -->
						<!--- ボタン　月移動 --->
						<div id="next-prev-button">
							<button id="prev" onclick="prev()">前月</button>
							<span id="header"></span>
							<button id="next" onclick="next()">次月</button>
						</div>
						<div id="calendar"></div>
						<!--- 日記一覧ー　本当はforEachで繰り返し--->
						<div class="table-contents">

							<table class="start_list">
								<tr>
									<th class="dDay">day</th>
									<th class="dTitle">title</th>
								</tr>
							</table>
							<c:forEach var="e" items="${diaryList}" varStatus='status'>
								<form method="POST" name="diaryPost" action="/anikare/DiaryServlet">
									<table class="start_list">


										<tr class='row_count'>
											<td>${e.diary_date}
											<input type="hidden" name="date"
												value="${e.diary_date}">
											</td>
											<%-- <td >
											<div id='diary_title${status.count}' onClick="this.form.submit();">${e.diary_title}</div>
											<a href="javascript:document.diaryPost.submit()">${e.diary_title}</a>
											</td> --%>
											<td>
											${e.diary_title}
											<input type="hidden"
												name="title" value="${e.diary_title}">
											<input type="submit" name="submit" value="→">
											</td>





										</tr>



									</table>
								</form>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</main>
		<footer class="footer">
		<div class="footerimg">
	<img src="img/anifooter1.png">
	<img src="img/anifotter2.png">
	<img src="img/anifooter3.png"></div>
			<p>&copy;Copyright AnimalCalender All rights reserved.</p>
			<!-- 要相談 -->
		</footer>
		<script type="text/javascript">
			'use strict'
/* const counts =document.getElementsByClassName("row_count");
console.log(counts.length);
let title=[]; */
/* エレメントを作成 */
/* for (let i =1 ;i<counts.length;i++){
	title[i] = document.getElementById('diary_title'+i);
}
function sub(){
	console.log(' onclick'+i);
	document.diaryPost.submit();
} */
/*  クリックされたときの動作 */
 /* for (let i =1 ;i<counts.length;i++){

 title[i].addEventListener('click',function(){
		 console.log(' event click'+i);
		 submit機能
		 document.diaryPost.submit();
	 });
 } */




			const week = [ "日", "月", "火", "水", "木", "金", "土" ];
			const today = new Date();
			// 月末だとずれる可能性があるため、1日固定で取得
			var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

			// 初期表示
			window.onload = function() {
				showProcess(today, calendar);
			};
			// 前の月表示
			function prev() {
				showDate.setMonth(showDate.getMonth() - 1);
				showProcess(showDate);
			}

			// 次の月表示
			function next() {
				showDate.setMonth(showDate.getMonth() + 1);
				showProcess(showDate);
			}

			// カレンダー表示
			function showProcess(date) {
				var year = date.getFullYear();
				var month = date.getMonth();
				document.querySelector('#header').innerHTML = year + "年 "
						+ (month + 1) + "月";

				var calendar = createProcess(year, month);
				document.querySelector('#calendar').innerHTML = calendar;
			}
		</script>
		<script src="/anikare/js/all.js"></script>
	</div>
</body>
</c:forEach>
</html>