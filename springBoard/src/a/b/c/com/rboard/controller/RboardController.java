package a.b.c.com.rboard.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.service.ChabunService;
import a.b.c.com.rboard.service.RboardService;
import a.b.c.com.rboard.vo.RboardVO;

@Controller
public class RboardController {
	Logger logger = Logger.getLogger(RboardController.class);
	
	@Autowired(required=false)		
	private RboardService rboardService;
	
	@Autowired(required=false)
	private ChabunService chabunService;
	
	@RequestMapping(value="rboardForm", method=RequestMethod.GET)
	public String rboardForm() {
		return "rboard/rboardForm";
	}
	
	// 댓글 등록
	@RequestMapping( value="rboardInsert", method=RequestMethod.POST)
	@ResponseBody
	public String rboardInsert(RboardVO rbvo) {	
		logger.info("RBoardController rboardInsert >>> : ");
		logger.info("RBoardController rboardInsert rbvo.getSbnum() >>> : " + rbvo.getSbnum());
		logger.info("RBoardController rboardInsert rbvo.getRsbcontent() >>> : " + rbvo.getRsbcontent());
			
		
		String rsbnum = ChabunUtil.getRboardChabun("N", chabunService.getRboardChabun().getRsbnum());
		logger.info("RBoardController rboardInsert rsbnum >>> : " + rsbnum);
		
		rbvo.setRsbnum(rsbnum);
		rbvo.setSbnum("B0001");
		rbvo.setRsbpw("1111");
		int nCnt = rboardService.rboardInsert(rbvo);
		logger.info("RboardController rboardInsert nCnt >>> : " + nCnt);
		
		if (1 == nCnt) { return "GOOD"; }
		else { return "BAD"; }
	}
	
	// 댓글 조회	
	@RequestMapping( value="rboardSelectAll", method=RequestMethod.POST)
	@ResponseBody
	public String rboardSelectAll(RboardVO rbvo) {	
		logger.info("RBoardController rboardSelectAll >>> : ");
		logger.info("RBoardController rboardSelectAll rbvo.getSbnum() >>> : " + rbvo.getSbnum());
		rbvo.setSbnum("B0001");
		List<RboardVO> list  = rboardService.rboardSelectAll(rbvo);
		logger.info("RboardController rboardSelectAll _rbvo >>> : " + list);
		
		String ss = "";
		String listStr = "";
		for (int i=0; i < list.size(); i++) {
			RboardVO _rbvo = list.get(i);
			String s0 = _rbvo.getRsbnum();
			String s1 = _rbvo.getRsbname();
			String s2 = _rbvo.getRsbcontent();
			String s3 = _rbvo.getRsbinsertdate();
			ss = s0+","+s1+","+s2+","+s3;
			listStr += ss+"&";
		}
		return listStr;
	}
	
	// 댓글 조회	
	@RequestMapping( value="rboardDelete", method=RequestMethod.POST)
	@ResponseBody
	public String rboardDelete(RboardVO rbvo) {	
		logger.info("RBoardController rboardDelete >>> : ");
		logger.info("RBoardController rboardDelete rbvo.getRsbnum() >>> : " + rbvo.getRsbnum());
	
		int nCnt  = rboardService.rboardDelete(rbvo);
		logger.info("RboardController rboardDelete nCnt >>> : " + nCnt);
		
		if (1 == nCnt) { return "GOOD"; }
		else { return "BAD"; }
	}

}
