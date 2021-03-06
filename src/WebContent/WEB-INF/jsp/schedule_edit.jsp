<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>アニカレ</title>
<link rel="stylesheet" href="/anikare/css/all.css">
<link rel="stylesheet" href="/anikare/css/schedule_edit.css">
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

				<!--タイトル-->
				<h1 class="logo">
					<a href="/anikare/ToppageServlet"><img src="img/logo.png"
						alt="アニカレロゴ"></a>
				</h1>

				<!--ポイント交換-->
				<a href="/anikare/ItemChangeServlet" class="pointbtn btn-flat"><span>ポイント交換</span></a>
				<p class="headermoji"><c:forEach var="e" items="${cardList}">${e.point_value}
				</c:forEach>ポイント</p>

			</div>
		</header>

		<main>
			<div class="maincontents">
				<div class="leftside">
					<!--キャラの吹き出し-->
					<div class="animalcomment">
						<!--<img scr="ma"><img scr="ma">-->
						<p>
							予定・ToDoリストの編集<br>日記の記入ができるよ～<br>日記を記入してポイントをゲットしよう！
						</p>
					</div>

					<!--- キャラクター --->
					<div class="animals">
						<c:forEach var="e" items="${CharacterActiveList}">
								<img id="image_chara" src="/anikare/img/${e.mail}">
							</c:forEach>
					</div>
				</div>


				<div class="rightside">
					<div class="edit">
						<!-- 予定編集 -->
						<div class="scheduleedit">
							<h2 class="h2"><img src="img/todaylogo.png" alt="今日の予定"></h2>
							<c:forEach var="e" items="${ScheduleList}" varStatus='status'>
								<form method="POST" action="/anikare/ScheduleEditServlet">

									<details>
										<summary>
											<select id="stampselect" name="stamp_id">
												<option value="1" ${e.stamp_id == '1' ? 'selected' : ''}>🍚</option>
												<option value="2" ${e.stamp_id == '2' ? 'selected' : ''}>💛</option>
												<option value="3" ${e.stamp_id == '3' ? 'selected' : ''}>⛰</option>
											</select> <input type="text" class="titlefont" name="title"
												placeholder="タイトルを入力" value="${e.title}">
										</summary>
										<table>
											<tr>
												<td><input type="text" class="shorttext"
													name="start_time" placeholder="12:00"
													value="${e.start_time}">～</td>
												<td><input type="text" class="shorttext"
													name="end_time" placeholder="14:00" value="${e.end_time}"></td>
											</tr>
											<tr>
												<td><input type="text" class="shorttext" name="place"
													placeholder="場所" value="${e.place}"></td>
													<td><input type="hidden" name="user_id"
													value="${e.user_id}"><input type="hidden" name="schedule_date"
													value="${e.schedule_date}"></td>
											</tr>
											<tr>
												<td colspan="2"><input type="text" class="longtext"
													name="schedule_memo" placeholder="ここにメモを記入"
													value="${e.schedule_memo}"></td>
											</tr>
										<tr><td colspan="2">
										<div class="input_wrapper">
											<input class="hover" type="submit" name="SUBMIT" value="予定削除" onsubmit="doSomething();return false;">
											<input class="hover" type="submit" name="SUBMIT" value="予定更新" onsubmit="doSomething();return false;">
										</div>
										</td></tr>
										</table>
									</details>
								</form>
							</c:forEach>
						</div>

						<!-- ToDo編集 -->
						<div class="todoedit">
							<h2 class="h2"><img src="img/todologo.png" alt="ToDoリスト"></h2>
							<c:forEach var="e" items="${TodolistList}" varStatus='status'>
								<form method="POST" action="/anikare/ScheduleEditServlet">
									<details>
										<summary>
											<input type="checkbox" id="checkselect" name="checkbox"
												value="missioncomplete"> <input type="text"
												class="titlefont" name="task" placeholder="タスク名を入力"
												value="${e.task}">
										</summary>
										<table>
											<tr>
												<td><input type="text" class="shorttext"
													name="todo_deadline" placeholder="締め切り時間を入力"
													value="${e.todo_deadline}"></td>
											</tr>
											<tr>
												<td><select id="importanceselect" name="importance">
														<option value="3" ${e.importance == '3' ? 'selected' : ''}>☆☆☆</option>
														<option value="2" ${e.importance == '2' ? 'selected' : ''}>☆☆</option>
														<option value="1" ${e.importance == '1' ? 'selected' : ''}>☆</option>
												</select></td>
											</tr>
											<tr>
												<td colspan="2"><input type="text" class="longtext"
													name="todo_memo" placeholder="メモ" value="${e.todo_memo}"></td>
											</tr>
										<tr><td colspan="2">
										<div class="input_wrapper">
											<input class="hover" type="submit" name="SUBMIT" value="タスク削除">
											<input class="hover" type="submit" name="SUBMIT" value="タスク更新">
										</div>
										</td></tr></table>
									</details>
								</form>
							</c:forEach>
						</div>
					</div>


					<!-- 日記記入 -->
					<div class="diaryedit">
						<h2 class="h2"><img src="img/diarylogo.png" alt="今日の記録"></h2>

						<form method="POST" action="/anikare/ScheduleEditServlet">
								<table>
									<tr>
										<td><input type="text" class="titlefont"
											name="diary_title" placeholder="タイトルを入力"
											value="${diaryList[0].diary_title}"></td>
									</tr>
									<tr>
										<td><input type="text" class="diarycontent"
											name="diary_content" value="${diaryList[0].diary_content}"></td>
										<td><input type="hidden" name="diary_date"
											value="${diaryList[0].diary_date}"></td>
										<td><input type="hidden" name="user_id"
											value="${id.user_id}"></td>
									</tr>
								</table>
								<c:forEach var="e" items="${cardList}">
									<input type="hidden" name="point_value"
										value="${e.point_value}">
								</c:forEach>
								<div class="input_wrapper">
									<input class="hover" type="submit" name="SUBMIT" value="記録削除">
									<input class="hover" type="submit" name="SUBMIT" value="記録更新">
									<input class="hover" type="submit" name="SUBMIT" value="記録登録">
								</div>
							</form>

					</div>
				</div>
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
		<script src="/anikare/js/all.js"></script>
		<script>
		'use strict';

		if("${res}" == "ok"){
				window.confirm('登録に成功しました。');
		    }
			else if("${res}" == "miss")
			{
			window.confirm('登録に失敗しました。');

			}else if("${res}" == "sok"){
			window.confirm('削除に成功しました。');
			}
			else if("${res}" == "smiss")
			{
			window.confirm('削除に失敗しました。');

			}
			else if("${res}" == "kok")
			{
			window.confirm('更新に成功しました。');

			}
			else if("${res}" == "kmiss")
			{
			window.confirm('更新に失敗しました。');

			}
			else{
			console.log("empty");

			}

		</script>
	</div>
</body>
</c:forEach>
</html>