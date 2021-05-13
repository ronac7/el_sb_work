package a.b.c.com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.board.service.BoardService;
import a.b.c.com.board.vo.BoardVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;

@Controller
public class BoardController {
	Logger logger = Logger.getLogger(BoardController.class);
	
	private BoardService boardService;
	private ChabunService chabunService;
	
	// 생성자 Autowired
	@Autowired(required=false)	
	public BoardController( BoardService boardService
			               ,ChabunService chabunService) {
		this.boardService = boardService;
		this.chabunService = chabunService;
	}
	
	// 게시판 글 입력 폼
	@RequestMapping(value="boardForm", method=RequestMethod.GET)
	public String boardForm() {
		return "board/boardForm";
	}
	
	// 글쓰기 
	@RequestMapping(value="boardInsert", method=RequestMethod.POST)
	public String boardInsert(HttpServletRequest req) {
		logger.info("BoardController boardInsert 함수 진입 >>> :");
		
		// 채번 구하기
		String sbnum= ChabunUtil.getBoardChabun("N", chabunService.getBoardChabun().getSbnum());
		logger.info("BoardController boardInsert sbnum >>> : " + sbnum);
		
		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil();
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("BoardController boardInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기 
		BoardVO _bvo = null;
		_bvo = new BoardVO();
		
		_bvo.setSbnum(sbnum);
		_bvo.setSbsubject(fu.getParameter("sbsubject"));
		_bvo.setSbname(fu.getParameter("sbname"));
		_bvo.setSbpw(fu.getParameter("sbpw"));
		_bvo.setSbcontent(fu.getParameter("sbcontent"));
		_bvo.setSbfile(fu.getFileName("sbfile"));
		
		logger.info("BoardController boardInsert _bvo.getSbnum() >>> : " + _bvo.getSbnum());
		logger.info("BoardController boardInsert _bvo.getSbcontent() >>> : " + _bvo.getSbcontent());
		logger.info("BoardController boardInsert _bvo.getSbfile() >>> : " + _bvo.getSbfile());
		int nCnt = boardService.boardInsert(_bvo);
		logger.info("BoardController boardInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/boardInsert";}
		return "board/boardForm";
	}
	
	// 글 목록 조회
	@RequestMapping(value="boardSelectAll", method=RequestMethod.GET)
	public String boardSelectAll(BoardVO bvo, Model model) {
		logger.info("BoardController boardSelectAll 함수 진입 >>> :");	
		
		logger.info("BoardController boardSelectAll bvo.getKeyfilter() >>> : " + bvo.getKeyfilter());
		logger.info("BoardController boardSelectAll  bvo.getKeyword() >>> : " + bvo.getKeyword());
		logger.info("BoardController boardSelectAll bvo.getStartdate() >>> : " + bvo.getStartdate());
		logger.info("BoardController boardSelectAll  bvo.getEnddate() >>> : " + bvo.getEnddate());
		
		
		List<BoardVO> listAll = boardService.boardSelectAll(bvo);
		logger.info("BoardController boardSelectAll listAll.size() >>> : " + listAll.size());
		
		if (listAll.size() > 0) { 
			model.addAttribute("listAll", listAll);
			return "board/boardSelectAll";
		}
		
		return "board/boardForm";
	}
	
	// 게시글 수정/삭제 글 조회
	@RequestMapping(value="boardSelect", method=RequestMethod.POST)
	public String boardSelect(BoardVO bvo, Model model) {	
		logger.info("BoardController boardSelect 함수 진입 >>> :");		
		logger.info("BoardController boardSelect bvo.getSbnum() >>> : " + bvo.getSbnum());
		
		List<BoardVO> listS = boardService.boardSelect(bvo);
		logger.info("BoardController boardSelect listS.size() >>> : " + listS.size());
		
		if (listS.size() == 1) { 
			model.addAttribute("listS", listS);
			return "board/boardSelect";
		}		
		return "board/boardSelectAll";
	}
	
	// 글 수정하기 
	@RequestMapping(value="boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardVO bvo, Model model) {
		logger.info("BoardController boardUpdate 함수 진입 >>> :");
		
		logger.info("BoardController boardUpdate bvo.getSbnum() >>> : " + bvo.getSbnum());
		logger.info("BoardController boardUpdate bvo.getSbcontent() >>> : " + bvo.getSbcontent());
		int nCnt = boardService.boardUpdate(bvo);
		logger.info("BoardController boardUpdate nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/boardUpdate";}
		return "board/boardForm";
	}
	
	// 글 삭제하기
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	public String boardDelete(BoardVO bvo, Model model) {
		logger.info("BoardController boardDelete 함수 진입 >>> :");
		
		logger.info("BoardController boardDelete bvo.getSbnum() >>> : " + bvo.getSbnum());		
		int nCnt = boardService.boardDelete(bvo);
		logger.info("BoardController boardDelete nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/boardDelete";}
		return "board/boardForm";
	}
	
	// 비밀번호 체크하기
	@RequestMapping(value="boardIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public String boardIdCheck(BoardVO bvo) {
		logger.info("BoardController boardIdCheck 함수 진입 >>> :");
		
		logger.info("BoardController boardIdCheck bvo.getSbnum() >>> : " + bvo.getSbnum());	
		logger.info("BoardController boardIdCheck bvo.getSbpw() >>> : " + bvo.getSbpw());	
		
		List<BoardVO> list = boardService.boardIdCheck(bvo);
		logger.info("BoardController boardIdCheck _bvo.getSbpw() >>> : " + list.size());
		
		String msg = "";
		if (list.size() == 1) {msg = "PW_GOOD";}  
		else { msg = "PW_BAD";}  
		
		return msg;
	}

}
