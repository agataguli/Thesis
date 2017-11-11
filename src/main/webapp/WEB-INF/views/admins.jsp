<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>admins</title>
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
            <h1>admins</hi>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${admins}" var="admin">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${admin.login}</h3>
                        <p>${admin.name} ${admin.surname}</p>
                        <p>Status: ${admin.active}</p>
                        <p>
                            <a href=" <spring:url value="/admins/admin?id=${admin.adminId}" /> "
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Admin details
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