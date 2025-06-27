/*	REALIZADO CON	*/

- Java17
- Proyecto Maven
- Base de Datos SQLServer 2022 version 20.2
- Spring Tools Suite 4.29.1
- Lombok v1.18.24
- Postman


/*	URL GIT */

https://github.com/WolverineDev/productos_inventarios



/*	INSTALACION	*/

/*	Instalación Base de Datos	*/

- Se debe ejecutar el archivo "prod_invt_bd.sql" en SQLServer Management Studio 20.2.
el archivo se ubica en productos_inventarios\empresaarticulos\sql


/*	Instalación en I.D.E.	*/

- Se debe importar el proyecto como maven.
- Debe instalarse el Lombok v1.18.24.
- En la pestaña del menu, seleccionar "Windows", seleccionar "Preferences".
- Verificar que la opción "General/Workspace" el "text file enconding" este marcado other y seleccionado UTF-8.
- En la opción "Java/Installed JREs" se dede instalar el jdk-17.



/*	CREDENCIALES DE AUTENTICACION	*/

Las credenciales usadas en Autenticacion Basica son:

admin:123456
YWRtaW46MTIzNDU2

En postman se usa: 
Authorization "Basic YWRtaW46MTIzNDU2"



/*	ENDPOINTS	*/

/* Endpoint Get Consultar Producto */
http://localhost:8084/producto/{idProducto}


/* Endpoint Post Crear/Actualizar Producto */
http://localhost:8084/producto/almacenar


/* Endpoint Get Eliminar Producto */
http://localhost:8084/producto/eliminar/{idProducto}


/* Endpoint Get Listar Productos */
http://localhost:8084/producto/listaProductos


/* Endpoint Post Actualizar Inventario */
http://localhost:8084/inventario/almacenar


/* Endpoint Get Consultar Inventario por Producto */
http://localhost:8084/inventario/{idProducto}





/*	ESTRUCTURAS JSON	*/

/* JSON Producto*/
{
    "id":"",
    "nombre":"",
    "precio":""
}


/* JSON Inventario*/
{
    "id": "",
    "producto": {
        "id": "",
        "nombre": "",
        "precio": ""
    },
    "cantidad": 
}