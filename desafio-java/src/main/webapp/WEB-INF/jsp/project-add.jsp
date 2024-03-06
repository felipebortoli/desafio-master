<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Adicionar Projeto</div>
    <br/>
    <div class="panel-body">
     <form:form method="post" modelAttribute="project">
      <form:hidden path="id" />
      <fieldset class="form-group">
       <form:label path="nome">nome</form:label>
       <form:input path="nome" type="text" class="form-control"
        required="required" />
       <form:errors path="nome" cssClass="text-warning" />
      </fieldset>
       <br/>
      <fieldset class="form-group">
       <form:label path="descricao">Descrição</form:label>
       <form:input path="descricao" type="text" class="form-control"/>
       <form:errors path="descricao" cssClass="text-warning" />
      </fieldset>
       <br/>
     <fieldset class="form-group">
       <form:label path="gerenteProjetoId">Gerente Responsavel</form:label>
             
       <form:select path="gerenteProjetoId" class="form-control" >
      		<form:options items="${project.gerentes}" itemValue="idPessoa" itemLabel="nome"/>

       </form:select>
            
       <form:errors path="gerenteProjetoId" cssClass="text-warning" />
      </fieldset>
       <br/>
      <fieldset class="form-group">
       <form:label path="classificacaoRisco">Classificação Risco</form:label>
       <form:select path="classificacaoRisco" class="form-control">
       		<option value="BAIXO_RISCO">Baixo Risco</option>
       		<option value="MEDIO_RISCO">Medio Risco</option>
       		<option value="ALTO_RISCO">Alto Risco</option>
       </form:select>
       <form:errors path="classificacaoRisco" cssClass="text-warning" />
      </fieldset>
       <br/>
       <fieldset class="form-group">
       <form:label path="status">Status Projeto</form:label>
       <form:select path="status" class="form-control">
       		<option value="EM_ANALISE">Em analise</option>
       		<option value="ANALISE_REALIZADA">Analise realizada</option>
       		<option value="ANALISE_APROVADA">Analise aprovada</option>
       		<option value="INICIADO">Iniciado</option>
       		<option value="PLANEJADO">Planejado</option>
       		<option value="EM_ANDAMENTO">Em andamento</option>
       		<option value="ENCERRADO">Encerrado</option>
       		<option value="CANCELADO">Cancelado</option>
       </form:select>
       <form:errors path="status" cssClass="text-warning" />
      </fieldset>
		 <br/>
      <fieldset class="form-group">
       <form:label path="data_inicio">Data Inicio</form:label>
       <form:input path="data_inicio" type="date" class="form-control"/>
       <form:errors path="data_inicio" cssClass="text-warning" />
      </fieldset>
       <br/>
      <fieldset class="form-group">
       <form:label path="data_previsao_fim">Data Previsão Fim</form:label>
       <form:input path="data_previsao_fim" type="date" class="form-control"/>
       <form:errors path="data_previsao_fim" cssClass="text-warning" />
      </fieldset>
       <br/>
      <fieldset class="form-group">
       <form:label path="data_fim">Data Fim</form:label>
       <form:input path="data_fim" type="date" class="form-control"/>
       <form:errors path="data_fim" cssClass="text-warning" />
      </fieldset>
 		<br/>
 		
 	  <fieldset class="form-group">
       <form:label path="orcamento">Orçamento</form:label>
       <form:input path="orcamento" type="number" class="form-control"/>
       <form:errors path="orcamento" cssClass="text-warning" />
      </fieldset>
      <br/>
      <button type="submit" class="btn btn-success">Save</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jspf"%>