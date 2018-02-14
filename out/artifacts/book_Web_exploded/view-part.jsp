<jsp:useBean id="Bean" class="example2.beans.PartsBean" scope="application" />
<c:set target="bean" property="partId" value="${requestScope ['part-id']}"></c:set>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Part</title>
</head>
<body>
<h1>${bean.part.title} </h1>
</body>
</html>
