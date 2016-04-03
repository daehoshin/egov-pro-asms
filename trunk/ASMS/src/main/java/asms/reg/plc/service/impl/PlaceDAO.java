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
		
		try {
			
			result = update("placeMainAdd", vo);  
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	int placeDetailAdd(PlaceVO vo) throws Exception {

		int result = 0;
		
		try {
			
			result = update("placeDetailAdd", vo);  
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	PlaceVO placeInfoSearch(PlaceVO vo) throws Exception {
		return (PlaceVO) selectByPk("placeInfoSearch", vo);
	}
	
	int placeMainMod(PlaceVO vo) throws Exception {
		
		int result = 0;
		
		try {
			
			result = update("placeMainMod", vo);  
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	int placeDetailMod(PlaceVO vo) throws Exception {

		int result = 0;
		
		try {
			
			result = update("placeDetailMod", vo);  
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	int placeRegFinishAction(PlaceVO vo) throws Exception {
		
		int result = 0;
		
		try {
			
			result = update("placeRegFinishAction", vo);  
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
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
