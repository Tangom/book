<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h1>Add part</h1>
<form action="/add-part" method="post">
<p><input type="text" name="title"></p>
<p><input type="text" name="part-number"></p>
<p><input type="submit"></p>
</form>
</body>
</html>