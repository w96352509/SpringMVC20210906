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
			<!-- ����ƳB�z CRUD -->
			<td valign="top"><form:form modelAttribute="exam"
					class="pure-form" method="post">
					<fieldset>
						<legend>EXAM �Ҹյ��U</legend>
						�ǭ��и�:
						<from:input path="id" placeholder="�п�J�ǭ��и�" />
						<p />
						�ҸեN��:
						<form:select path="name">
							<from:option value="">���</from:option>
							<from:option value="808">808</from:option>
							<from:option value="809">809</from:option>
							<from:option value="900">900</from:option>
						</form:select>
						<p />
						�Ҹծɬq(�i�ƿ�) :
						<form:checkbox path="slot" value="A" />
						�W��
						<form:checkbox path="slot" value="B" />
						�U��
						<form:checkbox path="slot" value="C" />
						�ߤW
						<p />
						ú�O���p: �wú
						<form :radiobutton path="pay" value="true" />
						��ú��
						<form :radiobutton path="pay" value="false" />
						<p />
						�Ƶ�:
						<from:textarea path="note" />
						<p />
						<button type="submit" class="pure-button pure-button-primary">create</button>
						<button type="reset" class="pure-button pure-button-primary">reset</button>
					</fieldset>
				</form:form></td>
		</tr>
		<!-- ��Ʋέp�� -->
		<tr>
			<td valign="top"></td>
		</tr>
	</table>
</body>
</html>