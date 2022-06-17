<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>アニカレ</title>
  <link rel="stylesheet" type="text/css" href="/anikare/css/all.css">
 <link rel="stylesheet" type="text/css" href="/anikare/css/diary.css">
  <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <header>
    <div id="aniheader">
        <!--日付表示-->
          <p class="headermoji"><span id="time"></span></p>


        <!--- メニューバー --->
        <p class="">
            <div class="drawer">
            <!-- ハンバーガーメニュー表示・非表示切り替え -->
            <input type="checkbox" id="drawer-check" class="drawer-hidden" >
            <!-- ハンバーガーアイコン -->
            <label for="drawer-check" class="drawer-open"><span></span></label>
                <nav class="drawer-content">
                  <!-- リンクをつなげる -->
                    <ul class=" drawar-list">
                       <li><a href="" class="btn btn-border">トップページ　</a></li>
                       <li><a href="" class="btn btn-border">予定・ＴｏＤｏ</a></li>
                       <li><a href="" class="btn btn-border">　今日の予定　</a></li>
                       <li><a href="" class="btn btn-border">　日記　一覧　</a></li>
                       <li><a href="" class="btn btn-border">ポイント　交換</a></li>
                       <li><a href="" class="btn btn-border">　マイページ　</a></li>
                       <li><a href="" class="btn btn-border">　ログアウト　</a></li>

                    </ul>
                </nav>
              </div>
        </p>
      <!--タイトル-->
      <p class=""><h1 class="logo"><a href =""><img src="src/WebContent/img/logo.png" alt="アニカレロゴ"></a></h1></p>


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
          <img scr="ma"><img scr="ma">

          <!-- ToDo -->

          <!-- 今日の予定 -->
          <p>今日はランチ！</p>

        </div>

        <!--- キャラクター --->
        <div class="animals">
          <img src="img/animal_zou.png">
          <!--データベースを操作して、データーベースの値を取得したのちに、その値を表示させたい-->
        </div>
      </div>
      <div class="rightside">
      <!--- カレンダー --->
        <div class="main">
          <h1 id="header"></h1>

          <!--- ボタン　月移動 --->
          <div id="next-prev-button">
              <button id="prev" onclick="prev()">＜</button>
              <span>2022年6月</span>
              <button id="next" onclick="next()">＞</button>
          </div>

          <!--- 日記一覧ー　本当はforEachで繰り返し--->
          <div class="table-contents">
            <table class="start_list">
              <tr>
                <th class="fixed1">day</th>
                <th class="fixed1">title</th>
              </tr>
              <c:forEach var="e" items="${cardList}">
	          <tr>
	          <td>${e.diary_date}</td>
	          <td>${e.diary_title}</td>
          </tr>
		  </c:forEach>

            </table>
          </div>
        </div>
      </div>
    </div>
</main>
<footer>

</footer>
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