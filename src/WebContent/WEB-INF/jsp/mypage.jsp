<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
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

							<ul class=" drawar-list">
								<li><a href="/anikare/ToppageServlet"
									class="btn btn-border">トップページ </a></li>
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
						<a href="/anikare/ToppageServlet"><img
							src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
					</h1>

					<!--ポイント交換-->
					<!-- <a href ="/anikare/ItemChangeServlet">ポイント交換</a></p> -->
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
							マイページ<br> マイページ<br> マイページ<br> マイページ<br>

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
						<!--- mypage --->
						<div class="main">
							<h1 id="header"></h1>
							<div class="my_data">

								<h2>ユーザー情報変更</h2>



								<form method="POST" action="/anikare/MypageServlet" id="form">
									<h3>ユーザー名</h3>
									<!-- データベースから持ってくる -->
									<c:forEach var="e" items="${cardList}">
										現在のユーザー名:${e.user_name}<br>
										新しいユーザー名: <input type="text" name="new_name">
										<br>
									</c:forEach>
									<!-- 更新押したらテキストボックス その後データベースを更新-->
									<input type="submit" name="namechange" value="更新"> <input
										type="reset" name="reset" value="クリア">
									<h3>パスワード</h3>
									現在のパスワード: <input type="text" name="now_pw" value=""><br>
									新しいパスワード: <input type="text" name="new_pw" value=""><br>

									<!-- 現在のパスワードがあっていればテキストボックス→データベースを更新 間違っていれば違いますのアラート-->
									<input type="submit" name="passchange" value="更新"> <input
										type="reset" name="reset" value="クリア">
								</form>



							</div>

							<div class="my_item">
								<h2>所持アイテム一覧</h2>


								<table>
									<tr>
										<th>壁紙</th>
									</tr>
								</table>

								<table>


									<tr>
										<c:forEach var="e" items="${backgroundItemsList}">
											<td width="200px"><img width="200px" id="bg_image"
												name="bg_image" src="/anikare/img/${e.bg_image}"><br>
												<p>${e.bg_name}</p></td>
											<td><form method="POST" action="/anikare/MypageServlet"
													id="form">
													<input type="hidden" name="bg_name" value="${e.bg_name}">
													<input type="submit" name="bgchange" value="変更">
												</form></td>
										</c:forEach>
									</tr>

								</table>



								<table>
									<tr>
										<th>格言</th>
									</tr>
								</table>


								<table>
									<tr>
										<c:forEach var="e" items="${KakugenItemsList}">
											<td width="200px"><img width="200px" id="bg_image"
												name="kakugen_image" src="/anikare/img/${e.kakugen_image}"><br>
												<p>${e.genre_name}</p> <input type="hidden"
												name="kakugen_name" value="${e.genre_name}"></td>
											<td><form method="POST" action="/anikare/MypageServlet"
													id="form">
													<input type="submit" name="kakugenchange" value="格言の変更">
												</form></td>
										</c:forEach>
									</tr>
								</table>




								<table>
									<tr>
										<th>キャラクターカスタマイズ</th>
									</tr>
								</table>




								<table>
									<tr>
										<c:forEach var="e" items="${CharacterItemsList}"
											varStatus="status">
											<td width="200px"><img width="200px"
												id="character_image" name="character_image"
												src="/anikare/img/${e.character_image}"><br>
												${e.character_name} <input type="hidden"
												name="character_name" value="${e.character_name}"></td>
											<td><form method="POST" action="/anikare/MypageServlet"
													id="form">
													<input id="${status.index}" type="submit"
														name="characterchange" value="キャラクターの変更">
												</form></td>
										</c:forEach>
									</tr>
								</table>



								<table>
									<tr>
										<th>クーポン</th>
									</tr>
								</table>
								<table>
									<tr>
										<c:forEach var="e" items="${CouponItemsList}">
											<td width="200px"><img width="200px" id="bg_image"
												name="bg_image" src="/anikare/img/${e.coupon_image}"><br>
												${e.coupon_name}</td>


											<td><form method="POST" action="/anikare/MypageServlet"
													id="form">
													<input type="submit" name="submit" value="クーポンの使用">
												</form></td>
										</c:forEach>
									</tr>
								</table>

							</div>
						</div>
					</div>
				</div>

			</main>
			<footer> </footer>
			<script src="/anikare/js/all.js">

			</script>

		</div>

	</body>
</c:forEach>
</html>