<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body style="padding: 15px;">
	<table>
		<tr>
			<!-- 表單資料處理 CRUD -->
			<td valign="top"><form:form modelAttribute="exam"
					class="pure-form" method="post">
					<fieldset>
						<legend>EXAM 考試註冊</legend>
						學員標號:
						<from:input path="id" placeholder="請輸入學員標號" />
						<p />
						考試代號:
						<form:select path="name">
							<from:option value="">選擇</from:option>
							<from:option value="808">808</from:option>
							<from:option value="809">809</from:option>
							<from:option value="900">900</from:option>
						</form:select>
						<p />
						考試時段(可複選) :
						<form:checkbox path="slot" value="A" />
						上午
						<form:checkbox path="slot" value="B" />
						下午
						<form:checkbox path="slot" value="C" />
						晚上
						<p />
						繳費狀況: 已繳
						<form :radiobutton path="pay" value="true" />
						未繳交
						<form :radiobutton path="pay" value="false" />
						<p />
						備註:
						<from:textarea path="note" />
						<p />
						<button type="submit" class="pure-button pure-button-primary">create</button>
						<button type="reset" class="pure-button pure-button-primary">reset</button>
					</fieldset>
				</form:form></td>
		</tr>
		<!-- 資料統計圖 -->
		<tr>
			<td valign="top"></td>
		</tr>
	</table>
</body>
</html>