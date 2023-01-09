package dao.image;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.image.ImageVo;

public class ImageDao {

	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static ImageDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static ImageDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new ImageDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private ImageDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}

	public int insert(ImageVo vo) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		
		res = sqlSession.insert("image.image_insert",vo);
		
		
		sqlSession.close();
		
		
		return res;
	}

	public ImageVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		
		ImageVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("image.image_selectOne", p_idx);
		
		//connection �ݱ�
		sqlSession.close();
		
		return vo;
	}

	public List<ImageVo> selectList() {
		// TODO Auto-generated method stub
		List<ImageVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("image_list_p_idx");
		
		sqlSession.close();
		
		
		
		return list;
	}
	
	
	
	
}
