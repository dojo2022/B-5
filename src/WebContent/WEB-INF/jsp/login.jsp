<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン|アニカレ</title>
<link rel="stylesheet" href="src/WebContent/css/all.css">
<link rel="stylesheet" href="src/WebContent/css/login.css">
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
					<a href=""><img src="src/WebContent/img/logo.png" alt="アニカレロゴ"></a>
				</h1>

			</div>
		</header>
		<main>
			<div class="main">
				<h2>ログイン</h2>
				<div>
					<form action="#" id="form">
						<label for="Mail">メールアドレス<br> <input type="text"
							name="Mail" placeholder="メールアドレス"></label><br> <label
							for="PW">Password<br> <input type="password"
							name="Password" placeholder="Password"></label><br> <input
							type="submit" name="submit" value="ログイン"> <input
							type="reset" name="reset" value="クリア">
					</form>
					<!-- あっていた場合はそのままログイン、
                    間違っていた場合はエラーの表示をjsで表示する -->
				</div>
			</div>
			<div>
				※新規会員登録はこちら
				<!-- リンクを貼り忘れない -->
			</div>
			<div>
				※パスワードを忘れた方はこちら
				<!-- リンクを貼り忘れない -->
			</div>
		</main>
		<footer class="footer">
			<hr>
			<p>&copy;Copyright AnimalCalender All rights reserved.</p>
			<!-- 要相談 -->
		</footer>
	</div>
</body>
</html>