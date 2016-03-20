package asms.common.tree;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * @PackageName asms.common.tree
 * @FileName AsmsMappingJacksonJsonView.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 20.
 */
public class AsmsMappingJacksonJsonView extends MappingJacksonJsonView {
	
	@Override
	protected Object filterModel (Map<String, Object> model){
		Object result = super.filterModel(model);
		
		if(!(result instanceof Map)){
			return result;
		}
		
		Map map = (Map) result;
		if (map.size() == 1){
			return map.values().toArray()[0];
		}
		return map;
		
	}
	
}
