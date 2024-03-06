<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Funcionarios Empresa</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="25%">Nome</th>
      <th width="10%">Gerente</th>
      <th width="25%">Cargo</th>
      <th width="40%"></th>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${membros}" var="membro">
    <form:form method="post" modelAttribute="membroProjeto">
      <tr>
       <td>${membro.nome} <form:input path="nome" hidden="true" type="text" name="cargo" value="${membro.nome}" /> </td>
        <td>${membro.gerente}<form:input path="gerente" hidden="true" type="text" name="cargo" value="${membro.gerente}"/></td>
         
        <td> <form:input path="cargo" required="required" class="form-control" type="text" name="cargo" value="${membro.cargo}" /> </td>
        	 <form:errors path="cargo" cssClass="text-warning" />
        <form:input path="idPessoa" hidden="true" type="text" name="idpessoa" value="${membro.idPessoa}" />	 
        <td><button type="submit" class="btn btn-success">Cadastrar Membro</button>
        	
        </td>
       </tr>
       <form:input path="idProjeto" hidden="true" type="text" name="idP`rojeto" value="${idProjeto}" />	 
        </form:form>    
     </c:forEach> 
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="common/footer.jspf"%>