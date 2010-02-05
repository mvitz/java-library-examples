<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Persons</title>
    </head>
    <body>
        <h1>Persons</h1>
        <ul>
            <c:forEach var="p" items="${persons}">
            <li><a href="${p.id}/">${p.name}</a></li>
            </c:forEach>
        </ul>
    </body>
</html>