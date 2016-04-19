package asms.sign.export.service;

import java.util.List;


/**
 * @PackageName asms.sign.export.web
 * @FileName ExportService.java
 * @Author Jinho Jung
 * @Since 2016. 4. 09.
 */
public interface ExportService {
	int exportAddAction(ExportVO vo) throws Exception;
	List exportListSearch(ExportSearchVO vo) throws Exception;
	int exportListTotCntSearch(ExportSearchVO vo) throws Exception;
	ExportVO exportInfoSearch(ExportVO vo) throws Exception;
	List exportEquipmentListSearch(ExportEquipmentVO vo) throws Exception;
	int exportEquipmentListTotCntSearch(ExportEquipmentVO vo) throws Exception;
}
