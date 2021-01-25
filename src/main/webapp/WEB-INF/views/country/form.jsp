<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Decolar - New Country</title>
</head>
<body>
    <main class="main--page-container">
        <form action="/country" method="post" class="form form--new-country">
            <div class="form--field-container">
                <label for="name" class="form--field-label">Country name:</label>
                <input type="text" id="name" name="name" placeholder="Brazil" class="form--field-input">
            </div>

            <button class="form--button" type="submit">Save</button>
        </form>
    </main>

</body>
</html>
