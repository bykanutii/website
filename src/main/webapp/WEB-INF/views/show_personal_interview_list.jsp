﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set scope="request" var="mainActive" value="active" />
<jsp:include page="header.jsp"/>
<script>
    $(document).ready(function () {
        $('.fancybox').fancybox();
    });
</script>
<!-- main -->
<div id="main" class="your_interview">
    <!-- your interview -->
    <h1>
        <a href="#add_smth" class="add_interview fancybox">Добавить собеседование</a>
        Список Ваших собеседований
    </h1>

    <div class="clear"></div>

    <c:forEach var="interview" items="${interviewList}" varStatus="currN">
        <div class="listing">
            <ul>
                <!-- one item -->
                <li>
                    <div class="ins">
                        <div class="interview_date">
                            ${interview.created}
                        </div>
                        <div class="interview_company_logo">
                            <img alt="" width="60" height="42" src="${interview.company.logoURL}"/>
                        </div>
                        <div class="interview_company_name"><a href="">${interview.company.name}</a></div>
                        <div class="interview_company_city"><a href="">${interview.city.cityName}</a></div>
                        <div class="interview_company_vacancy"><a href="">${interview.position.name}</a></div>
                        <div class="interview_questions">
                            вопросов:
                            <span>${interview.questionCount}</span>
                        </div>
                    </div>
                </li>
                <!-- end one item -->
            </ul>
        </div>
        <!--  end listing -->
    </c:forEach>

    <c:set scope="page" var="linkMask" value="${pageContext.request.contextPath}/interview/my?page=" />
    <jsp:include page="paginator.jsp"/>
</div>
<!-- end main -->
<%@ include file="footer.jsp" %>