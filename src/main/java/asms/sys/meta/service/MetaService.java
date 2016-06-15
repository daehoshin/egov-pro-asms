package asms.sys.meta.service;

import java.util.List;

import asms.reg.plc.service.PlaceVO;

public interface MetaService {
	List metaListSearch(MetaVO vo) throws Exception;
	int metaListTotCntSearch(MetaVO vo) throws Exception;
	MetaVO metaInfoSearch(MetaVO vo) throws Exception;
	int metaAddAction(MetaVO vo) throws Exception;
}
