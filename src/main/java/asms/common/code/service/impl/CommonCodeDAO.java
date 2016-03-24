package asms.common.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import asms.common.code.service.CommonCodeVO;

@Repository
public class CommonCodeDAO extends EgovAbstractDAO {

	public List findComCdList(CommonCodeVO comCdVO) throws Exception {
		return list("findComCdList", comCdVO);
    }
	
	public List findOtherCdList(CommonCodeVO comCdVO) throws Exception {
		return list(comCdVO.getOtherCd(), comCdVO);
    }
	
}
