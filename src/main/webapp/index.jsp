<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hostel Accommodation System</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="style3.css">

</head>
<body>

<div class="wrapper">
    <h1>Add New Student</h1>
    <form action="SaveServlet" method="post">

        <table class="input-box">
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
               <td>Number of Bed:</td>
               <td><input type="number" name="number_of_bed"/></td>

            </tr>

            <tr>
                <td>Room Number:</td>
                <td><input type="number" name="room_number"/></td>
            </tr>
            <tr class="select">
                <td>Ac/nonAc:</td>
                <td>
                    <select name="ac_nonAc" style="width:150px">
                    <option>AC</option>
                    <option>Non-AC</option>
                    </select>

                </td>
            </tr>


            <tr class="submit">
                <td colspan="2"><input type="submit" value="Save student"/></td>
            </tr>

        </table>

    </form>
    <div class="view">
        <br/>
        <a href="ViewServlet">view student</a>
    </div>
</div>
</body>
</html>
