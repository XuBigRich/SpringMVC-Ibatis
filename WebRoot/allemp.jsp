<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="jstlc" prefix="c"%>
<html>
<head>
	<title>员工列表</title>
	<link rel="stylesheet" type="text/css" href="common.css">
	<script language="javascript" src="time.js" charset="gbk"></script>
</head>
<script language="javascript">

</script>
<body>
<center>
<form action="emp.sw?cmd=findEmp" method="post">
<table width=600 cellspacing=1>
	<tr>
		<th>姓名</th>
		<td><input type=text name="ename" size=15></td>
		<th>性别</th>
		<td>
			<input type=radio name="sex" value="k" checked class="nob">所有
			<input type=radio name="sex" value="m" class="nob">男
			<input type=radio name="sex" value="f" class="nob">女
		</td>
	</tr>
	<tr>
		<th>入职日期</th>
		<td>
			<input type=text name="hire" readonly onclick=setday(this) size=10>
			-
			<input type=text name="hire2" readonly onclick=setday(this) size=10>
		</td>
		<th>所属部门</th>
		<td>
			<select name="did">
				<option value="0">请选择</option>
				<c:forEach items="${depts}" var="d">
					<option value="${d.did }">${d.dname }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr><th colspan=4><input type=submit value='查 找'></th></tr>
</table>
</form>

<table width=600 cellspacing=1>
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>入职日期</th>
		<th>工资</th>
		<th>所属部门</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${emps}" var="e">
		<tr>
			<td>${e.ename }</td>
			<td>${e.sex=='m'?'男':'女' }</td>
			<td>${e.hire }</td>
			<td>${e.sar }</td>
			<td>${e.dept.dname }</td>
			<td>
				<a href="emp.sw?cmd=beforeUpdate&eid=${e.eid }">修改</a>
				<a href="emp.sw?cmd=delEmp&eid=${e.eid }" onclick="return confirm('确定删除这条记录？');">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>