<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 2019-03-13
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<div class="main">
    <div class="mdl-shadow--2dp  content"  style="margin-top:0px;margin-bottom: 50px;  padding:30px;">
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
</div>