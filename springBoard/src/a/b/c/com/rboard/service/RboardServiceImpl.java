package a.b.c.com.rboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.rboard.controller.RboardController;
import a.b.c.com.rboard.dao.RboardDAO;
import a.b.c.com.rboard.vo.RboardVO;

@Service
@Transactional
public class RboardServiceImpl implements RboardService {
	Logger logger = Logger.getLogger(RboardController.class);
	
	@Autowired(required=false)
	private RboardDAO rboardDAO;

	@Override
	public List<RboardVO> rboardSelect(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return rboardDAO.rboardSelect(rbvo);
	}

	@Override
	public List<RboardVO> rboardSelectAll(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return rboardDAO.rboardSelectAll(rbvo);
	}

	@Override
	public int rboardInsert(RboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("RBoardServiceImpl rboardInsert >>> : ");
		
		return rboardDAO.rboardInsert(rbvo);
	}

	@Override
	public int rboardDelete(RboardVO rbvo) {
		// TODO Auto-generated method stub
		return rboardDAO.rboardDelete(rbvo);
	}

}
