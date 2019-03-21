<div class="pagination">

    <%
        int pageCurrent = (int) request.getAttribute("pageCurrent");
        int pageTotal = (int) request.getAttribute("pageTotal");
    %>


        <a href="?page=1"><i class="material-icons">first_page</i></a>
        <a href="?page=<%=(pageCurrent - 1 <= 0) ? 1 : pageCurrent - 1%>"><i class="material-icons">chevron_left</i></a>
            <%
            int start = (pageCurrent - 2 <= 0) ? 1 : pageCurrent - 2;
            int end = (pageCurrent + 4 > pageTotal) ? pageTotal : pageCurrent + 4;
            for(int i = start; i <= end; i++) {
                String active = "";
                if(i == pageCurrent){
                    active = "class=\"active\"";
                }
            %>
                <a href = "?page=<%=i%>" <%=active%> > <%=i%> </a >
            <%}%>
            <a href = "?page=<%=(pageCurrent + 1 > pageTotal) ? pageTotal : pageCurrent + 1%>" ><i class="material-icons" > chevron_right </i></a>
            <a href = "?page=<%=pageTotal%>" ><i class="material-icons" > last_page </i></a>
</div>