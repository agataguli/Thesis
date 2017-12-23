<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<csrf disabled="true" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
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
				<h1>Adding products</h1>
				<section>
					<form:form modelAttribute="newProduct" class="form-horizontal">
						<fieldset>
							<legend> Add new product</legend>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="productId">
									<spring:message code="addProduct.form.productId.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="productId" path="productId" type="text"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="name">
									<spring:message code="addProduct.form.name.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="name" path="name" type="text"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="category">
									<spring:message code="addProduct.form.category.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="Category" path="category" type="text"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="brand">
									<spring:message code="addProduct.form.brand.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="brand" path="brand" type="text"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="grossValue">
									<spring:message code="addProduct.form.grossValue.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="grossValue" path="grossValue" type="number"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="netValue">
									<spring:message code="addProduct.form.netValue.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="netValue" path="netValue" type="number"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="description">
									<spring:message code="addProduct.form.description.label" />
								</label>
								<div class="col-lg-10">
									<form:textarea id="description" path="description" rows="4" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2" for="quantity">
									<spring:message code="addProduct.form.quantity.label" />
								</label>
								<div class="col-lg-10">
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
				</section>
			</div>
		</div>
	</section>

</body>
</html>