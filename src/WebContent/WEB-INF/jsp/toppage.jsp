<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 <head>
<link rel="stylesheet" href="WebContent/css/all.css">
<script src="./test.js" defer></script>
  <style type="text/css"></style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
          <!-- 今日の格言 -->
          <p>あああああああああああああああああああああああああああ</p>
        </div>

        <!--- キャラクター --->
        <div class="animals">
          <img src="src/WebContent/img/animal_zou.png">
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
              <button id="next" onclick="next()">＞</button>
          </div>


          <!--- カレンダー　--->
          <div id="calendar"></div>
          <p>カレンダー</p>
          <script src=""></script>
<script>
const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
const config = {
    show: 3,
}

function showCalendar(year, month) {
    for ( i = 0; i < config.show; i++) {
        const calendarHtml = createCalendar(year, month)
        const sec = document.createElement('section')
        sec.innerHTML = calendarHtml
        document.querySelector('#calendar').appendChild(sec)

        month++
        if (month > 12) {
            year++
            month = 1
        }
    }
}

function createCalendar(year, month) {
    const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
    const endDate = new Date(year, month,  0) // 月の最後の日を取得
    const endDayCount = endDate.getDate() // 月の末日
    const lastMonthEndDate = new Date(year, month - 2, 0) // 前月の最後の日の情報
    const lastMonthendDayCount = lastMonthEndDate.getDate() // 前月の末日
    const startDay = startDate.getDay() // 月の最初の日の曜日を取得
    let dayCount = 1 // 日にちのカウント
    let calendarHtml = '' // HTMLを組み立てる変数

    calendarHtml += '<h1>' + year  + '/' + month + '</h1>'
    calendarHtml += '<table>'

    // 曜日の行を作成
    for (let i = 0; i < weeks.length; i++) {
        calendarHtml += '<td>' + weeks[i] + '</td>'
    }

    for (let w = 0; w < 6; w++) {
        calendarHtml += '<tr>'

        for (let d = 0; d < 7; d++) {
            if (w == 0 && d < startDay) {
                // 1行目で1日の曜日の前
                let num = lastMonthendDayCount - startDay + d + 1
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
            } else if (dayCount > endDayCount) {
                // 末尾の日数を超えた
                let num = dayCount - endDayCount
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
                dayCount++
            } else {
                calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
                dayCount++
            }
        }
        calendarHtml += '</tr>'
    }
    calendarHtml += '</table>'

    return calendarHtml
}

function moveCalendar(e) {
    document.querySelector('#calendar').innerHTML = ''

    if (e.target.id === 'prev') {
        month--

        if (month < 1) {
            year--
            month = 12
        }
    }

    if (e.target.id === 'next') {
        month++

        if (month > 12) {
            year++
            month = 1
        }
    }

    showCalendar(year, month)
}

$(document).ready(function(){
    $('.confirm_buttton').click(function(){
        if(!confirm('日付は'+e.target.dataset.date + 'ですか？')){
            return false;
        }else{
            location.href = 'schedule.jsp';
        }
    });
});
</script>
…
<button type="submit" id="confirm">入力内容を確認する</button>
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