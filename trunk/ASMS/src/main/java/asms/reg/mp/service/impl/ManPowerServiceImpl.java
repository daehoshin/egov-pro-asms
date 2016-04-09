package asms.reg.mp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;

/**
 * @PackageName asms.reg.mp.service.impl
 * @FileName ManPowerServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Service("ManPowerService")
public class ManPowerServiceImpl implements ManPowerService{
	
	@Resource(name="ManPowerDAO")
	private ManPowerDAO manPowerDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List manPowerListSearch(ManPowerVO vo) throws Exception {
		return manPowerDAO.manPowerListSearch(vo);
	}

	@Override
	public int manPowerListTotCntSearch(ManPowerVO vo) throws Exception {
		return manPowerDAO.manPowerListTotCntSearch(vo);
	}

	@Override
	public ManPowerVO manPowerInfoSearch(ManPowerVO vo) throws Exception{
		return manPowerDAO.manPowerInfoSearch(vo);
	}
	
	@Override
	public int ManPowerSelectUseStartAction(ManPowerVO vo) throws Exception{
		
		int result = 0;
		
		result = manPowerDAO.ManPowerSelectUseStartAction(vo);
			
		return result;
	}
	
	@Override
	public int ManPowerSelectUseStopAction(ManPowerVO vo) throws Exception{
		
		int result = 0;
		
		result = manPowerDAO.ManPowerSelectUseStopAction(vo);
		
		return result;
	}

	@Override
	public int manPowerUseStartStopAction(ManPowerVO vo) throws Exception {
		
		int result = 0;
		
		String currentDate = DateUtils.CurrentDate();
		
		vo.setSys_dt(currentDate);
		
		result = manPowerDAO.manPowerUseStartStopAction(vo);
			
		return result;
	}
	
}
