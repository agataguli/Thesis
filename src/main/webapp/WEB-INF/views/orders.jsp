<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>users</title>
</head>
<body>
<section>
    <p>
        <a href="<spring:url value="/" />" class="btn btndefault">
            <span class="glyphicon-hand-left glyphicon"></span> Back
        </a>
    </p>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>orders</hi>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${orders}" var="order">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${order.orderId}</h3>
                        <p>Date: ${order.date}</p>
                        <p>
                            <a href=" <spring:url value="/orders/order?id=${order.orderId}" /> "
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span>Order details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>