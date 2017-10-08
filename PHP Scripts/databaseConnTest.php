<?php
// php code here
$con=mysqli_connect("localhost","root","abhiram99","bluBrary_data");
$query="select * from Book where id=0";
$result = mysqli_query($con,$query);
$row = mysqli_fetch_assoc($result);
echo json_encode($row);
mysqli_close($con);
?>
