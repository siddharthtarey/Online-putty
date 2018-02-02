package sshpack;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String name=(String)request.getParameter("uname");
		String pwd=(String)request.getParameter("pwd");
		HttpSession session=request.getSession(true);
		RequestDispatcher rd;
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session ses = fact.openSession();
		Transaction txn = ses.beginTransaction();
		Query query = ses.createQuery("from TUser where email=:email and password =:password");
		query.setParameter("email",name);
		query.setParameter("password", pwd);
		List<TUser> list = query.list();
		if(list == null || list.isEmpty())
		{
			request.setAttribute("message","Email/Password Invalid");
			rd=request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		for(TUser u : list)
		{	
			if(name.equals(u.getEmail())&&pwd.equals(u.getPassword())&& (u.getVer().equals("1")))
			{
				rd=request.getRequestDispatcher("/Connection.jsp");
				request.setAttribute("LOGGED", true);
				request.setAttribute("reg",true);
				HttpSession sess=request.getSession(true);
				sess.setAttribute("LOG",true);
				rd.forward(request, response);
			}
			else if(name.equals(u.getEmail())&&pwd.equals(u.getPassword())){
				rd=request.getRequestDispatcher("/Code.jsp");
				request.setAttribute("message", "please enter the verification code to connect to ssh ");
				request.setAttribute("LOGGED", true);
				request.setAttribute("name",u.getEmail());
				request.setAttribute("pwd",u.getPassword());
				rd.forward(request, response);
			}
		}
		txn.commit();
		ses.close();
		
		
	}

}
