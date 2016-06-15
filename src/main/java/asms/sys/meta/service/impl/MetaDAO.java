package asms.sys.meta.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.plc.service.PlaceVO;
import asms.sys.meta.service.MetaVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("MetaDAO")
public class MetaDAO extends EgovAbstractDAO{
	List metaListSearch(MetaVO vo) throws Exception {
		return list("metaListSearch", vo);
    }

	int metaListTotCntSearch(MetaVO vo) throws Exception {
		return (Integer) selectByPk("metaListTotCntSearch", vo);
	}

	MetaVO metaInfoSearch(MetaVO vo) throws Exception {
		return (MetaVO) selectByPk("metaInfoSearch", vo);
	}
	
	int metaAdd(MetaVO vo) throws Exception {

		int result = 0;
		
		result = update("metaAdd", vo);  
			
		return result;
		
	}
	
}
