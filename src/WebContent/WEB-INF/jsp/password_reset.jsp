<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW再設定|アニカレ</title>
<link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
<link rel="stylesheet" type="text/css"
	href="/anikare/css/password_reset.css">
</head>
<body>
	<header>
		<h1 class="logo">
			<img src="/anikare/img/logo.png" alt="アニカレロゴ">
		</h1>
		<!-- ロゴの挿入 -->
	</header>
	<main>
		<h2>pw再設定ページ</h2>

		<div>
			<form method="POST" action="/anikare/PasswordResetServlet" id=form>
				<label for="Mail">メールアドレス<br> <input type="text"
					name="Mail" placeholder="メールアドレス"></label><br>
				<p>※登録されているメールアドレスを入力してください。</p>
				<p>ログイン用の仮PWを発行致します。</p>
				<input type="submit" name="submit" value="確認">
					<!-- onclick="return clickkakunin()" -->
					 <input type="reset"
					name="reset" value="クリア">
			</form>
		</div>
	</main>
	<footer class="footer">
		<p>&copy;Copyright AnimalCalender All rights reserved.</p>
		<!-- 要相談 -->
	</footer>
	<script>
		'use strict'
		//更新確認
		/* function clickkakunin(){ */
			if("${res}" == "ok"){
				var clicked = window.confirm('再設定用のパスワードはこちらです');

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