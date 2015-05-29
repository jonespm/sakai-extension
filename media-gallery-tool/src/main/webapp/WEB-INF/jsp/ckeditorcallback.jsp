 <?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link media="all" href="/library/skin/tool_base.css" rel="stylesheet" type="text/css" />

    <script src="/library/js/headscripts.js" type="text/javascript"></script>
    <script src="/library/js/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>

    <!-- Twitter Bootstrap -->
    <script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
    <link media="all" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
    <link media="all" href="<c:url value='/bootstrap/css/bootstrap-theme.min.css'/>" rel="stylesheet" type="text/css" />

    <!-- Additional CSS -->
    <link media="all" href="<c:url value='/css/kaltura_ui.css'/>" rel="stylesheet" type="text/css" />

</head>
<body onload="<%=request.getAttribute("sakai.html.body.onload")%>">

    <div id="url">${mediaitem.url}</div>
    <div id="playerId">${mediaitem.playerId}</div>
    <div id="size">${mediaitem.size}</div>
    <div id="width">${mediaitem.width}</div>
    <div id="height">${mediaitem.height}</div>
    <div id="returnType">${mediaitem.returnType}</div>
    <div id="entryId">${mediaitem.entryId}</div>
    <div id="owner">${mediaitem.owner}</div>
    <div id="title">${mediaitem.title}</div>
    <div id="duration">${mediaitem.duration}</div>
    <div id="description">${mediaitem.description}</div>
    <div id="createdAt">${mediaitem.createdAt}</div>
    <div id="tags">${mediaitem.tags}</div>

    <div id="thumbnailUrl">${mediaitem.thumbnailUrl}</div>
<script src="<c:url value='/js/ckeditorinsert.js'/>" type="text/javascript"></script>
</body>
</html>
