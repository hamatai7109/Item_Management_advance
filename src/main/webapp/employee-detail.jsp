<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員詳細</title>
</head>
<body>
	<div style="text-align : center; padding-top: 50px;">
		<c:choose>
		    <c:when test="${not empty requestScope.errorMessage}">
		        <p style="color: red">${requestScope.errorMessage}</p>
		    </c:when>
		    <c:otherwise>
				<c:forEach var="employee" items="${employees}">
	            	<h1>${employee.getLName()} さん詳細</h1>
	        	</c:forEach>
	        </c:otherwise>
		</c:choose>
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
	          <th>更新日</th>
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
	   	      <td>${employee.getUpdateDatetime()}</td>
	          <td>
		          <form action="employee-edit" method="post">
        		    <input type="hidden" name="employeeId" value="${employee.getEmployeeId()}">
		          	<input type="submit"value="編集">
		          </form>
	          </td>
	          <td>
		          <form action="employee-delete" method="post">
       		        <input type="hidden" name="employeeId" value="${employee.getEmployeeId()}">
		          	<input type="submit"value="削除">
		          </form>
	          </td>
	        </tr>
        </c:forEach>
		</table>
		<form style="margin-top:20px;" action="employee-list" method="post">
		    <input type="submit" value="従業員一覧">
		</form>	
	</div>
</body>
</html>

