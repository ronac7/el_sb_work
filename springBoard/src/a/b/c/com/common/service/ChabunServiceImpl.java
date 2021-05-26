package a.b.c.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.common.dao.ChabunDAO;
import a.b.c.com.rboard.vo.RboardVO;
import a.b.c.com.board.vo.BoardVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}

	@Override
	public BoardVO getBoardChabun() {
		// TODO Auto-generated method stub
		return chabunDAO.getBoardChabun();
	}

	@Override
	public RboardVO getRboardChabun() {
		// TODO Auto-generated method stub
		return chabunDAO.getRboardChabun();
	}

}
