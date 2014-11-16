<%@page contentType="text/html; charset=UTF-8"%>

<%@page import="maristas.dao.planDAO" %>

<%!
    planDAO objetivo=null;
%>

 <%
    objetivo = new planDAO();
    out.print(objetivo.get_objetivos());
%>
