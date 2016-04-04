package asms.reg.plc.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.login.service.LoginUserVO;
import asms.reg.plc.service.PlaceVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.reg.plc.service.impl
 * @FileName PlaceDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Repository("PlaceDAO")
public class PlaceDAO extends EgovAbstractDAO{
	
	List placeListSearch(PlaceVO vo) throws Exception {
		return list("placeListSearch", vo);
    }

	int placeListTotCntSearch(PlaceVO vo) throws Exception {
		return (Integer) selectByPk("placeListTotCntSearch", vo);
	}

	int placeMainAdd(PlaceVO vo) throws Exception {
		
		int result = 0;

		result = update("placeMainAdd", vo);  
			
		return result;
	}
	
	int placeDetailAdd(PlaceVO vo) throws Exception {

		int result = 0;
		
		result = update("placeDetailAdd", vo);  
			
		return result;
		
	}
	
	PlaceVO placeInfoSearch(PlaceVO vo) throws Exception {
		return (PlaceVO) selectByPk("placeInfoSearch", vo);
	}
	
	int placeMainMod(PlaceVO vo) throws Exception {
		
		int result = 0;
			
		result = update("placeMainMod", vo);  
		
		return result;
	}
	
	int placeDetailMod(PlaceVO vo) throws Exception {

		int result = 0;
		
		result = update("placeDetailMod", vo);  
		
		return result;
		
	}
	
	int placeRegFinishAction(PlaceVO vo) throws Exception {
		
		int result = 0;
			
		result = update("placeRegFinishAction", vo);  
			
		return result;
		
	}
	
	PlaceVO placeBaseInfoSearch(PlaceVO vo) throws Exception {
		return (PlaceVO) selectByPk("placeBaseInfoSearch", vo);
	}

	int PlaceDelAction(PlaceVO vo) throws Exception {
		return update("PlaceDelAction", vo);
	}

	int PlaceSelectDelAction(PlaceVO vo) throws Exception {
		return update("PlaceSelectDelAction", vo);
	}

}
