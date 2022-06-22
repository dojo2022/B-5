'use strict';
/**
 *
 */

 //ヘッダー日付表示
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