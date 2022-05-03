<?php
include_once 'conexion.php';

$carne = $_GET['carne_alumno'];
$nombre = $_GET['nombre'];
$apellido = $_GET['apellido'];
$direccion = $_GET['direccion'];
$telefono = $_GET['telefono'];
$email = $_GET['email'];

    $insertar = "insert into estudiantes (carne_alumno, nombre, apellido, direccion, telefono, email) values ('{$carne}','{$nombre}','{$apellido}','{$direccion}','{$telefono}','{$email}')";
    $ejecutar = mysqli_query($conexion, $insertar);

    $json = array();

        $datos['carne_alumno']=$carne;
        $datos['nombre']=$nombre;
        $datos['apellido']=$apellido;
        $datos['direccion']=$direccion;
        $datos['telefono']=$telefono;
        $datos['email']=$email;

        $json[]=$datos;
        echo json_encode($json);

?>