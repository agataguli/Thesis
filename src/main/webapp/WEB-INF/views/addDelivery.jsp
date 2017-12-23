<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<csrf disabled="true"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Delivered Products</title>
    </head>
    <body>
    <section>
            <p>
                <a href="<spring:url value="/" />" class="btn btndefault">
                    <span class="glyphicon-hand-left glyphicon"></span> Back to home page
                </a>
            </p>
            </section>
        <section>
            <div class=jumbotron>
                <div class="container">
                    <h1>Adding delivery details</h1>
                    <section>
                        <form:form modelAttribute="newDelivery" class="form-horizontal" enctype="multipart/form-data"
                        action="someURI?${_csrf.parameterName}=${_csrf.token}">
                            <fieldset>
                                <legend> Add new delivery file</legend>
                                <div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="deliveryId">Id: </label>
                                    <div class="col-lg-10">
                                        <form:input id="deliveryId" path="deliveryId" type="text" class="form:input-large" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="date">Date: </label>
                                    <div class="col-lg-10">
                                        <form:input id="date" path="date" type="date" class="form:input-large" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="">File: </label>
                                    <div class="col-lg-10">
                                        <form:input id="file" path="file" type="file" class="form:input-large" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
                                    </div>
                                </div>
                            </fieldset>
                        </form:form>
                    </section>
                </div>
            </div>
        </section>

    </body>
</html>