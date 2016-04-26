package asms.common.store.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.store.service.StoreMdService;
import asms.common.store.service.StoreMdVO;


/**
 * @PackageName asms.common.store.service.Istorele
 * @FileName StoreMdServiceIstorel.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Service("StoreMdService")
public class StoreMdServiceImpl implements StoreMdService{

	@Resource(name="StoreMdDAO")
	private StoreMdDAO storeMdDAO;
	
	@Override
	public List storeMdListSearch(StoreMdVO vo) throws Exception {
		return storeMdDAO.storeMdListSearch(vo);
	}

	@Override
	public int storeMdListTotCntSearch(StoreMdVO vo) throws Exception {
		return storeMdDAO.storeMdListTotCntSearch(vo);
	}
}
