<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>orderItems</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>order items</hi>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${orderItems}" var="orderItem">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${orderItem.orderItemId}</h3>
                        <p>gross value [PL]: ${orderItem.itemGrossValue}</p>
                        <p>in order with Id: ${orderItem.orderId}</p>
                        <p>productId: ${orderItem.productId}</p>
                        <a href=" <spring:url value="/products/product?id=${orderItem.productId}" /> " class="btn btn-primary">
                            <span class="glyphicon-info-sign glyphicon"/></span> product details
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>