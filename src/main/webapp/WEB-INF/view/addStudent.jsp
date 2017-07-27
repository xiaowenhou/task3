<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新用户</title>

</head>
<body>
	<form id="itemForm"	action="${pageContext.request.contextPath }/a/student/add" method="post">
		<input type="hidden" name="student" value="${student}" /> 添加新学员：
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${student.name }" /></td>
			</tr>
			<tr>
            	<td>QQ</td>
            	<td><input type="text" name="qqNumber" value="${student.qqNumber }" /></td>
            </tr>
            <tr>
                <td>修真类型</td>
                <td><input type="text" name="profession" value="${student.profession}" /></td>
            </tr>
            <tr>
                <td>预计入学时间</td>
                <td><input type="text" name="joinDate" value="${student.joinDate }" /></td>
            </tr>
            <tr>
                <td>毕业院校</td>
                <td><input type="text" name="school" value="${student.school }" /></td>
            </tr>
            <tr>
                <td>线上(jnshu.com)学号</td>
                <td><input type="text" name="onlineNumber" value="${student.onlineNumber }" /></td>
            </tr>
            <tr>
                <td>日报链接</td>
                <td><input type="text" name="dailyLink" value="${student.dailyLink }" /></td>
            </tr>
            <tr>
                <td>立愿</td>
                <td><input type="text" name="desire" value="${student.desire }" /></td>
            </tr>
            <tr>
                <td>辅导师兄</td>
                <td><input type="text" name="brother" value="${student.brother }" /></td>
            </tr>
            <tr>
                <td>从何处了解到修真院</td>
                <td><input type="text" name="msgSource" value="${student.msgSource }" /></td>
            </tr>
			<tr>
				<td colspan="5" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>