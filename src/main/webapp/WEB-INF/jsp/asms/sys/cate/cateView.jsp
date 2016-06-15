<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="cateViewForm" name="cateViewForm" class="form-horizontal" method="post">
<input type="hidden" name="pageIndex" value="1">
<input type="hidden" name="orderColumn" value="">
<input type="hidden" name="orderType" value="">
    <div class="row">
    	<div class="ibox float-e-margins">
    		<div class="ibox-title">
	    		<div class="row">
	    			<div class="col-xs-12">
		            	<h5>카테고리 상세</h5>
		            	<div class="pull-right">
		    				<a href="javascript:;" onclick="jsCateModForm('${cateVO.cate_id }')" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 수정</a>
				        	<a href="javascript:;" onclick="jsCloseView()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 닫기</a>	    			
	    				</div>
	    			</div>
	    		</div>
    		</div>
            <div class="ibox-content">
               <div class="form-group"><label class="col-sm-3 control-label">카테고리코드</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.cate_cd }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">카테고리명</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.cate_nm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">시작일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.start_dt }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">종료일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.endt_dt }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">사용여부</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.use_flag_cm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.reg_nm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${cateVO.reg_dt }</span>
                   </div>
               </div>
            </div>
        </div>
    </div>
</form>
