
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教学课件</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">

</head>
<body style="margin-left: 20px">
  <h3 style="margin-top: 10px">教学课件</h3>

  <c:forEach  items="${page.list}" var="r">

      <div class="ui divided items">
          <div class="item" style="height: 70px" >
              <div class="image" style="height: 75px!important;width: 75px">
                  <img style="height: 75px!important;width: 75px" src="${pageContext.request.contextPath}/assets1/Images/rar.jpg">
              </div>
              <div class="content" style="margin-left: 40px">
                  <a class="header">${r.rarName}</a>
                  <div class="meta">
                      <span class="cinema">更新于${r.uploadTime}</span>
                  </div>
                  <div class="description">
<%--                      <p>${v.vedioPro}</p>--%>
                  </div>
                  <div class="extra">
                      <div href="" class="ui right floated primary button" onclick="down(${r.id})">下载 <i class="right download icon"></i> </div>
                      <div class="ui label">RAR</div>
                      <div class="ui label"><i class="users icon"></i> ${r.downNum} 人下载</div>
                  </div>
              </div>
          </div>

          <div class="item" style="margin-top: 20px">
              <div class="content">
              </div>
          </div>
      </div>
  </c:forEach>




  <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>

<script>
    function down(rid) {
        location.href="${pageContext.request.contextPath}/rar/rarUpdown.do?id="+rid;
    }
</script>
</body>
</html>
