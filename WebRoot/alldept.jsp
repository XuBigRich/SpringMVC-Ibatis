<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>部门列表</title>
	<link rel="stylesheet" type="text/css" href="common.css">
	<script language="javascript" src="time.js" charset="gbk"></script>
</head>
<script language="javascript">
function fun(){
	var cn=event.srcElement.parentElement.nextSibling;//获取事件源对象的下一个兄弟结点
	if(cn.style.display=="none")cn.style.display="block";
	else cn.style.display="none";
}
</script>
<body>
<center>
<table width=600 cellspacing=1>
	<tr>
		<th>部门名称</th>
		<th>部门经理</th>
		<th>联系电话</th>
		<th>上级部门</th>
		<th>操作</th>
	</tr>
	<s:iterator value="depts">
		<tr onclick=fun()>
			<td>${dname }</td>
			<td>${man }</td>
			<td>${tel }</td>
			<td>${updept }</td>
			<td>
				<a href="dept!beforeUpdate?dept.did=${eid }">修改</a>
				<a href="dept!delDept?dept.did=${eid }" onclick="return confirm('确定删除这条记录？');">删除</a>
			</td>
		</tr>
		<tr style="display:none;">
			<td class=left colspan=5>
				<s:iterator value="emps">
					${ename }-${sex }-${hire }<br>
				</s:iterator>
			</td>
		</tr>
	</s:iterator>
</table>
</center>
</body>
</html>