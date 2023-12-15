# Tercera Práctica de Programación
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
