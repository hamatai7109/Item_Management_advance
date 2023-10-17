<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.SectionBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員フォーム</title>
</head>
<body>
<div style="text-align: center;">
	<h1>従業員登録フォーム</h1>
	<form action="employee-register" method="post">
		<div>
			<label>氏名（姓）
				<input type="text" name="lastName" placeholder="山田" required>	
			</label>
		</div>
		<div>
			<label>氏名（名）
				<input type="text" name="firstName" placeholder="太郎" required>	
			</label>
		</div>
		<div>
			<label>性別</label>
		    <label>
	   			<input type="radio" name="gender" value="m" />
		    	男
		    </label>
		    <label>
	    		<input type="radio" name="gender" value="f" />
		    	女
		    </label>
		</div>
		<div>
			<label>生年月日
				<input type="text" name="birthday" placeholder="19910105" required>	
			</label>
		</div>
		<div>
			<label>電話番号
				<input type="text" name="phoneNumber" placeholder="08012345678" required>	
			</label>
		</div>
		<div>
			<label>部署
				<select name="sectionCode" required>
					<c:forEach var="section" items="${sections}">
					    <option value="<c:out value="${section.sectionCode}" />"><c:out value="${section.sectionName}" /></option>
					</c:forEach>
				</select>
			</label>
		</div>
		<div>
			<label>経験言語
				<select name="languageCode" required>
					<c:forEach var="language" items="${languages}">
					    <option value="<c:out value="${language.languageCode}" />"><c:out value="${language.languageName}" /></option>
					</c:forEach>
				</select>
			</label>
		</div>
		<div>
			<label>入社日
				<input type="text" name="hireDate" placeholder="20220401" required>	
			</label>
		</div>
		<div>
			<input type="submit" value="従業員登録確定">
			<input type="reset" value="クリア">		
		</div>
	</form>
	<form style="margin-top:50px;" action="menu" method="post">
      <input type="submit" name="button" value="メニュー画面へ">
	</form>
</div>
</body>
</html>