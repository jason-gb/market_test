package action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.user.UserDao;
import vo.user.UserVo;

/**
 * Servlet implementation class LoginCheckAction
 */
@WebServlet("/user/check_id.do")
public class CheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		String u_id = request.getParameter("u_id");
		
		UserVo vo =  UserDao.getInstance().selectOneById(u_id);
		
		String result = "";
		
		//���̵� �������� ������ ���� ����
		if(vo==null) {
			result = "Y";
		}else {
			result = "N";
		}
		
		response.setContentType("text; charset=utf-8");
		response.getWriter().print(result);

	}

}
