package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controler", "/main", "/controleFormnovo", "/select" })
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
			cadastro1(request, response);
			// controle de inserir
		} else if (action.equals("/controleFormnovo")) {
			novoCadastro(request, response);
			// controle de editar
		} else if (action.equals("/select")) {
			listarCadastro(request, response); 
			}else{ response.sendRedirect("index.html");
				}// fim do else
		} // fim do metodo get

	// lista de cadastrados
	protected void cadastro1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando objeto p receber javaBeans
		ArrayList<JavaBeans> lista = dao.listarCadastro();
		request.setAttribute("listarPao", lista);
		RequestDispatcher rd = request.getRequestDispatcher("pao.jsp");
		rd.forward(request, response);// leva obj lista ao pao.jsp
	}

	// novo cadastro
	protected void novoCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste imprimindo o console
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("descricao"));
		System.out.println(request.getParameter("preco"));
		// setar as variaveis JavaBeans
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setDescricao(request.getParameter("descricao"));
		cadastro.setPreco(request.getParameter("preco"));
		// inserircadastrobd passando objeto cadastrobd
		dao.inserirCadastroBd(cadastro);
		/* voltar a tela pao.jsp */
		response.sendRedirect("main");
	}
	
	/* Editando o formulário */
	protected void listarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		// criando uma variavel para receber o id que será editado
		String idcon = request.getParameter("idcon");
		// foi pra testa --System.out.println(idcon);
		// agora vamos pegar o id setando ele
		cadastro.setIdcon(idcon);
		// execultar o metodo selecionarCadastro (DAO)
		 dao.selecionarCadastro(cadastro);
		 // teste  do busca
		/** System.out.println(cadastro.getIdcon());
		 System.out.println(cadastro.getNome());
		 System.out.println(cadastro.getDescricao());
		 System.out.println(cadastro.getPreco()); **/
		 // buscando o conteúdo no BD e setando dentro de editar
		 request.setAttribute("idcon",cadastro.getIdcon());
		 request.setAttribute("nome",cadastro.getNome());
		 request.setAttribute("Descricao",cadastro.getDescricao() );
		 request.setAttribute("preco",cadastro.getPreco());
		// encaminhando os documentos
		 RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		 rd.forward(request, response);
	} // fim do listarCadastro
}
