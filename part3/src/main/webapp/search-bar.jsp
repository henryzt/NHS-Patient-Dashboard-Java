<%
    //if search bar is included from search page, and no search result is displayed (by get request), activate advanced search by default
    boolean activeAdvancedSearch = request.getRequestURI().equals("/search.jsp") && (boolean)request.getAttribute("get");
%>
<div class="main">
    <div class="mdl-shadow--2dp  content"  style="margin-top:0; margin-bottom: 50px; padding: 0 ">
        <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
            <div class="mdl-tabs__tab-bar" >
                <a href="#basic-search" class="mdl-tabs__tab <%=activeAdvancedSearch ? "" : "is-active" %>">Basic Search</a>
                <a href="#advanced-search" class="mdl-tabs__tab <%=activeAdvancedSearch ? "is-active" : "" %>">Advanced Search</a>
            </div>

            <%--Basic search tab--%>
            <div class="mdl-tabs__panel <%=activeAdvancedSearch ? "" : "is-active" %>" id="basic-search" style="padding:30px;">
                <form method="POST" action="/search.html">
                    <div>
                        <div class="mdl-textfield mdl-js-textfield">
                            <input class="mdl-textfield__input" type="text" id="search" name="search_string"/>
                            <label class="mdl-textfield__label" for="search">Search for name, dates, address...</label>
                        </div>
                        <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                               type="submit" value="Search"/>
                    </div>
                </form>
            </div>

            <%--Advanced Search tab--%>
            <div class="mdl-tabs__panel <%=activeAdvancedSearch ? "is-active" : "" %>" id="advanced-search" style="padding:30px;">
                <form method="POST" action="/advanced-search.html">
                    <table style="width: 100%">
                        <tr>
                            <td><b>Age Range</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 30%;">
                                    <input class="mdl-textfield__input" maxlength="3" type="text" pattern="-?[0-9]*(\.[0-9]+)?"  id="min" name="min"/>
                                    <label class="mdl-textfield__label" for="search">Minimum</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 30%;">
                                    <input class="mdl-textfield__input" maxlength="3" type="text" pattern="-?[0-9]*(\.[0-9]+)?"  id="max" name="max"/>
                                    <label class="mdl-textfield__label" for="search">Maximum</label>
                                </div>
                            </td>
                        </tr>


                        <tr>
                            <td><b>Gender</b></td>
                            <td>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="any">
                                    <input checked class="mdl-radio__button" id="any" name="gender" type="radio"
                                           value="any">
                                    <span class="mdl-radio__label">Any</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="male">
                                    <input class="mdl-radio__button" id="male" name="gender" type="radio" value="male">
                                    <span class="mdl-radio__label">Male</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="female">
                                    <input class="mdl-radio__button" id="female" name="gender" type="radio" value="female">
                                    <span class="mdl-radio__label">Female</span>
                                </label>
                            </td>
                        </tr>


                        <tr>
                            <td><b>City</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 40%;">
                                    <input class="mdl-textfield__input" type="text" id="city" name="city"/>
                                    <label class="mdl-textfield__label" for="search">City</label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td><b>Initials</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 40%;">
                                    <input class="mdl-textfield__input" maxlength="1" type="text" id="first" name="first"/>
                                    <label class="mdl-textfield__label" for="search">First name start with</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 40%;">
                                    <input class="mdl-textfield__input" maxlength="1" type="text" id="last" name="last"/>
                                    <label class="mdl-textfield__label" for="search">Last name start with</label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td><b>Query</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 60%;">
                                    <input class="mdl-textfield__input" type="text" id="field" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">Name or any other fields</label>
                                </div>
                            </td>
                        </tr>


                    </table>

                    <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                           type="submit" value="Search" style="width: 40%;margin-bottom: 20px"/>
                </form>
            </div>


    </div>
</div>