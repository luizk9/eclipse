package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controler", "/main", "/controleFormnovo", "/select", "/update", "/delete", "/report" })
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans cadastro = new JavaBeans();

	public Controler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			cadastro(request, response);
			// controle de inserir
		} else if (action.equals("/controleFormnovo")) {
			novoCadastro(request, response);
			// controle de editar
		} else if (action.equals("/select")) {
			listarCadastro(request, response);
		} else if (action.equals("/update")) {
			editarCadastro(request, response);
		} else if (action.equals("/delete")){
			removerCadastro(request, response);
		} else if (action.equals("/report")){
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		} // fim do else
	} // fim do metodo get

	// lista de cadastrados
	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando objeto p receber javaBeans
		ArrayList<JavaBeans> lista = dao.listarCadastro();
		request.setAttribute("listarPao", lista);
		RequestDispatcher rd = request.getRequestDispatcher("pao.jsp");
		rd.forward(request, response);// levando obj lista ao pao.jsp
	}

	// novo cadastro
	protected void novoCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * // teste imprimindo o console
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("descricao"));
		 * System.out.println(request.getParameter("preco"));
		 **/

		// setar as variaveis JavaBeans
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setDescricao(request.getParameter("descricao"));
		cadastro.setPreco(request.getParameter("preco"));
		// inserircadastrobd passando objeto cadastrobd
		dao.inserirCadastroBd(cadastro);
		/* voltar a tela pao.jsp */
		response.sendRedirect("main");
	}

	/* prepara a pagina EDITOR */
	protected void listarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando uma variavel para receber o id que será editado
		String idcon = request.getParameter("idcon");
		// foi pra testa --System.out.println(idcon);
		// agora vamos pegar o id setando ele
		cadastro.setIdcon(idcon);
		// execultar o metodo selecionarCadastro (DAO)
		dao.selecionarCadastro(cadastro);
		/**
		 * ....// teste a busca System.out.println
		 * (cadastro.getIdcon());
		 * System.out.println(cadastro.getNome());
		 * System.out.println(cadastro.getDescricao());
		 * System.out.println(cadastro.getPreco());
		 **/
		// buscando o conteúdo no BD e setando dentro de editar
		request.setAttribute("idcon", cadastro.getIdcon());
		request.setAttribute("nome", cadastro.getNome());
		request.setAttribute("descricao", cadastro.getDescricao());
		request.setAttribute("preco", cadastro.getPreco());
		// encaminhando os documentos
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	} // fim do listarCadastro

	/* EDITAR -ALTERARANDO NO Bd */
	protected void editarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// armazenar as variaveis do EDITAR NO javaBeans
		cadastro.setIdcon(request.getParameter("idcon"));
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setDescricao(request.getParameter("descricao"));
		cadastro.setPreco(request.getParameter("preco"));

		// Execultando o método alterarCadastro
		dao.alterarCadastro(cadastro);

		// redirecionar, voltando a pagina de listarPao atualizandar
		response.sendRedirect("main");
	} // fim do metodo editar -alterar cadastro

	// metodo remover Cadastro
	protected void removerCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		 // System.out.println(idcon); //testando se ta pegando o id
		cadastro.setIdcon(idcon);

		// Execultando o método deletarCadastro na DAO
		dao.deletarCadastro(cadastro);
		// volta tela cadastro atualizando apos o delete
		response.sendRedirect("main"); 
	} // fim do metodo removercadastro
	
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de conteúdo
			response.setContentType("apllication/pdf");
			//nome do documento
			response.addHeader("Content-Disposition", "inline,filename="+"cadastro.pdf");
			// criando o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento gerando conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de pão:"));
			documento.close();
			
		} catch (Exception e) {
			System.out.println(e);
			documento.close(); // fechando o documento
		}
		
	
	} // fim do metodo gerarRelatorio

} // fim Controller



