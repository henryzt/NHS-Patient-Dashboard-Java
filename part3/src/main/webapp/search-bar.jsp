<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 2019-03-13
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<div class="main">
    <div class="mdl-shadow--2dp  content"  style="margin-top:0; margin-bottom: 50px; padding: 0 ">
        <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
            <div class="mdl-tabs__tab-bar" >
                <a href="#basic-search" class="mdl-tabs__tab is-active">Basic Search</a>
                <a href="#advanced-search"class="mdl-tabs__tab">Advanced Search</a>
            </div>

            <%--Basic search tab--%>
            <div class="mdl-tabs__panel is-active" id="basic-search" style="padding:30px;">
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
            <div class="mdl-tabs__panel" id="advanced-search" style="padding:30px;">
                <form method="POST" action="/search.html">
                    <table style="width: 100%">
                        <tr>
                            <td><b>Age Range</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 30%;">
                                    <input class="mdl-textfield__input" maxlength="3" type="text" pattern="-?[0-9]*(\.[0-9]+)?"  id="min" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">Minimum</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 30%;">
                                    <input class="mdl-textfield__input" maxlength="3" type="text" pattern="-?[0-9]*(\.[0-9]+)?"  id="max" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">Maximum</label>
                                </div>
                            </td>
                        </tr>


                        <tr>
                            <td><b>Gender</b></td>
                            <td>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="any">
                                    <input checked class="mdl-radio__button" id="any" name="gender" type="radio"
                                           value="on">
                                    <span class="mdl-radio__label">Any</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="male">
                                    <input class="mdl-radio__button" id="male" name="gender" type="radio" value="off">
                                    <span class="mdl-radio__label">Male</span>
                                </label>
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="female">
                                    <input class="mdl-radio__button" id="female" name="gender" type="radio" value="off">
                                    <span class="mdl-radio__label">Female</span>
                                </label>
                            </td>
                        </tr>


                        <tr>
                            <td><b>City</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 40%;">
                                    <input class="mdl-textfield__input" type="text" id="city" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">City</label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td><b>Name</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 60%;">
                                    <input class="mdl-textfield__input" type="text" id="field" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">Name and any other fields</label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td><b>Initial</b></td>
                            <td style="width: 70%;">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 40%;">
                                    <input class="mdl-textfield__input" maxlength="1" type="text" id="initial" name="search_string"/>
                                    <label class="mdl-textfield__label" for="search">Name start with</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                    </table>

                    <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                           type="submit" value="Search" style="width: 40%;margin-bottom: 20px"/>
                </form>
            </div>


    </div>
</div>