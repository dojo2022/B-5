<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>アニカレ</title>
  <link rel= "stylesheet" href="/anikare/css/all.css">
  <link rel= "stylesheet" href="/anikare/css/schedule_add.css">
  <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
</head>

<c:forEach var="e" items="${BackgroundActiveList}">
	<body background="/anikare/img/${e.mail}">
<div class="wrapper">
  <header>
    <div id="aniheader">
        <!--日付表示-->
		<p class="headermoji"><span id="time"></span></p>


        <!--- メニューバー --->
  <!--       <p> -->
        <div class="drawer">
        <!-- ハンバーガーメニュー表示・非表示切り替え -->
        <input type="checkbox" id="drawer-check" class="drawer-hidden" >
        <!-- ハンバーガーアイコン -->
        <label for="drawer-check" class="drawer-open"><span></span></label>
            <nav class="drawer-content">

                 <ul class=" drawar-list">
                   	<li><a href="/anikare/ToppageServlet" class="btn btn-border">トップページ </a></li>
		<li><a href="/anikare/ScheduleAddServlet" class="btn btn-border">予定・ＴｏＤｏ</a></li>
		<li><a href="/anikare/ScheduleEditServlet" class="btn btn-border"> 今日の予定 </a></li>
		<li><a href="/anikare/DiaryServlet" class="btn btn-border"> 日記 一覧 </a></li>
		<li><a href="/anikare/ItemChangeServlet" class="btn btn-border">ポイント 交換</a></li>
		<li><a href="/anikare/MypageServlet" class="btn btn-border"> マイページ </a></li>
		<li><a href="/anikare/LoginServlet" class="btn btn-border"> ログアウト </a></li>
                </ul>
            </nav>
          </div>
     <!--    </p> -->
      <!--タイトル-->
<!--       <p> -->
      <h1 class="logo"><a href ="/anikare/ToppageServlet"><img src="img/logo.png" alt="アニカレロゴ"></a></h1>
 <!--      </p> -->


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
<!--                 <img scr="ma"><img scr="ma">
 -->                <p>予定・ToDoリストの編集<br>日記の記入ができるよ～<br>日記を記入してポイントをゲットしよう！
                </p>

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
        <div class="add">

        	<!-- 予定編集 -->
            <div class="scheduleedit">
                <h2 class="h2"><img src="img/addlogo.png" alt="予定の追加"></h2>
                <form method="POST" action="/anikare/ScheduleAddServlet">
                  <details>
						<summary>
								<select id="stampselect" name="stamp_id">
												<option value="1" ${e.stamp_id == '1' ? 'selected' : ''}>🍚</option>
												<option value="2" ${e.stamp_id == '2' ? 'selected' : ''}>💛</option>
												<option value="3" ${e.stamp_id == '3' ? 'selected' : ''}>⛰</option>
											</select>
					<input type="text" class="titlefont" name="title" placeholder="タイトルを入力"></summary>
                    <table>

                    <tr><td><input type="text" class="shorttext" name="schedule_date" placeholder="2022-06-30"></td></tr>
                      <tr>
                        <td><input type="text" class="shorttext" name="start_time" placeholder="12:00">～</td>
						<td><input type="text" class="shorttext" name="end_time" placeholder="14:00"></td>
                      </tr>
                      <tr>
                        <td><input type="text" class="shorttext" name="place" placeholder="場所"></td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" class="longtext" name="schedule_memo" placeholder="ここにメモを記入"></td>
                      </tr>
               		</table>
                          <div class="input_wrapper">
                          <a href="/anikare/TopPageServlet">戻る</a>
                          <input class="" type="submit" name="submit" value="スケジュール追加" onsubmit="doSomething();return false;">
                          </div>

                  </details>
                  <c:forEach var="e" items="${cardList}">
						<input type="hidden" name="point_value"
							value="${e.point_value}">
				  </c:forEach>
                </form>
            </div>

            <!-- ToDo編集 -->
            <div class="todoedit">
                <h2 class="h2"><img src="img/todoaddlogo.png" alt="ToDo追加"></h2>
                <form method="POST" action="/anikare/ScheduleAddServlet">
                  <details>
                    <summary>
                    	<input type="checkbox" id="checkselect" name="checkbox" value="missioncomplete">
                    	<input type="text" class="titlefont" name="task" placeholder="タスク名を入力" >
                    </summary>
                      <table>
                      <tr>
                          <td><input type="text" class="shorttext" name="todo_deadline" placeholder="締め切り時間を入力"></td>
                        </tr>
                       <tr>
                          <td><select id="importanceselect" name="importance">
														<option value="3" ${e.importance == '3' ? 'selected' : ''}>☆☆☆</option>
														<option value="2" ${e.importance == '2' ? 'selected' : ''}>☆☆</option>
														<option value="1" ${e.importance == '1' ? 'selected' : ''}>☆</option>
												</select></td>
                        </tr>

                        <tr>
                          <td colspan="2"><input type="text" class="longtext" name="todo_memo" placeholder="ここにメモを記入" ></td>
                        </tr>
                        </table>

                            <div class="input_wrapper">
                          <a href="/anikare/TopPageServlet">戻る</a>

                            <input class="hover" type="submit" name="submit" value="Todo追加"></div>
                  </details>2
                  <c:forEach var="e" items="${cardList}">
						<input type="hidden" name="point_value"
							value="${e.point_value}">
				  </c:forEach>
                </form>
            </div>
        </div>
</div>
</div>


</main>
    <footer>

    </footer>
    <script src="/anikare/js/all.js"></script>
    <script type="text/javascript">
    if("${res}" == "ok"){
		window.confirm('登録成功しました。');
    }
	else if("${res}" == "miss")
	{
	window.confirm('登録失敗しました。');

}else{
	console.log("empty");

}</script>
</div>
</body>
</c:forEach>
</html>