<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CsvBean" %>
<html>
<head>
    <title>CSV Data</title>
</head>
<body>
    <h2>CSV Data</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <%
            List<CsvBean> csvDataList = (List<CsvBean>) request.getAttribute("csvDataList");
            if (csvDataList != null) {
                for (CsvBean csvData : csvDataList) {
                    out.println("<tr>");
                    out.println("<td>" + csvData.getID() + "</td>");
                    out.println("<td>" + csvData.getName() + "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr><td colspan='2'>No data found</td></tr>");
            }
        %>
    </table>
</body>
</html>
