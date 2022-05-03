<?php

include_once 'conexion.php';

$carne = $_GET['carne_alumno'];
$nombre = $_GET['nombre'];
$apellido = $_GET['apellido'];
$direccion = $_GET['direccion'];
$telefono = $_GET['telefono'];
$email = $_GET['email'];

    $actualizar = "update estudiantes set nombre = '{$nombre}', apellido = '{$apellido}', direccion = '{$direccion}', telefono = '{$telefono}', email = '{$email}' where carne_alumno ='{$carne}'";
    $ejecutar = mysqli_query($conexion, $actualizar);

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