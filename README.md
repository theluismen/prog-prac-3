# Tercera Práctica de Programación
## Progreso
- [x] - Opcio 1
- [x] - Opcio 2
- [x] - Opcio 3
- [x] - Opcio 4
- [x] - Opcio 5
- [x] - Opcio 6
- [x] - Opcio 7
- [x] - Opcio 8
- [x] - Opcio 9
- [x] - Opcio 10
- [x] - Opcio 11
- [x] - Opcio 12
- [x] - Opcio 13
- [x] - Opcio 14
- [x] - Opcio 15

## Compilacion y ejecución
Para compilar el proyecto disponemos un `Makefile`. Este compilará todos los archvivos `.java` de uno en uno.
El destino de los archivos que contienen clases sera `./bin/{su paquete correspondiente}`.
Los archivos que contienen una funcion main (`Usa{clase que validi}.class`) se crean directamente en el directorio `./bin/`.

Para compilar todo ejecutamos:
```
make all
```
Para ejecutar el validador de una clase en concreto ejecutamos una de las siguentes ordenes definidas en el `Makefile`:
```
make UsaEntitat
make UsaLlistaEntitats
make UsaUsuari
make UsaLlistaUsuaris
make UsaReserva
make UsaLlistaReserves
make UsaActivitat
```
Una vez compilado el proyecto, para ejecutar la version de la aplicación en consola se dispone de:
```
make app
```
En cambio, para ejecutar la versión gráfica debemos usar el programa IDE Intellij de Jetbrains.
## Participantes
- **Equipo de dirección**

| Nombre | Rol |
| --- | --- |
| Jordi López Riba | Director del proyecto |

- **Equipo de programación**

| Nombre | Rol |
| --- | --- |
| Luis Manuel Ocampo Avila | Director del equipo |
| Albert Coca Rodríguez | Programador promedio xd |
| Pau Valls Tarrats | Programador promedio xd |
| Dídac March Repullés | Programador promedio xd |
