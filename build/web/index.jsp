<%-- 
    Document   : index
    Created on : May 18, 2023, 1:57:22 PM
    Author     : TTNhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("title", "All Users");%>
<% request.getRequestDispatcher("home.jsp").forward(request, response);%>