<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<csrf disabled="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Delivery addition</title>
</head>
<body>
	<section>
		<p>
			<a href="<spring:url value="/" />" class="btn btndefault"> <span
				class="glyphicon-hand-left glyphicon"></span> Back to home page
			</a>
		</p>
	</section>
	<section>
		<div class=jumbotron>
			<div class="container">
				<h1>Adding delivery</h1>
				<section>
        <form:form modelAttribute="newDelivery" class="form-horizontal">
            <fieldset>
                <legend> Add new delivery</legend>
                <div class="form-group">
                    <div class="col-lg-10">
                    <div>ProductId</div>
                        <form:input id="productId" path="productId" type="text"
                            class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10">
                    <div>Quantity</div>
                        <form:input id="quantity" path="quantity" type="text"
                            class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                            value="Add" />
                    </div>
                </div>
            </fieldset>
        </form:form>

    </body>
</html>