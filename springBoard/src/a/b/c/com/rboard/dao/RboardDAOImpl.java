package a.b.c.com.rboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.rboard.vo.RboardVO;

@Repository
public class RboardDAOImpl implements RboardDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<RboardVO> rboardSelect(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rboardSelect", rbvo);
	}

	@Override
	public List<RboardVO> rboardSelectAll(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rboardSelectAll", rbvo);
	}

	@Override
	public int rboardInsert(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("rboardInsert", rbvo);
	}

	@Override
	public int rboardDelete(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("rboardDelete", rbvo);
	}

}
