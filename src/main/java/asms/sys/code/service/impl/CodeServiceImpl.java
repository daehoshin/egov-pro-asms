package asms.sys.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;
import asms.sys.code.service.CodeService;
import asms.sys.code.service.CodeVO;

@Service("CodeService")
public class CodeServiceImpl implements CodeService{

	@Resource(name="CodeDAO")
	private CodeDAO codeDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List codeListSearch(CodeVO vo) throws Exception {
		return codeDAO.codeListSearch(vo);
	}

	@Override
	public int codeListTotCntSearch(CodeVO vo) throws Exception {
		return codeDAO.codeListTotCntSearch(vo);
	}

	@Override
	public CodeVO codeInfoSearch(CodeVO vo) throws Exception {
		return codeDAO.codeInfoSearch(vo);
	}

	@Override
	public int codeAddAction(CodeVO vo) throws Exception {
		
		int result = 0;

		result = codeDAO.codeAdd(vo);
		
		return result;
	}
	
}
