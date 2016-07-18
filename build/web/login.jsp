<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/logo.css" type="text/css">
    </head>
    <body>

        <div>
        	
			<%@ include file="header.jsp" %>
        </div>
       
       
        <form method="POST" action="LoginAuthentication" id="login" name="actionForm">
            <table>
                <tr>    
                    <td>Username</td><td><input type="text" name="username" value=""></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password" value=""></td>
                </tr>
                
            </table>

            <br>
            <input type="submit" value="Submit" name="submit">
        </form>
        
    </body>
</html>