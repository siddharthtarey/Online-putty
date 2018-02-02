package sshpack;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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

/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
    public Forgot() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String name = (String)request.getParameter("email");
		if(name.equals("")||name.equals(null)){
			response.sendRedirect("Forgot.jsp");
		}else{
			SessionFactory fact=new Configuration().configure().buildSessionFactory();
			Session sess = fact.openSession();
			Transaction txn = sess.beginTransaction();
			
			Query query = sess.createQuery("from TUser e where e.email = :email");
			query.setParameter("email",name);
			@SuppressWarnings("unchecked")
			List<TUser> list = query.list();
			if(list == null || list.isEmpty())
			{
				txn.commit();
				sess.close();
				request.setAttribute("message","No Such User Exits");
				RequestDispatcher rd=request.getRequestDispatcher("Forgot.jsp");
				rd.forward(request, response);
			}
			for(TUser p2 : list)
			{	
				if(name.equals(p2.getEmail()))
				{
					String recipient = p2.getEmail();
					String subject = "Password of your Account at SSHHUTE  ";
					String content = "Your user name is: " + name  + "Your Password is: " + p2.getPassword();

					String resultMessage = "";

					
						try {
							EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						resultMessage = "The e-mail was sent successfully";
						
						request.setAttribute("message", resultMessage);
						request.setAttribute("VAL",true);
						request.setAttribute("name",p2.getEmail());
						
						RequestDispatcher rd2 = request.getRequestDispatcher("/Login.jsp");
						rd2.forward(request, response);
						
						
					
					
				}	
			}
			
				
			}
			
		
	}

}
