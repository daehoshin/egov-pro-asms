package asms.common.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/**
 * @PackageName asms.common.file.web
 * @FileName FileDown.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 20.
 */

public class FileDown extends AbstractView {
	public void DownloadFileView() {        
		setContentType("applicaiton/download;charset=utf-8");    
	}     
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response
			)
			throws Exception {

		String fileFullPath = (String) model.get("fileFullPath");     
		String fileOrignName = (String) model.get("fileOrignName");   
		File file = new File(fileFullPath);
		
		response.setContentType(getContentType());        
		response.setContentLength((int)file.length());
		String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;
        String downloadFile = null;
        
		
        downloadFile = new String(fileOrignName.getBytes("euc-kr"), "8859_1");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+downloadFile+"\";");        
		response.setHeader("Content-Transfer-Encoding", "binary");                 
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;                 
		try {            
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {            
			e.printStackTrace();        
		} finally {            
			if (fis != null) { 
				try { fis.close(); 
			} catch (Exception e2) {
			}
		}        
		out.flush();    
		}
	}
}
