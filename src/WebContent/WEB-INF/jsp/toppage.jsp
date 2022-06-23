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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">

<link rel="stylesheet" type="text/css" href="/anikare/css/toppage.css">
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
	</script>
</body>

</html>