<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Spring</title>

<!-- Scripts -->
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>

<script>
	$(document).ready(function() {
		console.log("ready!");
		$.ajax({
			type : 'GET',
			url : "nuevoUsuario",
			data : {
				nombre : "Emiliano"
			},
			success : function(response) {
			},
			error : function(response) {
			}

		});//fin ajax

	});
</script>

</head>
<body>
	${message}

	<br>
	<br>
	<div
		style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">

		Spring MCV Tutorial by <a href="https://crunchify.com">Crunchify</a>.
		Click <a href="https://crunchify.com/category/java-tutorials/"
			target="_blank">here</a> for all Java and <a
			href='https://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.<br>
	</div>
</body>
</html>