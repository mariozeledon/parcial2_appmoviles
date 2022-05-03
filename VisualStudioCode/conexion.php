<?php
    $host = "localhost";
    $usuario = "root";
    $contrasenia = "";
    $basededatos = "parcial2";

    $conexion = mysqli_connect($host, $usuario, $contrasenia, $basededatos);
    if (!$conexion){
        echo "Error en conexion a MySQL";
    }
?>