<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン|アニカレ</title>
<link rel="stylesheet" href="/anikare/css/all.css">
<link rel="stylesheet" href="/anikare/css/login.css">
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
				<!--タイトル-->

				<h1 class="logo">
					<a href=""><img src="/anikare/img/logo.png" alt="アニカレロゴ"></a>
				</h1>

			</div>
		</header>
		<main>
			<div class="main">
				<h2>ログイン</h2>
				<div class="loginform">
					<form method="POST" action="/anikare/LoginServlet" id="form">
						<label for="Mail">メールアドレス<br> <input type="text"
							 class="loginform1" name="mail" placeholder="メールアドレス"></label><br> <label
							for="login_pw">Password<br> <input type="password" class="loginform1"
							name="login_pw" placeholder="Password"></label><br> <input
							type="submit" name="submit" value="ログイン"> <input
							type="reset" name="reset" value="クリア">
					</form>
					<!-- あっていた場合はそのままログイン、
                    間違っていた場合はエラーの表示をjsで表示する -->
				</div>
			</div>
			<div class="nalink">
				<a href="/anikare/NewAccountServlet">※新規会員登録はこちら</a>
				<!-- リンクを貼り忘れない -->
			</div>
			<div class="prlink">
				<a href="/anikare/PasswordResetServlet">※パスワードを忘れた方はこちら</a>
				<!-- リンクを貼り忘れない -->
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

	</div>
	<script>
		'use strict'
		//更新確認
		/* function clickkakunin(){ */
		if ("${res}" == "fail") {
			var clicked = window
					.confirm('メールアドレスもしくはPWが間違っています。\n再度入力をしてください。');
		} else {
			console.log("empty");
		}

		/* } */
	</script>
</body>
</html>