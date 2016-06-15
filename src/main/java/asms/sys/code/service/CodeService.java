package asms.sys.code.service;

import java.util.List;

import asms.reg.plc.service.PlaceVO;

public interface CodeService {
	List codeListSearch(CodeVO vo) throws Exception;
	int codeListTotCntSearch(CodeVO vo) throws Exception;
	CodeVO codeInfoSearch(CodeVO vo) throws Exception;
	int codeAddAction(CodeVO vo) throws Exception;
}
