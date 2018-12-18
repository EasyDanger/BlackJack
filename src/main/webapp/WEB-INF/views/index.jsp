<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="/styles.css"
>
<title>BlackJack</title>
</head>
<body>

	<main class="flex">
	<div class="card2">
		<h2>Options</h2>
		<form
			action="/deal"
			method="post"
		>
			<p>
				How many decks?
				<span style="float: right;">
					<select name="HowManyDecks">
						<c:forEach
							var="counter"
							begin="1"
							end="8"
						>
							<option value="${ counter }">${counter}</option>
						</c:forEach>
					</select>
					<button>Deal!</button>
				</span>
			</p>
		</form>

	</div>

	<!--<div class="card2">
		<h2>Login maybe?</h2>

	</div> -->
</body>
</html>