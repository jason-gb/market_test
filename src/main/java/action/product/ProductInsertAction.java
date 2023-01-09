package action.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.image.ImageDao;
import dao.product.ProductDao;
import vo.image.ImageVo;
import vo.product.ProductVo;

/**
 * Servlet implementation class ProductInsertAction
 */
@WebServlet("/product/product_insert.do")
public class ProductInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1. request encoding �ϱ�
		request.setCharacterEncoding("utf-8");
		
		//���� ��� ���ϱ�.
		String path = request.getServletContext().getRealPath("/imgdata/");
		
		//���� �ִ� ��ϻ�����
		int max_size = 1024 * 1024 * 10; 
		
		
		System.out.println(path);
		//���ϵ���ϱ� ���� MultipartRequest����, request�� ���� ���ӹ���
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		String sumimage = "no_image";
		String imageFile1 = "no_image";
		String imageFile2 = "no_image";
		String imageFile3 = "no_image";
		String imageFile4 = "no_image";
		String imageFile5 = "no_image";
		
		//2. parameter �ޱ�
		int u_idx = 3; // ȸ�������� ���߿� ���ǿ��� �޾ƿ;���.
		int c_idx	  		= Integer.parseInt(mr.getParameter("c_idx"));
		String p_name 		= mr.getParameter("p_name");
		int	p_price			= Integer.parseInt(mr.getParameter("p_price"));
		String p_condition	= mr.getParameter("p_condition");
		String p_exp		= mr.getParameter("p_exp").replaceAll("\r\n", "<br>");
		String p_location	= mr.getParameter("p_location");
		
		String p_status = "�ŷ�����";
		
		ProductVo vo = new ProductVo(u_idx, c_idx, p_name, p_price, p_condition, p_exp, p_location, p_location, p_status);
		
		
		//�浹����..
		
		int res = ProductDao.getinstance().insert(vo); 
		
		
		
		
		File f1 = mr.getFile("sumimage");
		if(f1!=null) {
			sumimage = f1.getName();
		}
		File f2 = mr.getFile("imageFile1");
		if(f2!=null) {
			imageFile1 = f2.getName();
		}
		File f3 = mr.getFile("imageFile2");
		if(f3!=null) {
			imageFile2 = f3.getName();
		}
		File f4 = mr.getFile("imageFile3");
		if(f4!=null) {
			imageFile3 = f4.getName();
		}
		File f5 = mr.getFile("imageFile4");
		if(f5!=null) {
			imageFile4 = f5.getName();
		}
		File f6 = mr.getFile("imageFile5");
		if(f6!=null) {
			imageFile5 = f6.getName();
		}
		
		
		ImageVo vo2 = new ImageVo(sumimage, imageFile1, imageFile2, imageFile3, imageFile4, imageFile5);
		
		
		
		int res2 = ImageDao.getInstance().insert(vo2);

		JSONObject json = new JSONObject();
		
		
		System.out.println(res);
		System.out.println(res2);
		
		boolean bResult = false;
		
		if(res==1 && res2==1) {
			
			bResult = true;
			
		}
		
		json.put("res", bResult);
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toJSONString(json));
		

	}

}
