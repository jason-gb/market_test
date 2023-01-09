package dao.trade;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.trade.TradeDao;
import service.MyBatisConnector;

public class TradeDao {

	SqlSessionFactory factory;

	// single-ton : ��ü 1���� �����ؼ� ���
	static TradeDao single = null;

	public static TradeDao getinstance() {

		// ��ü�� null�̸� �����ض�
		if (single == null)
			single = new TradeDao();

		return single;
	}

	// �ܺο��� �������� �� ��
	private TradeDao() {
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//admin mainpage ���� �ŷ���
	public int selectTodayCount() {
		
		int count = 0;
		
		SqlSession sqlSession = factory.openSession();

		count = sqlSession.selectOne("trade.today_count");

		sqlSession.close();
		
		return count;
	}
}
