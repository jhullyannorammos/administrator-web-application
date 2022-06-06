<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<!--JQuery-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link href="../sb-admin/css/bootstrap.css" rel="stylesheet">
<!-- Add custom CSS here -->
<link href="../sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="../sb-admin/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

<script>
	$(document).ready(function() {
		$("#save-pdto").click(function() {
			var pdt = $('#pdt').val();
			var mdl = $('#mdl').val();
			var vlr = $('#vlr').val();
			$.ajax({
				method : 'POST',
				url : 'Produtos?actionServlet=100',
				data : {
					'pdt' : pdt,
					'idm' : mdl,
					'vlr' : vlr
				},
				error : function(data) {
					$("#dialog").addClass('alert alert-danger alert-dismissable');
					$("#dialog").dialog("Erro no cadastro :" + data);
					$('#dsc').val("");
					$('#vlr').val("");
				},
				success : function(data) {
					$.ajax({
						method : 'POST',
						url : 'Estoques?actionServlet=100',
						data : {
							'idm' : mdl
						},
					    sucess: function(data){
					    	$("#dialog").addClass('alert alert-success alert-dismissable');
							$("#dialog").text("Cadastro :" + data + " adicionado com sucesso");
							$('#dsc').val("");
							$('#vlr').val("");
					    },
						error : function(data) {
							$("#dialog").addClass('alert alert-danger alert-dismissable');
							$("#dialog").dialog("Erro :" + data  + " não foi criado no estoque");
							$('#dsc').val("");
							$('#vlr').val("");
						}
					});
				}
			});
		});
		$("#vlr").mask("00000");
	});
</script>
</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div id="wrapper">
				<h1>
					 <small></small>
				</h1>
				<ol class="breadcrumb">
					<li><a href=""><i class="fa fa-user"></i> Cadastro</a></li>
					<li class="active"><i class="fa fa-edit"></i> produtos</li>
				</ol>
				<form>
					<div id="dialog"></div>
					<div class="col-lg-6">
                        <h4>Nome do produto</h4>
						<select id="pdt" name="pdt" class="form-control">
						    <option>AMPLIFICADOR DE SOM</option>
						    <option>MULTIFUNCIONAL</option>
						    <option>ESTABILIZADOR</option>
						    <option>IMPRESSORA</option>
							<option>COMPUTADOR</option>
							<option>MICROONDAS</option>
							<option>ULTRABOOK</option>
							<option>NOTEBOOK</option>
							<option>TELEFONE</option>
							<option>MONITOR</option>
							<option>TECLADO</option>
							<option>CELULAR</option>
							<option>IPHONE</option>
							<option>MOUSE</option>
							<option>GAME</option>
							<option>SSD</option>
							<option>TV</option>
						</select>
                        
						<h4>Modelo do produto</h4>
						<select id="mdl" class="form-control">
						<md:forEach var="modelo" items="${modelodao.findByOrdenation('fornecedor')}">
							<option value="${modelo.id}" >${modelo.fornecedor.fornecedor} ${modelo.modelo} ${modelo.ano}</option>
						</md:forEach>
						</select>
						
						<h4>Preço (R$)</h4>
						<div class="form-group input-group">
                             <span class="input-group-addon">R$</span>
                             <input id="vlr" type="text" class="form-control">
                             <span class="input-group-addon">.00</span>
                        </div>
                        <!--  
                        <h4>Classificação</h4>
						<select id="tpm" name="tpm" class="form-control">
						    <option>MATERIAL</option>
						    <option>INSUMO</option>
						</select>
						<h4>Descrição</h4>
						<textarea rows="2" cols="50" class="form-control" style="resize: none" name="dsc" id="dsc" >
						</textarea>
						-->
                        <br /> <br />
						<button id="save-pdto" type="button" class="btn btn-success">Cadastrar</button>
						
						<button title="Novo" style="left, margin-left:15%;"
					         onclick="window.location = '?pg=230';" 
					         type="button"
					         class="btn btn-primary btn-sm">
					         <i class="fa fa-plus"> Adicionar modelo</i>
				        </button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>