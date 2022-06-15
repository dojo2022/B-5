<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<li><a href="/anikare/ToppageServlet.java" class="btn btn-border">トップページ </a></li>
							<li><a href="ScheduleAddServlet.java" class="btn btn-border">予定・ＴｏＤｏ</a></li>
							<li><a href="ScheduleEditServlet.java" class="btn btn-border"> 今日の予定 </a></li>
							<li><a href="DiaryServlet.java" class="btn btn-border"> 日記 一覧 </a></li>
							<li><a href="ItemChangeServlet.java" class="btn btn-border">ポイント 交換</a></li>
							<li><a href="MypageServlet.java" class="btn btn-border"> マイページ </a></li>
							<li><a href="LoginServlet.java" class="btn btn-border"> ログアウト </a></li>
						</ul>
					</nav>
				</div>
				</p>
				<!--タイトル-->
				<p>
				<h1 class="logo">
					<a href="/anikare/ToppageServlet.java"><img src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
				</h1>
				</p>


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
						<img src="ma"><img scr="ma">


					</div>

					<!--- キャラクター --->
					<div class="animals">
						<img src="src/WebContent/img/animal_zou.png">
						<!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
					</div>
				</div>
				<div class="rightside">
					<!--- mypage --->
					<div class="main">
						<h1 id="header"></h1>
						<div class="my_data">

							<h2>ユーザー情報変更</h2>
							<details>
								<h3>ユーザー名</h3>
								<!-- データベースから持ってくる -->
								現在のユーザー名:sample
								</br>
								新しいユーザー名:
								<input type="text" name="new_name" value="">
								</br>
								<!-- 更新押したらテキストボックス その後データベースを更新-->
								<input type="submit" name="submit" value="更新">
								<input type="reset" name="reset" value="クリア">
								<h3>パスワード</h3>
								現在のパスワード:
								<input type="text" name="now_password" value="">
								</br> 新しいパスワード:
								<input type="text" name="new_password" value="">
								</br>
								<!-- 現在のパスワードがあっていればテキストボックス→データベースを更新 間違っていれば違いますのアラート-->
								<input type="submit" name="submit" value="更新">
								<input type="reset" name="reset" value="クリア">
							</details>
						</div>

						<div class="my_item">
							<h2>sampleさん所持アイテム一覧</h2>
							<h3>壁紙</h3>
							<!-- background_itemsから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>格言</h3>
							<!-- kakugen_itemsから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>キャラクターカスタマイズ</h3>
							<!-- charcterから要素を順番に表示 -->
							<input type="submit" name="submit" value="変更">
							<h3>クーポン</h3>
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


</script>
	</div>
</body>
</html>