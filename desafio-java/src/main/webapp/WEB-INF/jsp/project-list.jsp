<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/project/add">Adicionar Projeto</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Portfolio List</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="14%">Nome</th>
      <th width="8%">Data Inicio</th>
      <th width="12%">Gerente</th>
      <th width="8%">Previsão Termino</th>
      <th width="15%">Descrição</th>
       <th width="10%">Status</th>
      <th width="33%"></th>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="project">
      <tr>
       <td>${project.nome}</td>
        <td>${project.data_inicio}</td>
        <td>${project.gerente}</td>
        <td>${project.data_previsao_fim}</td>
       	 <td>${project.descricao}</td>
         <td>${project.status}</td>
       <td><a type="button" class="btn btn-success"
        href="update?id=${project.id}">Update</a>
       <a type="button" class="btn btn-danger"
        href="delete?id=${project.id}">Delete</a>
            <a type="button" class="btn btn-secondary"
        href="cadastro_membros?id=${project.id}">Cadastrar Membros</a></td>
            
      </tr>
     </c:forEach> 
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="common/footer.jspf"%>