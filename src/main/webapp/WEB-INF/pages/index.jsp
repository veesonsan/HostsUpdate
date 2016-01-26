<html>
<%@page language="java" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8"%>
<head>
	<script type="text/javascript">
		function download(){
			window.open("downloadHosts")
			window.open("downloadBat");
		}
	</script>
</head>
<body>
	<a href="list">查看最新hosts</a><br><br>
	<input type="button" onclick="download()" value="下载最新hosts文件"/><br><br>
	<a>双击run.sh脚本文件更新本地hosts 没找到run.sh？ </a>
	<a href="downloadBat">点我</a>
</body>
</html>