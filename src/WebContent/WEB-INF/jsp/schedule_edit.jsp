<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
  <meta charset="UTF-8">
  <title>アニカレ</title>
  <link rel= "stylesheet" href="/anikare/css/all.css">
  <link rel= "stylesheet" href="/anikare/css/schedule_edit.css">
  <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
</head>

<body>
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
      <h1 class="logo"><a href =""><img src="img/logo.png" alt="アニカレロゴ"></a></h1>
 <!--      </p> -->


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
<!--                 <img scr="ma"><img scr="ma">
 -->                <p>予定・ToDoリストの編集<br>日記の記入ができるよ～<br>日記を記入してポイントをゲットしよう！
                </p>

              </div>

            <!--- キャラクター --->
            <div class="animals">
                <img src="img/animal_zou.png">
                <!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
            </div>
        </div>


      <div class="rightside">
        <div class="edit">
            <div class="scheduleedit">
                <!-- 予定編集 -->
                <h2>今日の予定</h2>
				<c:forEach var="e" items="${ScheduleList}" varStatus='status'>
                <form method="POST" action="/anikare/ScheduleEditServlet">

                  <details>
						<summary>
							<select id="stampselect" name ="value" >
								<option value="${e.stamp_id }">🍚</option>
								<option value="${e.stamp_id }">💛</option>
								<option value="${e.stamp_id }">⛰</option></select>
						<input type="text" class="titlefont" name="title" placeholder="タイトルを入力" value="${e.title}"></summary>
                    <table>
                      <tr>
                        <td><input type="text" class="shorttext" name="start_time" placeholder="12:00" value="${e.start_time}">～</td>
                        <td><input type="text" class="shorttext" name="end_time" placeholder="14:00" value="${e.end_time}"></td>
                      </tr>
                      <tr>
                        <td><input type="text" class="shorttext" name="place" placeholder="場所" value="${e.place}"></td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" class="longtext" name="schedule_memo" placeholder="メモ" value="${e.schedule_memo}"></td>
                      </tr>
                      <tr>

                      <tr>
                        <td>
                          <div class=""><input class=""  name="BACK" value="戻る" ></div>
                        </td>
                        <td>
                          <div class=""><input class="" type="submit" name="DELETE" value="削除" onsubmit="doSomething();return false;"></div>
                        </td>
                        <td>
                          <div class=""><input class="" type="submit" name="UPDATE" value="保存" onsubmit="doSomething();return false;"></div>
                        </td>
                      </tr>
                    </table>
                  </details>

                </form>
                </c:forEach>
            </div>
            <div class="todoedit">
                <!-- ToDo編集 -->
                <h2>ToDo</h2>
                <form method="POST" action="/anikare/TodoEditServlet">
                  <details>
                    <summary>
                    	<input type="checkbox" id="" name="checkbox" value="missioncomplete">
                    	<input type="text" class="titlefont" name="task" placeholder="タスク名を入力" value="${e.task}">
                    </summary>
                      <table>
                        <tr>
                          <td><input type="text" class="" name="todo_deadline" placeholder="締め切り時間を入力" value="${e.todo_deadline}"></td>
                        </tr>
                        <tr>
                          <td colspan="2"><input type="text" class="longtext" name="todo_memo" placeholder="メモ" value="${e.todo_memo}"></td>
                        </tr>
                        <tr>
                          <td>
                            <div class=""><input class="" type="submit" name="BACK" value="戻る"></div>
                          </td>
                          <td>
                            <div class=""><input class="" type="submit" name="DELETE" value="削除"></div>
                          </td>
                          <td>
                            <div class=""><input class="" type="submit" name="UPDATE" value="保存"></div>
                          </td>
                        </tr>
                      </table>
                  </details>
                </form>
            </div>
        </div>


         <!-- 日記記入 -->
         <h2>今日の記録</h2>
         <form method="POST" action="/anikare/DiaryAddServlet">
          <table>
            <tr>
              <td><input type="text" class="" name="diary_title" placeholder="タイトルを入力" value="${diaryList[0].diary_title}"></td>
            </tr>
            <tr>
              <td><input type="text" name="diary_content" value="${diaryList[0].diary_content}"></td>
            </tr>
          </table>
            <div class=""><input class="" type="submit" name="DELETE" value="リセット"></div>
            <div class=""><input class="" type="submit" name="UPDATE" value="保存"></div>
        </form>
      </div>
    </div>


    </main>
    <footer>

    </footer>
    <script src="/anikare/js/all.js"></script>
</div>
</body>

</html>