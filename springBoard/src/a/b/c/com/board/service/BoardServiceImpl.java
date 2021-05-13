package a.b.c.com.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.dao.BoardDAO;
import a.b.c.com.board.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	Logger logger = Logger.getLogger(BoardServiceImpl.class);

	private BoardDAO boardDAO;
	
	BoardServiceImpl(){}
	@Autowired(required=false)
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	
	@Override
	public int boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub		
		return boardDAO.boardInsert(bvo);
	}


	@Override
	public List<BoardVO> boardSelectAll(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boardDAO.boardSelectAll(bvo);
	}


	@Override
	public List<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boardDAO.boardSelect(bvo);
	}


	@Override
	public int boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boardDAO.boardUpdate(bvo);
	}


	@Override
	public int boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boardDAO.boardDelete(bvo);
	}


	@Override
	public List<BoardVO> boardIdCheck(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boardDAO.boardIdCheck(bvo);
	}
}
