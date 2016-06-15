package asms.sys.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.plc.service.PlaceVO;
import asms.sys.code.service.CodeVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("CodeDAO")
public class CodeDAO extends EgovAbstractDAO{
	List codeListSearch(CodeVO vo) throws Exception {
		return list("codeListSearch", vo);
    }

	int codeListTotCntSearch(CodeVO vo) throws Exception {
		return (Integer) selectByPk("codeListTotCntSearch", vo);
	}

	CodeVO codeInfoSearch(CodeVO vo) throws Exception {
		return (CodeVO) selectByPk("codeInfoSearch", vo);
	}
	
	int codeAdd(CodeVO vo) throws Exception {

		int result = 0;
		
		result = update("codeAdd", vo);  
			
		return result;
		
	}
	
}
