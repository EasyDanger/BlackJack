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
<title>Deal</title>
</head>
<body>

	<div align="center">
		<a href="/debug">
			<button class="botton1">Debug</button>
		</a>
	</div>

	<c:choose>
		<c:when test="${ DealerBJ && not PlayerBJ }">
			<h2>Dealer got BlackJack! You Lose!</h2>
		</c:when>
		<c:when test="${ PlayerBJ && not DealerBJ }">
			<h2>You got BlackJack! You win!</h2>
		</c:when>
		<c:when test="${ PlayerWon && Dealer.value > 21 }">
			<h2>Dealer Busted out! You Win!</h2>
		</c:when>
		<c:when test="${ Push }">
			<h2>It's a push! No side!</h2>
		</c:when>
		<c:when test="${ PlayerWon }">
			<h2>You Win!</h2>
		</c:when>
		<c:when test="${ PlayerLost }">
			<h2>You Lose!</h2>
		</c:when>
		<c:when test="${ Busted }">
			<h2>You busted out!</h2>
		</c:when>
	</c:choose>

	<main class="flex">
	<div class="card2">
	<h2>Player's Hand</h2>
		<c:choose>
			<c:when test="${ Debug }">
				<h3>Player's Hand Value: ${ Player.value }</h3>
			</c:when>
		</c:choose>

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
			<c:when test="${ not Busted && not DealerWon && not Stay && not DealerBJ }">
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

	<div class="card2">
	<h2>Dealer's Hand</h2>
		<c:choose>
			<c:when test="${ Debug }">
				<h3>Dealer's hand Value: ${ Dealer.value }</h3>
			</c:when>
		</c:choose>
		<table class="table">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>image</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ DealerBJ || DealerLost || Stay }">
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

	<c:choose>
		<c:when test="${ Debug }">
			<div class="card2">
				<h3>Remaining cards in deck.</h3>
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
		</c:when>
	</c:choose>
</body>
</html>