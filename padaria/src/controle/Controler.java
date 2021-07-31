package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns ={"/Controler", "/main","/controleFormnovo"})
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
		} else if (action.equals("/controleFormnovo")) {
				novoCadastro(request,response);
		       } else {
		    	   response.sendRedirect("index.html");
		       }// fim do else
	} // fim do metodo get
	
	
	// lista de cadastrados
	protected void cadastro1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando objeto p receber javaBeans
		ArrayList<JavaBeans>lista = dao.listarCadastro(); 
		request.setAttribute("contatos", lista);
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
			/* voltar ao pao.jsp*/
			response.sendRedirect("main");
		}

	
}
