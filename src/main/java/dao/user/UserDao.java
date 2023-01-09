package dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.user.UserVo;

public class UserDao {

	SqlSessionFactory factory;
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static UserDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static UserDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new UserDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private UserDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//������ ��ü ȸ�� ��ȸ
	public List<UserVo> selectList(){
		
		List<UserVo> list = null;
		
		SqlSession sqlsession = factory.openSession();
		
		list = sqlsession.selectList("user.user_list");
		
		sqlsession.close();
		
		return list;
	}
	
	public List<UserVo> selectList(int u_idx) {

		List<UserVo>list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("product.product_user_list",u_idx);
		
		sqlSession.close();

		return list;
	}
	
	public UserVo selectOneByIdx(int u_idx){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.user_idx", u_idx);
		
		sqlsession.close();
		
		return user;
	}
	// �Ǹ��� ������ ������ ������ ���������
	public UserVo selectOneByIdxTime(int u_idx){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.user_idx_reg", u_idx);
		
		sqlsession.close();
		
		return user;
	}
	
	//ȸ�����Խ� ���̵� �ߺ� ����, �α���
	public UserVo selectOneById(String u_id){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.check_id", u_id);
		
		sqlsession.close();
		
		return user;
	}
	
	//ȸ�����Խ� �г��� �ߺ� ����
	public UserVo selectOneByNickname(String u_nickname){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.check_nickname", u_nickname);
		
		sqlsession.close();
		
		return user;
	}
	
	//ȸ�����Խ� �̸��� �ߺ� ����
	public UserVo selectOneByEmail(String email) {
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.check_email", email);
		
		sqlsession.close();
		
		return user;
	}
	//admin mainpage ���� �湮��
	public int selectTodayCount() {
		
		int count = 0;
		
		SqlSession sqlSession = factory.openSession();

		count = sqlSession.selectOne("trade.today_count");

		sqlSession.close();
		
		return count;
	}
		
	public int insert(UserVo vo) {
		
		int res = 0;
		
		SqlSession sqlsession = factory.openSession(true);

		res = sqlsession.insert("user.user_insert", vo);
		
		sqlsession.close();
		
		return res;
	}

	public int update(UserVo vo) {

		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);//auto commit
		
		res = sqlSession.update("user.user_update",vo);

		sqlSession.close();
		
		return res;
	}
	
	public int delete(String u_id) {
		
		int res = 0;
		
		SqlSession sqlsession = factory.openSession(true);
		
		res = sqlsession.delete("user.withdraw_account", u_id);
		
		sqlsession.close();
		
		return res;
		
	}
	
}
