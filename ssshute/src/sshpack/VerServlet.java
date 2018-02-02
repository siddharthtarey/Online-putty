package sshpack;

import java.io.IOException;
import java.io.PrintWriter;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class VerServlet
 */
@WebServlet("/VerServlet")
public class VerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerServlet() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		//out.println("Hello : ");
		//out.println("\n\n\n\nName1 : " + name);
		String name  = (String)request.getParameter("email");
		if(name == null){
			request.setAttribute("message","Email/Password Does not Exists");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			
			rd.forward(request, response);
			//response.sendRedirect("Login.jsp");
		}

		request.setAttribute("name",name);
		String code=request.getParameter("code");
		
		
		if(code == null || code == "")
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Code.jsp");
			request.setAttribute("message","Code is null");
			rd.forward(request, response);
			//response.sendRedirect("Code.jsp");
		}
		
		
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session sess = fact.openSession();
		Transaction txn = sess.beginTransaction();

		Query query = sess.createQuery("from TUser where email=:email");
		query.setParameter("email",name);
		@SuppressWarnings("unchecked")
		List<TUser> list = query.list();
		//TUser p2 = new TUser();
		if(list == null && list.isEmpty())
		{
			
			request.setAttribute("message","Email/Password list is null");
			RequestDispatcher	rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/Login.jsp");
		}
		int code1 = 0;
		if(code != null && code != ""){
		 code1 = Integer.parseInt(code);
		}
		boolean value = false;
		for(TUser p : list){
		
		//TUser a = new TUser(p);
		if(name.equals(p.getEmail())&& (code1 == p.getCode())){
			
			//User u = new User(p);
			p.setVer("1");
			//p.add(p2);	
			sess.update(p);
			txn.commit();
			sess.close();
			value = true;
			
			HttpSession ses=request.getSession(true);
			ses.setAttribute("LOG",true);
			
			request.setAttribute("LOGGED",true);
			request.setAttribute("reg",true);
		
			RequestDispatcher rd=request.getRequestDispatcher("/Connection.jsp");
			PrintWriter out = response.getWriter();
			out.println(rd);
			rd.forward(request, response);
				
		}
		}
		if(value == false){
			RequestDispatcher rd=request.getRequestDispatcher("/Code.jsp");
			request.setAttribute("message", "Please enter the correct Verification code");
			rd.forward(request, response);	
			}
			
		
		
	}
}


