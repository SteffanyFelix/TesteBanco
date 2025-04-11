<?php
include 'conexao.php';

$sql = "SELECT * FROM usuarios";
$result = $conn->query($sql);

$usuarios = array();

while ($row = $result->fetch_assoc()) {
    $usuarios[] = $row;
}

echo json_encode($usuarios);
?>
