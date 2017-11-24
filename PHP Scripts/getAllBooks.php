<?php
// php code here
$con=mysqli_connect("localhost","root","abhiram99","bluBrary_data");
$query="select * from Book";
$result = mysqli_query($con,$query);
while ($row = mysqli_fetch_assoc($result)) {
	$output[] = $row;
}
echo json_encode($output);
mysqli_close($con);
?>