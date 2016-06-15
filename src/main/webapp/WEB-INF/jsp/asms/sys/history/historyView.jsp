<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="historyViewForm" name="historyViewForm" class="form-horizontal" method="post">
<input type="hidden" name="pageIndex" value="1">
<input type="hidden" name="orderColumn" value="">
<input type="hidden" name="orderType" value="">
    <div class="row">
    	<div class="ibox float-e-margins">
    		<div class="ibox-title">
	    		<div class="row">
	    			<div class="col-xs-12">
		            	<h5>감사이력 상세</h5>
		            	<div class="pull-right">
		    				<a href="javascript:;" onclick="jsHistoryModForm('${historyVO.history_id }')" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 수정</a>
				        	<a href="javascript:;" onclick="jsCloseView()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 닫기</a>	    			
	    				</div>
	    			</div>
	    		</div>
    		</div>
            <div class="ibox-content">
               <div class="form-group"><label class="col-sm-3 control-label">감사이력코드</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.history_cd }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">감사이력명</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.history_nm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">시작일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.start_dt }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">종료일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.endt_dt }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">사용여부</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.use_flag_cm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.reg_nm }</span>
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록일자</label>
                   <div class="col-sm-9"><span class="help-block m-b-none">${historyVO.reg_dt }</span>
                   </div>
               </div>
            </div>
        </div>
    </div>
</form>
