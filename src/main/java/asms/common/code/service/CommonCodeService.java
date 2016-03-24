package asms.common.code.service;

import java.util.List;

import asms.common.code.service.CommonCodeVO;

public interface CommonCodeService {
	
	List findComCdList(CommonCodeVO comCdVO) throws Exception;
	
	List findOtherCdList(CommonCodeVO comCdVO) throws Exception;
	
}
