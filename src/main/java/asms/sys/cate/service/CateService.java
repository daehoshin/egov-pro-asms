package asms.sys.cate.service;

import java.util.List;

import asms.reg.plc.service.PlaceVO;

public interface CateService {
	List cateListSearch(CateVO vo) throws Exception;
	int cateListTotCntSearch(CateVO vo) throws Exception;
	CateVO cateInfoSearch(CateVO vo) throws Exception;
	int cateAddAction(CateVO vo) throws Exception;
}
