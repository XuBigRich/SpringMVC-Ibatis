<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="jstlc" prefix="c"%>
<html>
<head>
	<title>修改员工</title>
	<link rel="stylesheet" type="text/css" href="common.css">
	<script language="javascript" src="time.js" charset="gbk"></script>
</head>
<script language="javascript">
function addHist(){
	var cn=document.getElementById("model").cloneNode(true);//深度克隆
	cn.style.display="block";
	document.getElementById("tb").appendChild(cn);
}
function delRow(){
	var index=event.srcElement.parentElement.parentElement.rowIndex;
	document.getElementById("tab").deleteRow(index);
}
</script>
<body>
<center>
<form action="emp.sw?cmd=updateEmp" method="post">
<input type=hidden name="eid" value="${emp.eid }">
<table width=600 cellspacing=1>
	<tr><th colspan=2>修改新员工</th></tr>
	<tr>
		<th>姓名</th>
		<td><input type=text name="ename" value="${emp.ename }"></td>
	</tr>
	<tr>
		<th>性别</th>
		<td>
			<input type=radio name="sex" value="m" class="nob" ${emp.sex=='m'?'checked':'' }>男
			<input type=radio name="sex" value="f" class="nob" ${emp.sex=='f'?'checked':'' }>女
		</td>
	</tr>
	<tr>
		<th>入职日期</th>
		<td><input type=text name="hire" readonly onclick=setday(this) value="${emp.hire }">
	</tr>
	<tr>
		<th>工资</th>
		<td><input type=text name="sar" value="${emp.sar }"></td>
	</tr>
	<tr>
		<th>所属部门</th>
		<td>
			<select name="did">
				<c:forEach items="${depts }" var="d">
					<option value="${d.did }" ${emp.did==d.did?'selected':'' }>${d.dname}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr><th colspan=2><input type=submit value="修 改"></th></tr>
	<tr><th colspan=2><a href="#" onclick=addHist()>添加工作经历</a></th></tr>
	<tr>
		<th colspan=2>
			<table id="tab" width=600 cellspacing=1>
				<tr>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>工作地点</th>
					<th>职位</th>
					<th>删除</th>
				</tr>
				<tr id="model" style="display:none">
					<td>
						<input type=hidden name="hid" value="0">
						<input type=text size=10 name="a" readonly onclick=setday(this)>
					</td>
					<td><input type=text size=10 name="b" readonly onclick=setday(this)></td>
					<td><input type=text size=15 name="c"></td>
					<td><input type=text size=15 name="d"></td>
					<td><input type=button value="删除" onclick=delRow()></td>
				</tr>
				<tbody id="tb">
					<c:forEach items="${hists }" var="h">
						<tr>
							<td>
								<input type=hidden name="hid" value="${h.hid }">
								<input type=text size=10 name="a" value="${h.startdate }" readonly onclick=setday(this)>
							</td>
							<td><input type=text size=10 name="b" value="${h.enddate }" readonly onclick=setday(this)></td>
							<td><input type=text size=15 name="c" value="${h.place }"></td>
							<td><input type=text size=15 name="d" value="${h.job }"></td>
							<td><input type=button value="删除" onclick=delRow()></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</th>
	</tr>
</table>
</form>
</center>
</body>
</html>



