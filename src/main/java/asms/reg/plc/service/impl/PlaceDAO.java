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
	
	public List placeListSearch(PlaceVO vo) throws Exception {
		return list("placeListSearch", vo);
    }

	public String RegPlaceAddAction(PlaceVO vo) throws Exception {
		return (String) insert("RegPlaceAddAction", vo);
	}
	
}
