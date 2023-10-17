<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>言語登録フォーム</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>言語登録フォーム</h1>
		<form action="language-register" method="post">
			<input type="text" name="languageCode" placeholder="L000" required><br>
		    <input type="text" name="languageName" placeholder="Java" required><br>
		    <input type="submit" value="言語登録確定">
		    <input type="reset" value="クリア">
		</form>
		<form style="margin-top:20px;" action="menu" method="post">
	      <input type="submit" name="button" value="メニュー画面へ">
		</form>
	</div>
</body>
</html>