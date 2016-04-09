package asms.reg.mp.service;

import java.util.List;

/**
 * @PackageName asms.reg.mp.service
 * @FileName ManPowerService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
public interface ManPowerService {
	List manPowerListSearch(ManPowerVO vo) throws Exception;
	int manPowerListTotCntSearch(ManPowerVO vo) throws Exception;
	ManPowerVO manPowerInfoSearch(ManPowerVO vo) throws Exception;
	int manPowerUseStartStopAction(ManPowerVO vo) throws Exception;
	int ManPowerSelectUseStartAction(ManPowerVO vo) throws Exception;
	int ManPowerSelectUseStopAction(ManPowerVO vo) throws Exception;
}
