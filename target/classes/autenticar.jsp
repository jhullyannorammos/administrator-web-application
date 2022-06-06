<script src="jquery-ui-1.12.1/jquery.js" type="text/javascript"></script>
<script src="jquery-ui-1.12.1/jquery-ui.js" type="text/javascript"></script>
<script src="js/js.js" type="text/javascript"></script>

<style>
/*@import url(https://fonts.googleapis.com/css?family=Roboto:300);*/
.logo img {
    position: relative;
    border-bottom-left-radius: 25px;
    margin-top: -50px;
	margin-right: 0px;
	margin-left: auto;
	width: 405px;
	height: 150px;
}
/*
.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}
*/
.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-height: 600px;
	max-width: 360px;
	margin: auto;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #FFFFFF;
	width: 100%;
	border: #262626;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form input:hover{
    border-bottom: #0088FF;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #0088FF;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	/*border-radius: 25px;*/
	background: #0088FF;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #0088FF;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 0px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #262626; /* fallback for old browsers */
	padding: auto;
	margin: auto;
	height: auto;
	/*
        background: -webkit-radial-gradient(right, #76b852, #8DC26F);
        background: -moz-radial-gradient(right, #76b852, #8DC26F);
        background: -o-radial-gradient(right, #76b852, #8DC26F);
        background: radial-gradient(to left, #76b852, #8DC26F);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;      
        */
}
</style>
<body>



	<div class="form">
	    <div class="logo">
				<img src="src/logo_saneago.png" />
			</div>
		<div class="container">

			

			<%
            String formRequest = "";
            int i = Integer.parseInt(request.getParameter("Service"));
            switch (i) {
                case 193://logar
                    formRequest = "Acessos?actionServlet=555";
        %>
			<!--<form action="<% out.println(formRequest); %>" method="POST" class="login-form">-->
			<form class="login-form">
				<img src="src/avatar_empresario.jpg" /> <br /> <br /> <input
					id="boxlogin" name="boxlogin" type="text" placeholder="Email" /> <input
					id="boxpassword" name="boxpassword" type="password"
					placeholder="Password" />
				<button id="logar">Entrar</button>
				<p class="message">
					Esqueceu sua senha? <a href="autenticar.jsp?Service=274">Redefina agora</a>
				</p>
			</form>
			<%
                break;
            case 184://cadastrar novo administrador
                formRequest = "AccountManager?actionServlet=222";
        %>
			<!--<form action="<% out.println(formRequest); %>" method="POST" class="login-form">-->
			<form action="<%out.println(formRequest);%>" method="POST"
				class="login-form">
				<input id="boxlogin" name="boxName" type="text"
					placeholder="Nome completo" /> <input id="boxlogin" name="boxMail"
					type="text" placeholder="Email" /> <input id="boxpassword"
					name="boxpassword1" type="password" placeholder="Nova senha" /> <input
					id="boxpassword" name="boxpassword2" type="password"
					placeholder="Repita a senha" />
				<button id="_logar">cadastrar</button>
			</form>
			<%
				break;
				case 274://solicitar alteracao de senha
					formRequest = "AccountManager?actionServlet=771";
			%>
			<form class="login-form">
			    <img src="src/avatar_empresario.jpg" /> <br /> <br />
				<input name="boxlogin" type="text" placeholder="Email" />
				<button id="_solicitarAlteracao" type="submit">Enviar</button>
			</form>
			<p class="message">
					Fa�a login agora <a href="autenticar.jsp?Service=193">Clique agora</a>
				</p>
			<%
				break;
				case 386://alterar a senha depois de receber o email de requisição de servico
					formRequest = "AccountManager?actionServlet=771";
			%>
			<form action="<%out.println(formRequest);%>" method="POST"
				class="login-form">
				<input name="boxlogin" type="text" placeholder="Email" />
				<button id="_Alteracao" type="submit">Resetar senha</button>
			</form>
			<%
				break;
				case 122://alterar a senha depois de receber o email de requisição de servico
					formRequest = "AccountManager?actionServlet=323";
			%>
			<form action="<%out.println(formRequest);%>" method="POST"
				class="login-form">
				<input name="boxlogin" type="text" placeholder="Email" />
				<button id="_Alteracao" type="submit">Enviar</button>
			</form>
			<%
				break;
				}
			%>

		</div>
	</div>


</body>