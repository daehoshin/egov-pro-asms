<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">장소 상세</h4>
        </div>
        <form id="placeAddForm" name="placeAddForm" class="form-horizontal" method="post">
	        <div class="modal-body">
	        	<div class="form-group"><label class="col-lg-2 control-label">장소명</label>
                	<div class="col-lg-10"><p class="form-control-static">email@example.com</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">주소</label>
                	<div class="col-lg-10"><p class="form-control-static">email@example.com</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">상세주소</label>
                	<div class="col-lg-10"><p class="form-control-static">email@example.com</p></div>
                </div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="regFinishBtn">등록완료</button>
            <button type="button" class="btn btn-primary" id="modBtn">수정</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
