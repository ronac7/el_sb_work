package a.b.c.com.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_M 	= "M"; // 회원 : MEMBER
	public static final String BIZ_GUBUN_B 	= "B"; // 게시판 : BOARD
	public static final String BIZ_GUBUN_RB = "RB"; // 게시판 댓글: REPLY BOARD
	public static final String BIZ_GUBUN_N 	= "NB"; // 공지사항 : NOTICE BOARD
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N : 
	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	// 회원 번호 
	public static String getMemChabun(String type, String memNum) {
		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
	
	// 게시판 글 번호  
	public static String getBoardChabun(String type, String memNum) {
		
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, memNum));
	}
	
	// 게시판 댓글 글 번호  
	public static String getRboardChabun(String type, String memNum) {
		
		return BIZ_GUBUN_RB.concat(ChabunUtil.numPad(type, memNum));
	}
	
	// 공지사항  번호  
	public static String getNoticeChabun(String type, String memNum) {
		
		return BIZ_GUBUN_N.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.getMemChabun("m", c));
		System.out.println(">>> : " + ChabunUtil.getBoardChabun("N", c));
		System.out.println(">>> : " + ChabunUtil.getRboardChabun("N", c));
		System.out.println(">>> : " + ChabunUtil.getNoticeChabun("N", c));
		
	}
}
