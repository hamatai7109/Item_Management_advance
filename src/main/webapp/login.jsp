<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
	<div style="text-align:center;">
		<main>
			<div>
				<img style="height:350px;" class="image" src="images/seassist_logo.png" alt="ロゴ">
			</div>
			<h2>商品管理システム</h2>
			<%-- ログインに失敗したときのメッセージ --%>
			<%-- JSTL（JavaServer Pages Standard Tag Library）を使用した場合
				<c:if test="${not empty requestScope.errorMessage}">
				    <p style="color: red">${requestScope.errorMessage}</p>
				</c:if>
			--%>
			<%-- スクリプトレットを使用した場合 --%>
			<% if (request.getAttribute("errorMessage") != null) { %>
			    <p style="color: red"><%= request.getAttribute("errorMessage") %></p>
			<% } %>
			<form action=login method="post">
				<input type="text" name="id" placeholder="userId"><br>
				<input type="password" name="password" placeholder="password"><br>
				<br>
				<input type="submit" value="ログイン">
			</form>
		</main>
	</div>
</body>
</html>
