package a.b.c.com.rboard.dao;

import java.util.List;

import a.b.c.com.rboard.vo.RboardVO;

public interface RboardDAO {
	
	public List<RboardVO> rboardSelect(RboardVO rbvo);
	public List<RboardVO> rboardSelectAll(RboardVO rbvo);
	public int rboardInsert(RboardVO rbvo);
	//public int rboardUpdate(RboardVO rbvo);
	public int rboardDelete(RboardVO rbvo);

}
