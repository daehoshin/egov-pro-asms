package asms.sys.cate.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.plc.service.PlaceVO;
import asms.sys.cate.service.CateVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("CateDAO")
public class CateDAO extends EgovAbstractDAO{
	List cateListSearch(CateVO vo) throws Exception {
		return list("cateListSearch", vo);
    }

	int cateListTotCntSearch(CateVO vo) throws Exception {
		return (Integer) selectByPk("cateListTotCntSearch", vo);
	}

	CateVO cateInfoSearch(CateVO vo) throws Exception {
		return (CateVO) selectByPk("cateInfoSearch", vo);
	}
	
	int cateAdd(CateVO vo) throws Exception {

		int result = 0;
		
		result = update("cateAdd", vo);  
			
		return result;
		
	}
	
}
