<?php

include_once 'conexion.php';
$carne = $_GET['carne_alumno'];

$busqueda = "select * from estudiantes where carne_alumno = '{$carne}'";

$resultado_busqueda = mysqli_query($conexion, $busqueda);
$json = array();
$contar=0;

while ($datos = mysqli_fetch_array($resultado_busqueda)){
   $json[]=$datos;
   $contar = $contar+1;
}  
if($contar==0){
    $datos['carne_alumno']=0;
    $datos['nombre']="Datos no encontrados";
    $datos['apellido']="Datos no encontrados";
    $datos['direccion']="Datos no encontrados";
    $datos['telefono']=0;
    $datos['email']="Datos no encontrados";

    $json[]=$datos;
}
mysqli_close($conexion);
echo json_encode($json);

?>