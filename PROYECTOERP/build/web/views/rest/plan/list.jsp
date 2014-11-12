<%@page contentType="Content-Type: application/json"%>

<%@page import="maristas.dao.planDAO" %>

<%!
    planDAO plan=null;
%>

 <%
    plan = new planDAO();
    out.print(plan.get_planes());
%>