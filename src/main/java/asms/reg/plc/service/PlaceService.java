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
	PlaceVO placeInfoSearch(PlaceVO vo) throws Exception;
	int placeModAction(PlaceVO vo) throws Exception;
	int placeRegFinishAction(PlaceVO vo) throws Exception;
	PlaceVO placeBaseInfoSearch(PlaceVO vo) throws Exception;
	int PlaceDelAction(PlaceVO vo) throws Exception;
}
