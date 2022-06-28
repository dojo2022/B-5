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
		<div id="aniheader">
			<h1 class="logo">
				<img src="/anikare/img/logo.png" alt="アニカレロゴ">
			</h1>
			<!-- ロゴの挿入 -->
		</div>
	</header>

	<main>
		<div class="main">
			<h2>pw再設定ページ</h2>

			<div>
				<form method="POST" action="/anikare/PasswordResetServlet" id=form>
					<label for="Mail">メールアドレス<br>
					 <input type="text"	class="prform" name="Mail" placeholder="メールアドレス"></label><br>
					<p>※登録されているメールアドレスを入力してください。</p>
					<p>ログイン用の仮PWを発行致します。</p>
					<input type="submit" name="submit" value="確認">
					  <!--  onclick="return clickkakunin()"-->
	<!-- 				<button onclick="btnClick();">確認</button>
	 -->				<!-- onclick="return clickkakunin()" -->
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
		/* function btnCliick() {
			//ランダムパスワード生成
			let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
			let rand_str = '';
			for (var i = 0; i < 8; i++) {
				rand_str += chars.charAt(Math.floor(Math.random()
						* chars.length));
			}
			function randomInt(num) {
				var rand = Math.floor(Math.random() * num);

				return rand;
			}
			let random_pw = randomInt(100) + rand_str + randomInt(100)
			//メールのデータを照合する
			function postForm(value) {

						var form = document.createElement('form');
						var request = document.createElement('input');

						form.method = 'POST';
						form.action = '/anikare/PasswordResetServlet';

						request.type = 'hidden'; //入力フォームが表示されないように
						request.name = 'text';
						request.value = value;

						form.appendChild(request);
						document.body.appendChild(form);

						form.submit();

					}
				postForm('Mail')

				//confirmダイアログを出す
			if ("${res}" == "ok") {
				var clicked = window.confirm('再設定用のパスワードはこちらです[' + random_pw
						+ ']');
				if (clicked) {
					//OKなのでPOSTする
					function postForm(value) {

						var form = document.createElement('form');
						var request = document.createElement('input');

						form.method = 'POST';
						form.action = '/anikare/PasswordResetServlet';

						request.type = 'hidden'; //入力フォームが表示されないように
						request.name = 'text';
						request.value = value;

						form.appendChild(request);
						document.body.appendChild(form);

						form.submit();

					}
					postForm(random_pw)

				//投げっぱなしでログイン画面に遷移する
				window.href = "http://localhost:8080/anikare/LoginServlet";
				}
			} else if ("${res}" == "miss") {
				var clicked = window.confirm('間違いがあります');

			} else {
				console.log("empty");
			}
		} */
		//更新確認
	/* function clickkakunin(){ */
			/* let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
			let rand_str = '';
			for ( var i = 0; i < 8; i++ ) {
				rand_str += chars.charAt(Math.floor(Math.random() * chars.length));
			}
			function randomInt(num){
				  var rand = Math.floor(Math.random() * num);

				  return rand;
			}
			let random_pw=randomInt(100) +rand_str +randomInt(100)
 */
 //${newpass}でデータ取り出す
		if("${res}" == "ok"){
			window.confirm('再設定用のパスワードはこちらです['+"${pas}"+']\nログイン後は、マイページから再設定を行ってください');
			/* if (clicked){
			//サーブレットにpostする。
			function postForm(value) {

			    var form = document.createElement('form');
			    var request = document.createElement('input');

			    form.method = 'POST';
			    form.action = '/anikare/PasswordResetServlet';

			    request.type = 'hidden'; //入力フォームが表示されないように
			    request.name = 'text';
			    request.value = value;

			    form.appendChild(request);
			    document.body.appendChild(form);

			    form.submit();


			}
			postForm(random_pw)
			} */
		}
		else if("${res}" == "miss")
			{
			window.confirm('メールアドレスに間違いがあります。');

		}else{
			console.log("empty");

		}
	</script>

</body>
</html>