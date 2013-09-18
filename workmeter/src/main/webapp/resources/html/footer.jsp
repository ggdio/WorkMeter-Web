<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<c:url value="/resources/img/footer/oracle.png" var="imgBrand"/>

<br/>
<div class="navbar navbar-fixed-bottom">
	    <div class="navbar-inner">
	    	<div class="pull-left">
		    	<a href="#" target="_blank">
		    	<img title="Powered by" src="${imgBrand}" width="100px" height="40px"/>
		    	</a>
		    </div>
		    <div class="pull-right">
		    	<tags:idiomaDropdown/>
		    </div>
	    </div>
    </div>
</body>
</html>