<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="Head.jsp" flush="true"></jsp:include>
<body>
<jsp:include page="TopAndSideMenu.jsp" flush="true"></jsp:include>

<script type="text/javascript">
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

});

</script>
</body>
</html>