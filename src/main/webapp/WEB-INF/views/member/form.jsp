<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"  %>
<body>
<div class="container">
	<h3>メンバー登録画面</h3>
	<div class="span8">
		<div class="row">
		<form:form modelAttribute="memberForm" action="${pageContext.request.contextPath}/member/create">
			<table class="table table-striped">
			  <tr>
			    <th>
			     	 氏名
			    </th>
			    <td>
			    <form:errors cssStyle="color:red" element="div" path="name"/>
			    	<form:input path="name"  placeholder="Name"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      	メールアドレス
			    </th>
			    <td>
			    	<form:errors cssStyle="color:red" element="div" path="mailAddress"/>
			    	<form:input path="mailAddress"  placeholder="mailAddress"/>

			    </td>
			  </tr>
			  <tr>
			    <th>
			     	 パスワード
			    </th>
			    <td>
			    <form:errors cssStyle="color:red" element="div" path="password"/>
			    	<form:password path="password" placeholder="Password"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			     	 確認用パスワード
			    </th>
			    <td>
			    	<form:errors cssStyle="color:red" element="div" path="password"/>
			    	<form:password path="confirmPassword" placeholder="Password(確認用)"/>
			    </td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td>
					<input class="btn" type="submit" value="登録">
			    </td>
			  </tr>
			</table>
		  </form:form>
		</div>
	</div>
</div>
</body>
</html>