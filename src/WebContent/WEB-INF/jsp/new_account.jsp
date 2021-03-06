<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
<link rel="stylesheet" type="text/css" href="/anikare/css/new_account.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
</head>
<body>
	<header>
		<h1 class="logo">
			<a href="/anikare/ToppageServlet"><img src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
		</h1>
		<!-- ロゴの挿入 -->
	</header>
	<main>
	<div class="main">
		<h2>新規会員登録</h2>
		<div>
			<form method="POST" action="/anikare/NewAccountServlet" id="form">
				<label for="user_name">ユーザー名<br> <input type="text" class="newform" name="user_name" placeholder="ユーザー名"></label><br>
				<label for="mail">メールアドレス<br><input type="text"  class="newform" name="mail" placeholder="メールアドレス"></label><br>
				<label for="login_pw">Password<br> <input type="password" class="newform" name="login_pw" placeholder="Password"></label><br>
				※すべて入力必須項目になります。<br> <input type="submit" name="submit"value="登録">
				<!-- 登録でログインページに飛ぶ -->
				<!-- userデータベースに登録 -->
				<!-- この内容で登録しますかのjs追加する -->
				<input type="reset" name="reset" value="クリア">
			</form>
		</div>
		<a href="/anikare/LoginServlet">※ログインページはこちら</a>
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
	<script>
		'use strict'
		//更新確認
		/* function clickkakunin(){ */
			 if("${res}" == "ok"){
			}
			else if("${res}" == "miss")
				{
				var clicked = window.confirm('間違いがあります');


			}else{
				console.log("empty");
			}


/* } */
	</script>
</body>
</html>