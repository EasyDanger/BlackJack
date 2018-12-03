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
	href="http://localhost:8080/styles.css"
>
<title>Deal</title>
</head>
<body>
	<c:choose>
		<c:when test="${ DealerWon }">
			<h3>Dealer got BlackJack! You Lose!</h3>
		</c:when>
	</c:choose>

	<main class="flex">
	<div class="card">
		<table class="table">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					var="item"
					items="${ Player.hand }"
				>
					<tr>
						<td>${item.name}</td>
						<td>
							<img
								src="${ item.image }"
								width="110px"
							/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${ not Busted && not DealerWon }">
				<a href="/deal/hit">
					<button class="botton1">Hit</button>
				</a>
				<a href="/deal/stay">
					<button class="botton1">Stay</button>
				</a>
			</c:when>
			<c:otherwise>
				<a href="/new">
					<button class="botton1">Play again?</button>
				</a>
			</c:otherwise>
		</c:choose>


	</div>

	<div class="card">
		<table class="table">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>image</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ DealerWon || DealerLost }">
						<c:forEach
							var="item1"
							items="${ Dealer.hand }"
						>
							<tr>
								<td>${item1.name}</td>
								<td>
									<img
										src="${ item1.image }"
										width="110px"
									/>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach
							items="${ Dealer.hand }"
							var="item2"
							varStatus="state"
						>
							<c:if test="${not state.first}">
								<tr>
									<td>${item2.name}</td>
									<td>
										<img
											src="${ item2.image }"
											width="110px"
										/>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<div class="card">
		<table class="table">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					var="item"
					items="${ Deck.cards }"
				>
					<tr>
						<td>${item.name}</td>
						<td>
							<img
								src="${ item.image }"
								width="110px"
							/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>