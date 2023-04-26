<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="web.ProduitModel" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<style>
form {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  margin-bottom: 20px;
}
h1 {
  text-align: center;
  
}
label {
  font-size: 18px;
  margin-right: 10px;
}

input[type="text"] {
  padding: 8px;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
}

button[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}
table {
  border-collapse: collapse;
  width: 50%;
  margin: 0 auto;
}

th, td {
  padding: 8px;
  text-align: center;
  border: 1px solid black;
}

th {
  background-color: #4CAF50;
}

</style>
<div >
<h1>Recherche produit</h1>
  
  
  <form action="chercher.do" method="get" >
  <label for="query">Recherche :</label>
  <input type="text" id="motCle" name="motCle" value="<%=request.getParameter("motCle")%>">
  <button type="submit">Chercher</button>
</form> 

<table>
  <tr>
    <th>ID</th>
    <th>Designation</th>
    <th>Prix</th>
    <th>Quantite</th>
  </tr>
  <c:if test="${not empty model.produit}">
    <c:forEach items="${model.produit}" var="p">
      <tr>
        <td>${p.id}</td>
        <td>${p.designation}</td>
        <td>${p.prix}</td>
        <td>${p.quantite}</td>
      </tr>
    </c:forEach>
  </c:if>
  <c:if test="${empty model.produit}">
    <tr>
      <td colspan="4">Aucun produit trouvé.</td>
    </tr>
  </c:if>
</table>
 </div>

 

</body>
</html>
