<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IP查询机</title>

<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container-fluid">
		<h3 class=col-md-12>输入域名查IP地址</h3>

		<hr />

		<div class="">
			<form action="/IPChecker/check" method="post">
				<input class="form-control input-lg" type="text" placeholder="www."
					name="domainname"><br />

				<button type="button submit"
					class="btn btn-primary btn-lg btn-block">查IP</button>
		</div>
		</form>
		<br />
		<!-- 结果返回 -->
		<h3 class="text-center">

			<%
				if(request.getAttribute("realIP")!= null) {
			%>
			<%=request.getAttribute("realIP")%>
			<%
				}else{%>
					<br>
				<%}
			%>

		</h3>
		<!-- 结果返回结束 -->
		<hr />
		<div class="text-muted">
			<p>待优化:</p>
			<ul class="list-unstyled">
				<del><li>1. 输入域名错误时无法核验,加入核验机制,提示域名格式错误.</li></del>
				<li>2. 返回结果显示位置及样式调整.</li>
				<li>3. 一侧显示已查询域名地址.</li>
				<li>4. bootstrap的js,css引用外部链接过慢,改为相对路径.</li>
				<li></li>
			</ul>
			<p>新加入:</p>
			<ul class="list-unstyled">
				<li>1.加入对不同输入方式的判定,如使用http://或者https://或结尾有/结尾.</li>
				<li>2.改善输出方式.</li>
			</ul>
		</div>
		<a href="http://www.cnblogs.com/ukzq/p/8268066.html" target="_blank"><h4>开发及流程blog</h4></a>

		<!-- <a href="http://www.cnblogs.com/ukzq/p/8268066.html" target="_blank">开发及上线记录</a> -->


	</div>
</body>
</html>