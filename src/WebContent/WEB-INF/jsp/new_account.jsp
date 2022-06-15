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
	<header>
		<h1 class="logo">
			<img src="/anikare/img/logo.png" alt="アニカレロゴ">
		</h1>
		<!-- ロゴの挿入 -->
	</header>
	<main>
		<h2>新規会員登録</h2>
		<div>
			<form action="#" id="form">
				<label for="Mail">ユーザー名<br> <input type="text"
					name="Mail" placeholder="ユーザー名"></label><br> <label for="Mail">メールアドレス<br>
					<input type="text" name="Mail" placeholder="メールアドレス"></label><br>
				<label for="PW">Password<br> <input type="password"
					name="Password" placeholder="Password"></label><br>
				※すべて入力必須項目になります。<br> <input type="submit" name="submit"
					value="登録">
				<!-- 登録でログインページに飛ぶ -->
				<!-- userデータベースに登録 -->
				<!-- この内容で登録しますかのjs追加する -->
				<input type="reset" name="reset" value="クリア">
			</form>
		</div>
		<div></div>
	</main>
	<footer class="footer">
		<p>&copy;Copyright AnimalCalender All rights reserved.</p>
		<!-- 要相談 -->
	</footer>
</body>
</html>