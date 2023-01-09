package dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.product.ProductVo;

public class ProductDao {

	SqlSessionFactory factory;

	// single-ton : ��ü 1���� �����ؼ� ���
	static ProductDao single = null;

	public static ProductDao getinstance() {

		// ��ü�� null�̸� �����ض�
		if (single == null)
			single = new ProductDao();

		return single;
	}

	// �ܺο��� �������� �� ��
	private ProductDao() {
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	//��ǰ ��ü��ȸ
	public List<ProductVo> selectList() {

		List<ProductVo> list = null;

		// 1.SqlSession������
		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("product.product_list");

		// 3.�ݱ�
		sqlSession.close();

		return list;
	}
	
	// ī�װ��� ��ȸ
	public List<ProductVo> selectList(String c_idx) {
		// TODO Auto-generated method stub
		List<ProductVo> list = null;

		// 1.SqlSession������
		SqlSession sqlSession = factory.openSession();

		// 2.����
		list = sqlSession.selectList("product.product_c_idx", c_idx);

		// 3.�ݱ�
		sqlSession.close();

		return list;
	}
	
	//u_idx �������� �ѱ�
	public List<ProductVo> selectList(int u_idx) {
		// TODO Auto-generated method stub
		
		List<ProductVo> list = null;

		// 1.SqlSession������
		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("product.product_user_idx",u_idx);

		// 3.�ݱ�
		sqlSession.close();
		
		
		return list;
	}
	
	//��ǰ���� �ѱ�
	public ProductVo selectList2(int p_idx) {
		// TODO Auto-generated method stub
		ProductVo vo = null;

		// 1.SqlSession������
		SqlSession sqlSession = factory.openSession();

		vo = sqlSession.selectOne("product.product_p_idx",p_idx);

		// 3.�ݱ�
		sqlSession.close();
		
		
		return vo;
	}


	//�ֱ� ��ǰ ��ȸ(mainpage_admin)
	public List<ProductVo> selectRecentList() {
		
		List<ProductVo> list = null;

		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("product.recent_product");

		sqlSession.close();
		
		return list;
	}
	
	public int selectTodayCount() {
		
		int count = 0;
		
		SqlSession sqlSession = factory.openSession();

		count = sqlSession.selectOne("product.today_count");

		sqlSession.close();
		
		return count;
		
	}
	
	
	
	// ��ǰ��� �޼���
	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("product.product_insert",vo);
		
		
		sqlSession.close();
		
		return res;
	}
	
	//��ǰ 1�� ��ȸ �޼���
	public ProductVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		
		ProductVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_selectOne", p_idx);
		
		//connection �ݱ�
		sqlSession.close();
		
		return vo;
	}

	
	//��ǰ�˻�
	public List<ProductVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<ProductVo> list = null;

		// 1. sqlSession ������
		SqlSession sqlSession = factory.openSession();

		// 2 ����
		list = sqlSession.selectList("product.product_list_search",map);

		// 3. �ݱ�
		sqlSession.close();

		return list;
	}



	
	
	
}
