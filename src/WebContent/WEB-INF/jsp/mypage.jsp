<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
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
				<p>
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
				</p>
				<!--タイトル-->
				<p>
				<h1 class="logo">
					<a href="/anikare/ToppageServlet"><img
						src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
				</h1>
				</p>
				<!--ポイント交換-->
				<!-- <a href ="/anikare/MypageServlet">ポイント交換</a></p> -->
				<!-- ポイントデータベースから引っ張ってくる -->

				<a href="" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji">ポイント</p>

			</div>
		</header>


		<main id="city">
			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">
						マイページ<br> マイページ<br> マイページ<br> マイページ<br>

					</div>

					<!--- キャラクター --->
					<div class="animals">
						<img id="image_chara" src="/anikare/img/animal_zou.png">
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
								<input type="submit" name="submit" value="更新"> <input
									type="reset" name="reset" value="クリア">
								<h3>パスワード</h3>
								現在のパスワード: <input type="text" name="now_pw" value=""><br>
								新しいパスワード: <input type="text" name="new_pw" value=""><br>

								<!-- 現在のパスワードがあっていればテキストボックス→データベースを更新 間違っていれば違いますのアラート-->
								<input type="submit" name="submit" value="更新"> <input
									type="reset" name="reset" value="クリア">
							</form>



						</div>

						<div class="my_item">
							<h2>sampleさん所持アイテム一覧</h2>
							<h3>壁紙</h3>
							<button onclick="effect_bg()">壁紙を書き換える</button>
							<c:forEach var="e" items="${backgroundItemsList}">
							${e.bg_name}
							<img id="image_bg" src="/anikare/img/${e.bg_image}">
							</c:forEach>


							<!-- background_itemsから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>格言</h3>
							<c:forEach var="e" items="${KakugenItemsList}">
							${e.genre_name}
							<img id="image_bg" src="/anikare/img/${e.kakugen_image}">
							</c:forEach>
							<!-- kakugen_itemsから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>キャラクターカスタマイズ</h3>
							<a href="javascript:void(0);" onclick="LinkClick(0);">象</a> <br>
							<a href="javascript:void(0);" onclick="LinkClick(1);">ライオン</a>
							<c:forEach var="e" items="${CharacterItemsList}">
							${e.character_name}
							<img id="image_chara" src="/anikare/img/${e.character_image}">
							</c:forEach>
							<!-- charcterから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>クーポン</h3>
							<c:forEach var="e" items="${CouponItemsList}">
							${e.coupon_name},${e.coupon_name}
							<img id="image_chara" src="/anikare/img/${e.coupon_image}">
							</c:forEach>
							<!-- coupon_itemsから要素を順番に表示 -->
							<input type="submit" name="submit" value="使用">
						</div>




					</div>
				</div>
			</div>

		</main>
		<footer> </footer>
		<script>
			'use strict'
			function recalc() {
				let dayOfWeek = [ 'Sun.', 'Mon.', 'Tue.', 'Wed.', 'Thu.',
						'Fri.', 'Sat.' ];
				const now = new Date();
				const month = now.getMonth() + 1;
				const date = now.getDate();
				const day = now.getDay();

				document.getElementById('time').textContent = month + '/'
						+ date + '' + '(' + dayOfWeek[now.getDay()] + ')';
				refresh();
			}

			function refresh() {
				setTimeout(recalc, 1000);
			}
			recalc();

			function effect_bg() {
				var element = document.getElementById("city");
				element.style.backgroundImage = 'url(/anikare/img/city.jpg)';
				//element.style.background = '#c0c0c0';
			}

			function LinkClick(param) {
			      var elem = document.getElementById("image_chara");

			      switch (param) {
			        case 0:
			          elem.src = "/anikare/img/animal_zou.png";
			          break;
			        case 1:
			          elem.src = "/anikare/img/animal_lion.png";
			          break;

			        default:
			          elem.src = "/anikare/img/character.jpg";
			          break;
			      }
			    }
		</script>
	</div>

</body>
</html>