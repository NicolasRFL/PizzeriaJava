# PizzeriaJava
Programa que permite crear un ticket de cobro de un servicio de alimentos (pizza) a un cliente según las opciones elegidas.

## Elementos necesarios para ejecutar el proyecto.
Para crear el proyecto usé:
> IDE IntelliJ IDEA  
> Java jdk 14

## Descripción del proyecto
El proyecto tiene una interfaz grafica que visualiza el modelo y permite su modificación por parte del usuario a traves de clases intermedias.

Permite crear un cliente ingresando un nombre, al cual es necesario asignarle una pizza y se le puede asignar opcionalmente toppings.

El programa luego crea un ticket, que se muestra en la pantalla y se crea un archivo de texto según el número de ticket. Por ejemplo un archivo creado podría ser:

> ticket1.txt

Si el nombre del cliente se deja en blanco, no se selecciona una pizza o un error surge al escribir un archivo el programa avisa creando un dialogo extra.

## Estructura del proyecto
Diagrama de clases:

![pizzeria](https://user-images.githubusercontent.com/19522803/110900941-4d895e00-82e2-11eb-87f0-21d616f31b28.png)

