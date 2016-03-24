package asms.common.code.service.impl;

import java.util.List;

import asms.common.code.service.CommonCodeVO;
import asms.common.code.service.impl.CommonCodeDAO;
import asms.common.code.service.CommonCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonCodeServiceImpl implements CommonCodeService {

	@Autowired
	private CommonCodeDAO commonCodeDAO;
	
	@Override
	public List findComCdList(CommonCodeVO comCdVO) throws Exception {
		return commonCodeDAO.findComCdList(comCdVO);
	}
	
	@Override
	public List findOtherCdList(CommonCodeVO comCdVO) throws Exception {
		return commonCodeDAO.findOtherCdList(comCdVO);
	}
	
}
