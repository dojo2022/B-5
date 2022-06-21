<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポイント交換所|アニカレ</title>
<link rel="stylesheet" href="/anikare/css/all.css">
<link rel="stylesheet" href="/anikare/css/item_change.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
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
				<!-- <p class=""> -->
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
				<!-- </p> -->
				<!--タイトル-->
				<!-- <p class=""> -->
				<h1 class="logo">
					<a href=""><img src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
				</h1>
				<!-- </p> -->


				<!--ポイント交換-->
				<!-- <a href ="item_change.jsp">ポイント交換</a></p> -->
				<!-- ポイントデータベースから引っ張ってくる -->

				<a href="" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji">ポイント</p>

			</div>
		</header>


		<main>
			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">
						<img scr="ma"><img scr="ma">

						<!-- ポイント交換所の説明 -->
						<p>
							ここは今まで貯めたポイントを<br> 様々なものと交換できる場所だよ！<br> 格言と交換をしてくれたら、<br>
							もっとたくさんの言葉を○○さんのために<br> 勉強しておくね！
						</p>
					</div>

					<!--- キャラクター --->
					<div class="animals">
						<img src="/anikare/img/animal_zou.png">
						<!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
					</div>
				</div>
				<div class="rightside">
					<!--- カレンダー --->
					<div class="main">
						<h1 id="header"></h1>

						<!--- アイテム交換　--->
						<!-- DBから値をもってきて反映させる -->
						<div id="itemlist"></div>
						<h2>アイテム交換リスト</h2>
						<!-- 壁紙リスト -->
						<div class="table-content">
							<table class="td-list" >
								<tr>
									<th class="header" colspan="4">壁紙</th>
								</tr>
								<tr>
								<c:forEach var="e" items="${bgList}" begin="0" end="3"  varStatus="status">
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td id="list" width="200px" >${e.bg_image}<br>${e.bg_point}<br>
									<input type="button" value="交換" id='item_change${status.index}'></td>

								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${bgList}" begin="4" end="7" varStatus="status">
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.bg_image}<br>${e.bg_point}<br>
									<input type="button" value="交換" id='item_change${status.index}'></td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${bgList}" begin="8" end="11" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.bg_image}<br>${e.bg_point}</td>
								</c:forEach>
								</tr>
								<!-- 要素が増えたらこのfor文を追加する -->
							</table>
						</div>
						<!-- 格言リスト -->
						<div class="table-content">
							<table class="td-list">
								<tr>
									<th class="header" colspan="4">格言</th>
								</tr>
								<tr>
								<c:forEach var="e" items="${wordsList}" begin="0" end="3" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.genre_name}<br>${e.kakugen_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${wordsList}" begin="4" end="7" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.genre_name}<br>${e.kakugen_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${wordsList}" begin="8" end="11" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.genre_name}<br>${e.kakugen_point}</td>
								</c:forEach>
								</tr>
								<!-- 要素が増えたらこのfor文を追加する -->
							</table>
						</div>
						<!-- キャラクターリスト -->
						<div class="table-content">
							<table class="td-list">
								<tr>
									<th class="header" colspan="4">キャラクター</th>
								</tr>
								<tr>
								<c:forEach var="e" items="${charactersList}" begin="0" end="3" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.character_image}<br>${e.character_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${charactersList}" begin="4" end="7" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.character_image}<br>${e.character_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${charactersList}" begin="8" end="11" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.character_image}<br>${e.character_point}</td>
								</c:forEach>
								</tr>
								<!-- 要素が増えたらこのfor文を追加する -->
							</table>
						</div>
						<!-- クーポンリスト -->
						<div class="table-content">
							<table class="td-list">
								<tr>
									<th class="header" colspan="4">クーポン</th>
								</tr>
								<tr>
								<c:forEach var="e" items="${couponsList}" begin="0" end="3" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.coupon_image}<br>${e.coupon_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${couponsList}" begin="4" end="7" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.coupon_image}<br>${e.coupon_point}</td>
								</c:forEach>
								</tr>
								<tr>
								<c:forEach var="e" items="${couponsList}" begin="8" end="11" >
									<!-- 後でクラス指定して一括で画像サイズを固定 -->
									<td width="200px">${e.coupon_image}<br>${e.coupon_point}</td>
								</c:forEach>
								</tr>
								</table>
						</div>
					</div>
				</div>
			</div>

		</main>
		<footer class="footer">
			<p>&copy;Copyright AnimalCalender All rights reserved.</p>
			<!-- 要相談 -->
		</footer>
		<script>
  'use strict'
  function recalc(){
  let dayOfWeek = ['Sun.', 'Mon.', 'Tue.', 'Wed.', 'Thu.', 'Fri.', 'Sat.'];
  const now=new Date();
  const month = now.getMonth()+1;
  const date = now.getDate();
  const day = now.getDay();


  document.getElementById('time').textContent = month + '/' + date + ''
  + '(' + dayOfWeek[now.getDay()] + ')';
  refresh();
  }

  function refresh() {
  setTimeout(recalc, 1000);
  }
recalc();

//押されたものを読み取る
/* エレメントを作成 */

let count=[];

for (let i =0; i<= 11; i++){
	count[i] = document.getElementById('item_change' + i);
	count[i].addEventListener('click', function(){
    console.log('Click'+i);
});
	count[i].addEventListener('click', check);
}
/*  クリックされたときの動作 */
function check(){
    if (confirm('こちらと交換します。よろしいですか？') == true) {
   	alert("交換します！");
    } else {
	alert("交換を中止しました。");
    }
    console.log(check);
}
count[i].addEventListener('click', check);
//どれが押されたかを読み取る getElementById
//押されたもののポイントを変数に入れる
//今所持してるポイントと比べる
//少ない時はアラート
//多い時はサーブレットに移動（ポイントの減額と、所持アイテムの追加,id


</script>
	</div>

</body>
</html>