<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Logs</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>

        <div><%@ include file="header.jsp" %></div>
        <br><br><br><br>
        <div class="navigator">
            <a id="currenttab" href="input.jsp">Add</a>
            <!--<a href="email.jsp">Email</a>-->
            <a href="central.jsp">Central Service</a>
            <a href="billbox.jsp">BillBox</a>
            <a href="nibss.jsp">NIBSS</a>
        </div>
        <%
          
            String service_source = request.getParameter("service_source");
            String channel = request.getParameter("channel");
            String transaction_type = request.getParameter("transaction_type");
            String provider_name = request.getParameter("provider_name");
            String pido_account = request.getParameter("pido_account");
            String beneficiary_id = request.getParameter("beneficiary_id");
            String error_description = request.getParameter("error_description");
            String error_date = request.getParameter("error_date");

            if (service_source != null && channel != null
                    && transaction_type != null && provider_name != null && pido_account != null
                    && beneficiary_id != null && error_description != null && error_date != null) {
                com.logger.LogDB.InsertDB(service_source, channel, transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date);
                          }
           
        %>

        <br> <br> <br>

        <form method="post" action="input.jsp">
            <table>
                <tr>    
                    <td>Service Source</td><td><input type="text" name="service_source"></td>
                </tr>
                <tr>
                    <td>Channel</td><td><input type="text" name="channel"></td>
                </tr>
                <tr>
                    <td>Transaction Type</td><td> <input type="text" name="transaction_type"></td>
                </tr>
                <tr>
                    <td>Provider Name</td><td> <input type="text" name="provider_name"></td>
                </tr>
                <tr>
                    <td>Pido Account</td><td> <input type="text" name="pido_account"></td>
                </tr>
                <tr>
                    <td>Beneficiary ID</td><td> <input type="text" name="beneficiary_id"></td>
                </tr>
                <tr>
                    <td>Error Description</td><td> <input type="text" name="error_description"></td>
                </tr>
                <tr>
                    <td>Error Date</td><td> <input type="text" name="error_date"></td>
                </tr>
            </table>

            <br>
            <input type="submit" value="Submit" name="submit">
        </form>
    </body>
</html>