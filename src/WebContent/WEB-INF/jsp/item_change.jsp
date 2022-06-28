<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<!-- <p class=""> -->
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
				<p class="headermoji">
					<c:forEach var="e" items="${cardList}">${e.point_value}
				</c:forEach>
					ポイント
				</p>
			</div>
		</header>


		<main>
			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">


						<!-- ポイント交換所の説明 -->
						<p>
							ここは今まで貯めたポイントを<br> 様々なものと交換できる場所だよ！<br> 格言と交換をしてくれたら、<br>
							もっとたくさんの言葉を○○さんのために<br> 勉強しておくね！
						</p>
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
						<h1 id="header"></h1>

						<!--- アイテム交換　--->
						<!-- DBから値をもってきて反映させる -->
						<div id="itemlist"></div>
						<h2>アイテム交換リスト</h2>
						<!-- 壁紙リスト -->
						<div class="table-content">
							<table class="td-list">
								<tr>
									<th class="header" colspan="4">壁紙</th>
								</tr>
								<tr>
									<c:forEach var="e" items="${bgList}" begin="0" end="3"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.bg_image}"><br>${e.bg_point}pt<br>
												<input type="hidden" name="background" value="${e.bg_point}">
												<input type="hidden" name="background_id"
													value="${e.background_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${bgList}" begin="4" end="7"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.bg_image}"><br>${e.bg_point}pt<br>
												<input type="hidden" name="background" value="${e.bg_point}">
												<input type="hidden" name="background_id"
													value="${e.background_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${bgList}" begin="8" end="11">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.bg_image}">
												<br>${e.bg_point}pt<br>
												<input
													type="hidden" name="background" value="${e.bg_point}">
												<input type="hidden" name="background_id"
													value="${e.background_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
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
									<c:forEach var="e" items="${wordsList}" begin="0" end="3"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.kakugen_image}"><br>
												${e.genre_name}<br>${e.kakugen_point}pt<br>
												<input
													type="hidden" name="kakugen" value="${e.kakugen_point}">
												<input type="hidden" name="genre_name"
													value="${e.genre_name}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								<tr>
									<c:forEach var="e" items="${wordsList}" begin="4" end="7"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.kakugen_image}"><br>
												${e.genre_name}<br>${e.kakugen_point}pt<br>
												<input
													type="hidden" name="kakugen" value="${e.kakugen_point}">
												<input type="hidden" name="genre_name"
													value="${e.genre_name}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${wordsList}" begin="8" end="11"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.kakugen_image}"><br>
												${e.genre_name}<br>${e.kakugen_point}pt<br>
												<input
													type="hidden" name="kakugen" value="${e.kakugen_point}">
												<input type="hidden" name="genre_name"
													value="${e.genre_name}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
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
									<c:forEach var="e" items="${charactersList}" begin="0" end="3"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.character_image}">
												<br>${e.character_name}
												<br>${e.character_point}pt<br>
												<input
													type="hidden" name="character" value="${e.character_point}">
												<input type="hidden" name="character_id"
													value="${e.character_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${charactersList}" begin="4" end="7">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.character_image}">
												<br>${e.character_name}
												<br>${e.character_point}pt<br>
												<input
													type="hidden" name="character" value="${e.character_point}">
												<input type="hidden" name="character_id"
													value="${e.character_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${charactersList}" begin="8" end="11">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.character_image}">
												<br>${e.character_name}
												<br>${e.character_point}pt<br>
												<input
													type="hidden" name="character" value="${e.character_point}">
												<input type="hidden" name="character_id"
													value="${e.character_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
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
									<c:forEach var="e" items="${couponsList}" begin="0" end="3"
										varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.coupon_image}">
												<br>${e.coupon_point}pt<br>
												<input
													type="hidden" name="coupon" value="${e.coupon_point}">
												<input type="hidden" name="coupon_id" value="${e.coupon_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${couponsList}" begin="4" end="7"
									varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.coupon_image}">
												<br>${e.coupon_point}pt<br>
												<input
													type="hidden" name="coupon" value="${e.coupon_point}">
												<input type="hidden" name="coupon_id" value="${e.coupon_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach var="e" items="${couponsList}" begin="8" end="11"
									varStatus="status">
										<!-- 後でクラス指定して一括で画像サイズを固定 -->
										<td id="list">
											<form id="sub" method="POST"
												action="/anikare/ItemChangeServlet">
												<img width="200px" src="/anikare/img/${e.coupon_image}">
												<br>${e.coupon_point}pt<br>
												<input
													type="hidden" name="coupon" value="${e.coupon_point}">
												<input type="hidden" name="coupon_id" value="${e.coupon_id}">
												<c:forEach var="e" items="${cardList}">
													<input type="hidden" name="point_value"
														value="${e.point_value}">
												</c:forEach>
												<input type="submit" name="submit" value="交換"
													id='item_change${status.index}'>
											</form>
										</td>
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
			//押されたものを読み取る
			/* エレメントを作成 */

			let count = [];

			for (let i = 0; i <= 11; i++) {
				count[i] = document.getElementById('item_change' + i);
				count[i].addEventListener('click', function() {
					console.log('Click' + i);
				});
				count[i].addEventListener('click', check);
			}

			/*  クリックされたときの動作 */
			function check() {
				if (confirm('こちらと交換します。よろしいですか？') == true) {
					alert('交換します！');
				} else {
					alert("交換を中止しました。");
					event.preventDefault();
				}
			}
			count[i].addEventListener('click', check);

			if ("${res}" == "fail") {
				//				var clicked = window
				alert('交換失敗！\nポイントが足りません！');
			} else {
				//				var clicked = window
				alert('ポイントを交換しました！');
			}

		</script>
		<script src="/anikare/js/all.js"></script>
	</div>

</body>
</c:forEach>
</html>