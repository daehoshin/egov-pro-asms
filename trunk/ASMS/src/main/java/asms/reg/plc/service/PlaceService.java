package asms.reg.plc.service;

import java.util.List;

/**
 * @PackageName asms.reg.plc.service
 * @FileName PlaceService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
public interface PlaceService {
	List placeListSearch(PlaceVO vo) throws Exception;
	int placeAddAction(PlaceVO vo) throws Exception;
}
