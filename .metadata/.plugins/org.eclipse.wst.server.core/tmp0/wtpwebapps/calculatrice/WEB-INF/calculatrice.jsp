<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculatrice</title>
</head>
<body>
	<form method="post" action="calculatrice">
		<p>Resultat de l'operation : ${calculette.operande1} ${calculette.operateur} ${calculette.operande2} = 
		${calculette.operateur=="-"?calculette.soustraire(calculette.operande1, calculette.operande2):
		((calculette.operateur=="+" ) ? calculette.additionner(calculette.operande1, calculette.operande2) :
		((calculette.operateur=="/" ) ? calculette.diviser(calculette.operande1, calculette.operande2) :
		((calculette.operateur=="*" ) ? calculette.multiplier(calculette.operande1, calculette.operande2) : "Probleme de format")))}
		
		</p>
		<br> 
		<input type="number" name="Operande1" > 
		<select name="Operateur">
			<option value="+">+</option>
			<option value="/">/</option>
			<option value="-">-</option>
			<option value="*">*</option>
		</select> <input type="number" name="Operande2"> 
		<input type="submit" value="Envoyer">
	</form>
<%-- 	${!operateur=="+"?(!operateur=="-"?(!operateur=="*"?(!operateur=="/"?"":(operande1/operande2)):(operande1*operande2)):(operande1-operande2)):(operande1+operande2)} --%>
</body>
</html>