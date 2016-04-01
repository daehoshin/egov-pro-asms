package asms.common.code.web;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import asms.common.code.service.CommonCodeService;
import asms.common.code.service.CommonCodeVO;

public class CommonCodeNameTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 4126918815338257441L;

	private CommonCodeService commonCodeService;

	private String codeType;				// 공통 코드 타입
	
	/* 코드ID */
	private String code;

	@Override
	protected int doStartTagInternal() throws Exception {

		if (commonCodeService == null) {
			// WebApplicationContext 를 얻는다.
			WebApplicationContext ctx = getRequestContext()
					.getWebApplicationContext();
			commonCodeService = ctx.getBean(CommonCodeService.class);
		}
		
		try {
			
			String html = makeCodeNameTag();
			this.pageContext.getOut().println(html);

		} catch (Exception ex) {
			throw new JspException(ex);
		}

		return SKIP_BODY;
	}

	private String makeCodeNameTag() throws Exception {
		
		StringBuffer html = new StringBuffer();
		
		if (StringUtils.isNotEmpty(getCode())) {
			
			//코드 목록 조회
			CommonCodeVO comCd = new CommonCodeVO();
			comCd.setType(getCodeType());
			List<CommonCodeVO> codeList = commonCodeService.findComCdList(comCd);
			
			if (codeList != null) {
				
				int count = 0;
				
				//화면에서 넘어온 코드에 해당하는 코드명을 조회
				String[] codeArray = getCode().split(",");
				for (String code : codeArray) {
					for (CommonCodeVO codeVO : codeList) {
						if (codeVO.getCode().equals(code)) {
							if (count > 0) {
								html.append(", ");
							}
							
							html.append(codeVO.getName());
							
							count++;
						}
					}
				}
			} else {
				throw new RuntimeException("코드 데이터가 없습니다. codeType[" + getCodeType() + "]");
			}
		}
		
		return html.toString();
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
