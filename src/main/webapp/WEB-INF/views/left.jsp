<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- Left Start -->
		<form name="menuLoadForm" method="post">
			<input type="hidden" name="menu_id">
			<input type="hidden" name="menu_div_cd">
		</form>
		<nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav metismenu" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="/bootstrap-theme/img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="profile.html">Profile</a></li>
                                <li><a href="contacts.html">Contacts</a></li>
                                <li><a href="mailbox.html">Mailbox</a></li>
                                <li class="divider"></li>
                                <li><a href="login.html">Logout</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            IN+
                        </div>
                    </li>
                    <c:forEach var="result1" items="${menuList1 }">
	                    <li>
	                        <a href="#"><i class="${result1.menu_icon }"></i> <span class="nav-label">${result1.menu_nm }</span> <span class="fa arrow"></span></a>
	                        <c:if test="${result1.sub_cnt > 0 }">
		                        <ul class="nav nav-second-level">
		                            <c:forEach var="result2" items="${menuList2 }">
			                            <c:if test="${result1.menu_id == result2.menu_upper_id }">
			                            	<li><a href="javascript:;" onclick="jsMenuLoad('${result2.menu_id }','${result2.menu_div_cd }')"><i class="${result2.menu_icon }"></i>${result2.menu_nm }</a></li>
			                            </c:if>
		                            </c:forEach>
		                        </ul>
	                        </c:if>
	                    </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
		<!-- Left End -->