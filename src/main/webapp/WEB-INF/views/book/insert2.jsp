<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h3>書籍登録画面</h3>
		<div class="span8">
			<div class="row">
							写真
							
<form action="${pageContext.request.contextPath}/testUpload/upload" method="post" enctype="multipart/form-data">
	<input name="file" type="file" />
	<input type="submit" value="送信する" />
</form>
					
						
			</div>
		</div>
	</div>
</body>
</html>