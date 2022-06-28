<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">



 <link rel="stylesheet" type="text/css" href="/anikare/css/toppage.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="wrapper">
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
							<li><a href="/anikare/ToppageServlet" class="btn btn-border">トップページ </a></li>
							<li><a href="/anikare/ScheduleAddServlet" class="btn btn-border">予定・ＴｏＤｏ</a></li>
							<li><a href="/anikare/ScheduleEditServlet" class="btn btn-border"> 今日の予定 </a></li>
							<li><a href="/anikare/DiaryServlet" class="btn btn-border"> 日記 一覧 </a></li>
							<li><a href="/anikare/ItemChangeServlet" class="btn btn-border">ポイント 交換</a></li>
							<li><a href="/anikare/MypageServlet" class="btn btn-border"> マイページ </a></li>
							<li><a href="/anikare/LoginServlet" class="btn btn-border"> ログアウト </a></li>

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

				<a href="" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji">ポイント</p>

			</div>
		</header>



			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">


						<!-- ToDo -->

						<!-- 今日の予定 -->
						<p>今日はランチ！</p>
						<!-- 今日の格言 -->
						<p>あああああああああああああああああああああああああああ</p>
					</div>

					<!--- キャラクター --->
					<div class="animals">
						<img src="img/animal_zou.png">
						<!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
					</div>
				</div>

				<div class="rightside">

					<!--- カレンダー　--->
				<div class="container">
  <input type="date" name="date">
  <p id="output">Change the Date</p>
</div>



    <script>
    let date = document.querySelector(`input[type='date'][name='date']`);

    date.addEventListener(`change`, () => {
      document.querySelector(`#output`).innerHTML = date.value;
    });
    </script>

				</div>
					</div>

					</div>


		<footer> </footer>






</body>
</html>
 --%>

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
</head>
<body>
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
				<c:forEach var="e" items="${cardList}">${e.point_value}
				</c:forEach>

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
						<div class="tabcontent" id="kakugen">頑張れ</div>
					</div>
				</div>


				<!--- キャラクター --->
				<div class="animals">
					<img src="img/animal_zou.png">
					<!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
				</div>
			</div>

			<div class="rightside">

				<!--- カレンダー作成　--->
			</div>
			<div class="wrapper">
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



	<script>
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

		// カレンダー作成
		function createProcess(year, month) {
			// 曜日
			var calendar = "<table class='caltab'><tr class='dayOfWeek'>";
			for (var i = 0; i < week.length; i++) {
				calendar += "<th>" + week[i] + "</th>";
			}
			calendar += "</tr>";

			var count = 0;
			var startDayOfWeek = new Date(year, month, 1).getDay();
			var endDate = new Date(year, month + 1, 0).getDate();
			var lastMonthEndDate = new Date(year, month, 0).getDate();
			var row = Math.ceil((startDayOfWeek + endDate) / week.length);

			// 1行ずつ設定
			for (var i = 0; i < row; i++) {
				calendar += "<tr>";
				// 1colum単位で設定
				for (var j = 0; j < week.length; j++) {
					if (i == 0 && j < startDayOfWeek) {
						// 1行目で1日まで先月の日付を設定
						calendar += "<td class='disabled'>"
								+ (lastMonthEndDate - startDayOfWeek + j + 1)
								+ "</td>";
					} else if (count >= endDate) {
						// 最終行で最終日以降、翌月の日付を設定
						count++;
						calendar += "<td class='disabled'>" + (count - endDate)
								+ "</td>";
					} else {
						// 当月の日付を曜日に照らし合わせて設定
						count++;
						if (year == today.getFullYear()
								&& month == (today.getMonth())
								&& count == today.getDate()) {
							calendar += "<td class='today'>" + count + "</td>";
						} else {
							calendar += "<td>" + count + "</td>";
						}
					}
				}
				calendar += "</tr>";
			}
			return calendar;
		}

		//ポップアップ表示
		window.onload = function() {
			var popup = document.getElementById('js-popup');
			if (!popup)
				return;
			popup.classList.add('is-show');

			var blackBg = document.getElementById('js-black-bg');
			var closeBtn = document.getElementById('js-close-btn');

			closePopUp(blackBg);
			closePopUp(closeBtn);

			function closePopUp(elem) {
				if (!elem)
					return;
				elem.addEventListener('click', function() {
					popup.classList.remove('is-show');
				})
			}
		}
	</script>

</body>

</html>