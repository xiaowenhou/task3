<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	用户列表：
	<table width="100%" border=1 >
		<tr>
			<td align="center">姓名</td>
			<td align="center">QQ</td>
			<td align="center">修真类型</td>
			<td align="center">预计入学时间</td>
			<td align="center">毕业院校</td>
			<td align="center">线上(jnshu.com)学号</td>
			<td align="center">日报链接</td>
			<td align="center">立愿</td>
			<td align="center">辅导师兄</td>
			<td align="center">从何处了解到的修真院</td>
			<td colspan="3" align="center">操作</td>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td hidden="hidden" align="center">${student.id }</td>
				<td align="center">${student.name }</td>
				<td align="center">${student.qqNumber }</td>
				<td align="center">${student.profession }</td>
				<td align="center">${student.joinDate }</td>
				<td align="center">${student.school }</td>
				<td align="center">${student.onlineNumber }</td>
				<td align="center">${student.dailyLink }</td>
				<td align="center">${student.desire }</td>
				<td align="center">${student.msgSource }</td>
				<td align="center">${student.brother }</td>
				<td hidden="hidden" align="center">${student.createAt }</td>
				<td hidden="hidden" align="center">${student.updateAt }</td>

				<td align="center"><form id="itemForm"
						action="${pageContext.request.contextPath }/a/student/id/${student.id}"
						method="get">
						<input type="submit" value="查询" />
					</form></td>
				<td align="center"><form id="itemForm"
						action="${pageContext.request.contextPath }/a/student/id/${student.id}"
						method="post">
						<input type="submit" value="修改" />
					</form></td>

				<td align="center"><a
					href="${pageContext.request.contextPath }/a/student/id/${student.id}/delete">删除</a></td>

			</tr>
		</c:forEach>

		<tr>
			<td align="center" colspan="13"><form id="itemForm"
					action="${pageContext.request.contextPath }/a/student/list"
					method="post">
					<input type="submit" value="添加" />
				</form></td>
		</tr>

	</table>
</body>

</html>