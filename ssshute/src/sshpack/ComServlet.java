package sshpack;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.neoremind.sshxcute.core.Result;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.exception.TaskExecFailException;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;

/**
 * Servlet implementation class ComServlet
 */
@WebServlet("/ComServlet")
public class ComServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		HttpSession ses=request.getSession(true);
		Boolean att = (Boolean)ses.getAttribute("LOG");
		if(att == null || !att)
		{
			request.setAttribute("message","You are not Logged-IN");
			RequestDispatcher rd1=request.getRequestDispatcher("/Login.jsp");
			rd1.forward(request, response);
		}else{
		String cmds=request.getParameter("cmd");
		SSHExec attribute = (SSHExec) ses.getAttribute("instance");
		CustomTask task=new ExecCommand(cmds);
		try 
		{
			Result exec = attribute.exec(task);
			rd=request.getRequestDispatcher("/CommandExec.jsp");
			String msg= exec.sysout;
			
			request.setAttribute("answer",msg);
			rd.forward(request, response);
		} 
		catch (TaskExecFailException e)
		{
			
			e.printStackTrace();
			
		}
		}
		
	}
}
