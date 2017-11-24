<?php
// php code here
$con=mysqli_connect("localhost","root","abhiram99","bluBrary_data");
$query="UPDATE Book set userId = '$_POST[uid]' WHERE id='$_POST[id]'";
mysqli_query($con, $query);
mysqli_close($con);
?>