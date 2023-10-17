<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員一覧画面</title>
</head>
<body>
	<div style="text-align : center; padding-top: 50px;">
		<h1>従業員一覧画面です。</h1>
		<form style="display: flex; gap: 10px; justify-content:center;"  action="employee-list" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="従業員検索">
		</form>
		<table border="1" style="margin: 10px auto 0px auto;">
		<tr>
          <th>従業員ID</th>
          <th>従業員名（姓）</th>
          <th>従業員名（名）</th>
          <th>性別</th>
          <th>生年月日</th>
          <th>電話番号</th>
          <th>部署</th>
          <th>経験言語</th>
          <th>入社日</th>
          <th></th>
        </tr>
        <c:forEach var="employee" items="${employees}">
	        <tr>
	          <td>${employee.employee_id}</td>
	          <td>${employee.l_name}</td>
	          <td>${employee.f_name}</td>
	          <td>${employee.gender}</td>
	          <td>${employee.birthday}</td>
	          <td>${employee.phone_number}</td>
	          <td>${employee.section_code}</td>
	          <td>${employee.language_code}</td>
	          <td>${employee.hire_date}</td>
	          <td><form action="employee-detail" method="post"><input type="submit" value="詳細"></form></td>
	        </tr>
        </c:forEach>
		</table>
	</div>
</body>
</html>

