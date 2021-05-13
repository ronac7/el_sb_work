package a.b.c.com.common;

public abstract class CommonUtils {
	
	// 이미지 업로드 	

	public static final String IMG_UPLOAD_PATH = "/Users/jins/Kosmo78/30_web/el_sb_work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springBoard/imgupload";
	//public static final String IMG_UPLOAD_PATH = "/Users/jins/Kosmo78/30_web/el_sb_work/springBoard/WebContent/imgupload";
	public static final int IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String EN_CODE = "UTF-8";
	
	// 파일 업로드 
	public static final String FILE_UPLOAD_PATH = "/Users/jins/Kosmo78/30_web/el_sb_work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springBoard/fileupload";
	public static final int FILE_FILE_SIZE = 10*1024*1024; // 10MB
	
	// 게시판 페이징 사이즈 초기화 
	public static final String B_PAGE_SIZE = "3";
	public static final String B_GROUP_SIZE = "2";
	public static final String B_CUR_PAGE = "1";
	public static final String B_TOTAL_COUNT = "";

}
