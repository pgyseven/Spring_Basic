<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script>
		// 쿼리스트링의 status라는 변수의 값이 "success" 일때만 alert을 띄워야 한다.
		let status = '${param.status}'; 
		if (status === 'success'){
		window.alert("product save sucesse!");
		}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>${status }</div>
</body>
</html>
