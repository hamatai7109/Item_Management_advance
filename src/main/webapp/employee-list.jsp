<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員一覧画面</title>
</head>
<body>
	<div style="text-align : center; padding-top: 50px;">
		<h1>従業員一覧画面です。</h1>
	
		<c:if test="${not empty requestScope.errorMessage}">
		    <p style="color: red">${requestScope.errorMessage}</p>
		</c:if>
		
		<form style="display: flex; gap: 10px; justify-content:center;"  action="employee-list" method="post">
			<input type="text" name="searchWord" required>
			<input type="submit" value="従業員検索">
		</form>
		<form style="margin-top:20px;" action="employee-list" method="post">
		    	<input type="submit" value="従業員一覧を表示する">
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
        </tr>
        <c:forEach var="employee" items="${employees}">
	        <tr>
	          <td>${employee.getEmployeeId()}</td>
	          <td>${employee.getLName()}</td>
	          <td>${employee.getFName()}</td>
	          <td>${employee.getGender()}</td>
	          <td>${employee.getBirthday()}</td>
	          <td>${employee.getPhoneNumber()}</td>
	          <td>${employee.getSectionCode()}</td>
	          <td>${employee.getLanguageCode()}</td>
	          <td>${employee.getHireDate()}</td>
	          <td>
		          <form action="employee-detail" method="post">
		          	<input type="hidden" name="employeeId" value="${employee.getEmployeeId()}">
		          	<input type="submit"value="詳細">
		          </form>
	          </td>
	        </tr>
        </c:forEach>
		</table>
		<form style="margin-top:20px;" action="menu" method="post">
	      <input type="submit" name="button" value="メニュー画面へ">
		</form>
	</div>
</body>
</html>

