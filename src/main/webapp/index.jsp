<%--jsp:useBean id="Bean" type="example2.beans.PartsBean" scope="request" />--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h1>Parts list</h1>

<c:forEach items="${requestScope ['bean'].allParts}" var="part">
<p>${part.title}(${part.partNumber})</p>
</c:forEach>
<p>
    <a href="addpart.jsp">Add part</a>
</p>
</body>
</html>