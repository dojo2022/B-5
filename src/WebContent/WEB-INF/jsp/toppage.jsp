<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	休業日<br>



    <script>
    import '@grapecity/inputman/CSS/gc.inputman-js.css';
    import { InputMan } from '@grapecity/inputman';
    import "./styles.css";

    const gcCalendar1 = new InputMan.GcCalendar(document.getElementById('gcCalendar1'));
    gcCalendar1.getWeekday('sunday').setWeekFlags(InputMan.WeekFlags.All);
    gcCalendar1.getWeekday('saturday').setWeekFlags(InputMan.WeekFlags.All);

    const gcCalendar2 = new InputMan.GcCalendar(document.getElementById('gcCalendar2'), {
        headerFormat: 'gggE年 M月',
        yearMonthFormat: 'gggE年,M月'
    });

    const gcCalendar3 = new InputMan.GcCalendar(document.getElementById('gcCalendar3'), {
        showRokuyou: InputMan.Rokuyou.All
    });

    const gcCalendar4 = new InputMan.GcCalendar(document.getElementById('gcCalendar4'), {
        calendarDimensions: {
            width: 3,
            height: 2
        }
    });


    </script>

				</div>
					</div>

					</div>


		<footer> </footer>






</body>
</html>

