<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>言語登録フォーム</title>
</head>
<body>
	<h1 style="text-align: center;">言語登録フォーム</h1>
	<form style="text-align: center;" action="language-register" method="post">
		<input type="text" name="languageCode" placeholder="L000"><br>
	    <input type="text" name="languageName" placeholder="Java"><br>
	    <input type="submit" value="言語登録確定">
	    <input type="reset" value="クリア">
	</form>
	<div style="text-align: center;">
		<button onclick="location.href='menu.jsp'">メニュー画面へ</button>
	</div>
</body>
</html>