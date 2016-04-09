package asms.reg.mp.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.mp.service.ManPowerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.reg.mp.service.impl
 * @FileName ManPowerDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Repository("ManPowerDAO")
public class ManPowerDAO extends EgovAbstractDAO{

	List manPowerListSearch(ManPowerVO vo) throws Exception {
		return list("manPowerListSearch", vo);
    }

	int manPowerListTotCntSearch(ManPowerVO vo) throws Exception {
		return (Integer) selectByPk("manPowerListTotCntSearch", vo);
	}

	ManPowerVO manPowerInfoSearch(ManPowerVO vo) throws Exception {
		return (ManPowerVO) selectByPk("manPowerInfoSearch", vo);
	}
	
	int manPowerUseStartStopAction(ManPowerVO vo) throws Exception {
		
		int result = 0;
			
		result = update("manPowerUseStartStopAction", vo);  
			
		return result;
		
	}
	
	int ManPowerSelectUseStartAction(ManPowerVO vo) throws Exception {
		return update("manPowerSelectUseStartAction", vo);
	}

	int ManPowerSelectUseStopAction(ManPowerVO vo) throws Exception {
		return update("manPowerSelectUseStopAction", vo);
	}
	
}
