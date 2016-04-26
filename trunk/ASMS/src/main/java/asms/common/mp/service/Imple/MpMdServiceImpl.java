package asms.common.mp.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.mp.service.MpMdService;
import asms.common.mp.service.MpMdVO;

/**
 * @PackageName asms.common.mp.service.Imple
 * @FileName MpMdServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Service("MpMdService")
public class MpMdServiceImpl implements MpMdService{

	@Resource(name="MpMdDAO")
	private MpMdDAO mpMdDAO;
	
	@Override
	public List mpMdListSearch(MpMdVO vo) throws Exception {
		return mpMdDAO.mpMdListSearch(vo);
	}

	@Override
	public int mpMdListTotCntSearch(MpMdVO vo) throws Exception {
		return mpMdDAO.mpMdListTotCntSearch(vo);
	}
}
