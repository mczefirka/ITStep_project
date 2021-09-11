<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Song List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>Song List</h1>
    
    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Song name</th>
          <th>Genre name</th>
          <th>Rating</th>
          <th>Download quantity</th>
          <th>DB date</th>
          <th>Song year</th>
        </tr>
        <c:forEach  items="${songs}" var ="song">
        <tr>
          <td>${song.song_name}</td>
          <td>${song.genre_name}</td>
          <td>${song.rating}</td>
          <td>${song.download_quantity}</td>
          <td>${song.db_date}</td>
          <td>${song.song_year}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>
  
</html>