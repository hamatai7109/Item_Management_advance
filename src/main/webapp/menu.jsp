<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <jsp:include page="/header.jsp" />
  <div class="main">
    <main>
      <h2>従業員管理システム</h2>
      <input type="submit" name="button" onclick="location.href='employee-list.jsp'" value="従業員一覧"><br>
      <input type="submit" name="button" onclick="location.href='employee-register.jsp'" value="従業員登録画面へ"><br>
      <input type="submit" name="button" onclick="location.href='language-register.jsp'" value="経験言語登録画面へ">
    </main>
  </div>
</body>
</html>
