package dao.chat;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.chat.ChatVo;

public class ChatDao {
	
	SqlSessionFactory factory;
	
	static ChatDao single = null;

	public static ChatDao getinstance() {

		// ��ü�� null�̸� �����ض�
		if (single == null)
			single = new ChatDao();

		return single;
	}

	// �ܺο��� �������� �� ��
	private ChatDao() {
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	public List<ChatVo> SelectRecentList(){
		
		List<ChatVo> list = null;

		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("chat.recent_chat");

		sqlSession.close();
		
		return list;
	}
	
	
}
