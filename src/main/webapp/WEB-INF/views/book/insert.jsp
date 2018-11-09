<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/logout/sessionInvalidate">ログアウト</a>
	<a href="${pageContext.request.contextPath}/book/list">書籍一覧</a>
	<div class="container">
		<h3>書籍登録画面</h3>
		<div class="span8">
			<div class="row">
				<form:form modelAttribute="bookInfoForm"
					action="${pageContext.request.contextPath}/book/insert" enctype="multipart/form-data">
					<table class="table table-striped">
						<tr>
							<th>書籍名</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="name" /> <form:input path="name" placeholder="書籍名" /></td>
						</tr>
						<tr>
							<th>著者名</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="author" /> <form:input path="author" placeholder="著者名" />

							</td>
						</tr>
						<tr>
							<th>出版社</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="publisher" /> <form:input path="publisher"
									placeholder="出版社" /></td>
						</tr>
						<tr>
							<th>価格</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="price" /> <form:input path="price" placeholder="価格" /></td>
						</tr>
						<tr>
							<th>ISBNコード</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="isbncode" /> <form:input path="isbncode"
									placeholder="ISBNコード" /></td>
						</tr>
						<tr>
							<th>発売日</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="saledate" /> <input type="date" name="saledate"
								placeholder="発売日"></td>
						</tr>
						<tr>
							<th>説明</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="explanation" /> <form:input path="explanation"
									placeholder="説明" /></td>
						</tr>
						<tr>
							<th>在庫</th>
							<td><form:errors cssStyle="color:red" element="div"
									path="stock" /> <form:input path="stock" placeholder="在庫" /></td>
						</tr>
						<tr>
							<th>写真アップロード</th>
							<td>
									<form:errors cssStyle="color:red" element="div"
									path="file" />
									<input name="file" type="file" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input class="btn" type="submit" value="登録"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>