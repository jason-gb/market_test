package action.recent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyCookieList;
import vo.product.ProductVo;

/**
 * Servlet implementation class ProductCookieListAction
 */
@WebServlet("/list_cookie.do")
public class ProductCookieListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//���� ������
		int cookie_page = Integer.parseInt(request.getParameter("cookie_page"));
		
		
        //�� ������ �� ������ �� 
        int pageSize = 3;
		
        //�� �������� ���۱� ��ȣ
		int startRow = (cookie_page - 1) * pageSize;
		//�� �������� ������ �۹�ȣ
        int endRow = cookie_page * pageSize - 1;
		
        
		List<ProductVo> cookielist2 = null;

		Cookie cookie_array[] = request.getCookies();

		try {
			cookielist2 = MyCookieList.getCookieList(cookie_array, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		//����������
		int last_page = (cookielist2.size()%pageSize==0 ? cookielist2.size()/pageSize : cookielist2.size()/pageSize+1 );
		
		System.out.println(last_page);
		
		List<ProductVo> cookielist = new ArrayList<ProductVo>();
		
		
		for(int i=startRow; i<=endRow; i++) {
			
			if(cookielist2.size()<=i) continue;
			
			
			ProductVo vo = cookielist2.get(i);

			
			cookielist.add(vo);
			
			
		}
		
		request.setAttribute("cookielist", cookielist);
		request.setAttribute("last_page", last_page);
		
		// forward
		String forward_page = "sidebar/cookie_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
