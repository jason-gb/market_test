package action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.chat.ChatDao;
import dao.product.ProductDao;
import dao.trade.TradeDao;
import vo.chat.ChatVo;
import vo.product.ProductVo;

/**
 * Servlet implementation class AdminFormAction
 */
@WebServlet("/admin/main_form.do")
public class AdminMainFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//�ǽð� ��ǰ&ä�� ���ε�(list��ĭ �ȿ� �ֱ� vo��ü �ϳ� ������(�ִ� 6��))
		List<ProductVo> p_list = ProductDao.getinstance().selectRecentList();
		List<ChatVo>ch_list = ChatDao.getinstance().SelectRecentList();
		
		//���� ��ǰ���ε�
		int today_p_count = ProductDao.getinstance().selectTodayCount();
		
		//���� �ŷ���
		int today_t_count = TradeDao.getinstance().selectTodayCount();

		//���� �湮��
		Cookie[] list = request.getCookies();//�������������� ������ ��Ű����ŭ�� list���� �� ����
		int cnt = 0;
		
		for(int i = 0; list != null && i < list.length; i++) {
			if(list[i].getName().equals("cookie_cnt")) {
				cnt = Integer.parseInt(list[i].getValue());
				break;
			}
		}
		
		/* int today_u_count = UserDao.getInstance(). */
		
				
				
		//map���ٰ� ���� �ֱ� 		
		Map map = new HashMap();
		map.put("p_list", p_list);
		map.put("ch_list", ch_list);
		map.put("today_p_count",today_p_count);
		map.put("today_t_count",today_t_count);
		
		request.setAttribute("map", map);
		
		//forward
		String forward_page = "mainpage_admin.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}