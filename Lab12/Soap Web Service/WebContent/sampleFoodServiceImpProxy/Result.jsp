<%@page import="com.sclab12.soap.FoodItems"%>
<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFoodServiceImpProxyid" scope="session" class="com.sclab12.soap.FoodServiceImpProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFoodServiceImpProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleFoodServiceImpProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleFoodServiceImpProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.sclab12.soap.FoodServiceImp getFoodServiceImp10mtemp = sampleFoodServiceImpProxyid.getFoodServiceImp();
if(getFoodServiceImp10mtemp == null){
%>
<%=getFoodServiceImp10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String id_1id=  request.getParameter("id26");
        int id_1idTemp  = Integer.parseInt(id_1id);
        com.sclab12.soap.FoodItems getItem15mtemp = sampleFoodServiceImpProxyid.getItem(id_1idTemp);
if(getItem15mtemp == null){
%>
<%=getItem15mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getItem15mtemp != null){
java.lang.String typename18 = getItem15mtemp.getName();
        String tempResultname18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename18));
        %>
        <%= tempResultname18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">price:</TD>
<TD>
<%
if(getItem15mtemp != null){
%>
<%=getItem15mtemp.getPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getItem15mtemp != null){
java.lang.String typedescription22 = getItem15mtemp.getDescription();
        String tempResultdescription22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription22));
        %>
        <%= tempResultdescription22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getItem15mtemp != null){
%>
<%=getItem15mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 28:
        gotMethod = true;
        com.sclab12.soap.FoodItems[] getAllItems28mtemp = sampleFoodServiceImpProxyid.getAllItems();
if(getAllItems28mtemp == null){
%>
<%=getAllItems28mtemp %>
<%
}else{
        String tempreturnp29 = null;
        if(getAllItems28mtemp != null){
        java.util.List<com.sclab12.soap.FoodItems> listreturnp29= java.util.Arrays.asList(getAllItems28mtemp);
        for(com.sclab12.soap.FoodItems food : listreturnp29){
        	int id = food.getId();
        	int price = food.getPrice();
        	String name=food.getName();
        	%>ID -
        	<%=id%>:: Name - <%=name %>:: Price - <%=price %>
        	<%
        }
        tempreturnp29 = listreturnp29.toString();
        
        }
        %>
        <%=tempreturnp29%>
        <%
}
break;
case 31:
        gotMethod = true;
        String name_3id=  request.getParameter("name36");
            java.lang.String name_3idTemp = null;
        if(!name_3id.equals("")){
         name_3idTemp  = name_3id;
        }
        String price_4id=  request.getParameter("price38");
        int price_4idTemp  = Integer.parseInt(price_4id);
        String description_5id=  request.getParameter("description40");
            java.lang.String description_5idTemp = null;
        if(!description_5id.equals("")){
         description_5idTemp  = description_5id;
        }
        String id_6id=  request.getParameter("id42");
        int id_6idTemp  = Integer.parseInt(id_6id);
        %>
        <jsp:useBean id="com1sclab121soap1FoodItems_2id" scope="session" class="com.sclab12.soap.FoodItems" />
        <%
        com1sclab121soap1FoodItems_2id.setName(name_3idTemp);
        com1sclab121soap1FoodItems_2id.setPrice(price_4idTemp);
        com1sclab121soap1FoodItems_2id.setDescription(description_5idTemp);
        com1sclab121soap1FoodItems_2id.setId(id_6idTemp);
        boolean addFoodItems31mtemp = sampleFoodServiceImpProxyid.addFoodItems(com1sclab121soap1FoodItems_2id);
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addFoodItems31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
break;
case 44:
        gotMethod = true;
        String id_7id=  request.getParameter("id47");
        int id_7idTemp  = Integer.parseInt(id_7id);
        boolean deleteFoodItems44mtemp = sampleFoodServiceImpProxyid.deleteFoodItems(id_7idTemp);
        String tempResultreturnp45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFoodItems44mtemp));
        %>
        <%= tempResultreturnp45 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>