package sshpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int val = 1;
		int code = (int)(Math.random()*1000);
		String ver = "0";
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String pwd1=request.getParameter("pwd1");
		RequestDispatcher rd1=request.getRequestDispatcher("/Signup.jsp");
		if(email == null)
		{
			rd1.forward(request, response);
		}
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session sess = fact.openSession();
		Transaction txn = sess.beginTransaction();
		
		Query query = sess.createQuery("from TUser where email=:email");
		query.setParameter("email",email);
		@SuppressWarnings("unchecked")
		ArrayList<TUser> p = (ArrayList<TUser>) query.list();
		
		TUser  p2=new TUser(email, pwd1, fname, lname,code,ver);
		for(TUser u : p){
		if(u.getEmail().equals(p2.getEmail())){
			val = 0;
			request.setAttribute("message", "Name Already Exists");
			RequestDispatcher rd=request.getRequestDispatcher("/Signup.jsp");
			txn.commit();
			sess.close();
			rd.forward(request, response);
		}
		}
		if(val == 1 ){

			p.add(p2);	
			sess.save(p2);
			txn.commit();
			sess.close();
			/*String a = "Verification Code For Account on SSHute ";
			String b = "Your verification code is: " + code;
			request.setAttribute("recipient",p2.getEmail());
			request.setAttribute("subject",a);
			request.setAttribute("content",b);
			request.setAttribute("name",email);*/
			String recipient = p2.getEmail();
			String subject = "Verification Code For Account on SSHute ";
			String content = "Your verification code is: " + code;

			String resultMessage = "";

			try {
				EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
				resultMessage = "The e-mail was sent successfully";
				request.setAttribute("Message", resultMessage);
				request.setAttribute("VAL",true);
				request.setAttribute("name",p2.getEmail());
				RequestDispatcher rd2 = request.getRequestDispatcher("/Code.jsp");
				rd2.forward(request, response);
				//getServletContext().getRequestDispatcher("/Code.jsp").forward(request, response);
				
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			} finally {
				resultMessage = "Not Successful";
				request.setAttribute("message", resultMessage);
				request.setAttribute("VAL",true);
				
				//getServletContext().getRequestDispatcher("/Code.jsp").forward(request, response);
				//request.setAttribute("VAL",true);
			}
			request.setAttribute("message", "Enter the Verification code");
			//rd1.forward(request, response);
			
		}
		
	}

	}


