<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>


<html>
<head>
<title>Bill Box Monitor</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
        
</head>
<body>
<%
  Enumeration names = request.getParameterNames();
  while (names.hasMoreElements()) {
      String name = (String) names.nextElement();
      StringBuffer sb = new StringBuffer(name);
      sb.deleteCharAt(0);
     // com.logger.LogDB.Delete(sb.toString());
  }

%>

<br>

<div><%@ include file="header.jsp" %></div>
<br><br><br><br>
<div class="navigator">
<a href="input.jsp">Add</a>
<!--<a href="email.jsp">Email</a>-->
<a href="central.jsp">Central Service</a>
<a id="currenttab" href="billbox.jsp">Bill Box</a>
<a href="nibss.jsp">NIBSS</a>
</div>

<br> <br> <br>

<form action="billbox.jsp" method="post">
<table>
<tr>
<th>Service Source</th>
<th>Channel</th>
<th>Transaction Type</th>
<th>Provider Name</th>
<th>Pido Account</th>
<th>Beneficiary ID</th>
<th>Error Description</th>
<th>Error Date</th>
</tr> 
<%

  List list = com.logger.LogDB.GetBill();
  int id = 0;
  String box = null;

  Iterator<String> it = list.iterator();

  while (it.hasNext()) {
      id = Integer.parseInt(it.next());
      out.print("<tr>");
      for (int i = 0; i < 8; i++) {
          out.print("<td>");
          out.print(it.next());
          out.print("</td>");
  }
  out.print("<td>");
  box = "<input name=r" + id + " type='checkbox'>";
  out.print(box);
  out.print("</td>");
  out.print("</tr>");
 }
%>
 
</table>
<%
    int sum = 0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor",
        "root", "");
    Statement st = con.createStatement();
    ResultSet res = st.executeQuery("SELECT COUNT(error_description) FROM error_log where service_source = 'Billbox' ");
    while (res.next()) {
      int c = res.getInt(1);
      sum = sum + c;
    }
    out.print("Number of errors under BIllbox: " + sum);
  
%>
<br>
<input type="submit" value="Send Alert">

</form>
 
</body>
</html>