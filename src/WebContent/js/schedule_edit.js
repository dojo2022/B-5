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
