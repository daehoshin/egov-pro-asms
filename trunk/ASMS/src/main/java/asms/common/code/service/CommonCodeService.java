package asms.common.code.service;

import java.util.List;

import asms.common.code.service.CommonCodeVO;

/**
 * @PackageName asms.common.code.service
 * @FileName CommonCodeService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 24.
 */
public interface CommonCodeService {
	
	List findComCdList(CommonCodeVO comCdVO) throws Exception;
	
	List findOtherCdList(CommonCodeVO comCdVO) throws Exception;
	
}
