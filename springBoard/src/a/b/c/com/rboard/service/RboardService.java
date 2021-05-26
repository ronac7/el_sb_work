package a.b.c.com.rboard.service;

import java.util.List;

import a.b.c.com.rboard.vo.RboardVO;

public interface RboardService {
	
	public List<RboardVO> rboardSelect(RboardVO rbvo);
	public List<RboardVO> rboardSelectAll(RboardVO rbvo);
	public int rboardInsert(RboardVO rbvo);
	//public int rboardUpdate(RboardVO rbvo);
	public int rboardDelete(RboardVO rbvo);

}
