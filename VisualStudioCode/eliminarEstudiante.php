<?php

    include_once 'conexion.php';
    $carne = $_GET['carne_alumno'];
    $eliminar = "delete from estudiantes where carne_alumno = '{$carne}'";
    $ejecutar = mysqli_query($conexion, $eliminar);

    $json = array();

    if ($ejecutar){
        $datos['carne_alumno']=0;
        $datos['nombre']="Placa eliminado";
        $datos['apellido']=0;
        $datos['direccion']="dato eliminado";
        $datos['telefono']=0;
        $datos['email']="dato eliminado";

        $json[]=$datos;
        echo json_encode($json);
    }

?>