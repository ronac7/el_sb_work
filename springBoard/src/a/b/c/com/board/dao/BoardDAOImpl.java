package a.b.c.com.board.dao;

import java.util.List;

//import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.board.vo.BoardVO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	Logger logger = Logger.getLogger(BoardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("boardInsert", bvo);
	}

	@Override
	public List<BoardVO> boardSelectAll(BoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardSelectAll", bvo);
	}

	@Override
	public List<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardSelect", bvo);
	}

	@Override
	public int boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("boardUpdate", bvo);
	}

	@Override
	public int boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("boardDelete", bvo);
	}

	@Override
	public List<BoardVO> boardIdCheck(BoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardIdCheck", bvo);
	}
	
}
