## CONSTANTES ##
CP = ./bin
OUTPUT_DIR = .

## ARCHIVOS DE CLASES: Package Entitats ##
# Compilación archivo Entitat.class
./bin/Entitats/Entitat.class: ./src/Entitats/Entitat.java
	javac -d . $<
# Compilación archivo LlistaEntitats.class ( depende de Entitat.class )
./bin/Entitats/LlistaEntitats.class: ./src/Entitats/LlistaEntitats.java ./bin/Entitats/Entitat.class
	javac -d . $<

## ARCHIVOS DE CLASES: Package Activitats ##
# Compilación archivo Activitat.class
./bin/Activitats/Activitat.class: ./src/Activitats/Activitat.java
	javac -d . $<
# Compilación archivo Taller.class ( clase hija de Activitat.class )
./bin/Activitats/Taller.class: ./src/Activitats/Taller.java ./bin/Activitats/Activitat.class
	javac -d . $<
# Compilación archivo Visita.class ( clase hija de Activitat.class )
./bin/Activitats/Visita.class: ./src/Activitats/Visita.java ./bin/Activitats/Activitat.class
	javac -d . $<
# Compilación archivo Xerrada.class ( clase hija de Activitat.class )
./bin/Activitats/Xerrada.class: ./src/Activitats/Xerrada.java ./bin/Activitats/Activitat.class
	javac -d . $<
# Compilación archivo LlistaReserves.class ( depende de Reserva.class )
./bin/Activitats/LlistaActivitats.class: ./src/Activitats/LlistaActivitats.java ./bin/Activitats/Activitat.class
	javac -d . $<

## ARCHIVOS DE CLASES: Package Reserves ##
# Compilación archivo Reserva.class
./bin/Reserves/Reserva.class: ./src/Reserves/Reserva.java
	javac -d . $<
# Compilación archivo LlistaReserves.class ( depende de Reserva.class )
./bin/Reserves/LlistaReserves.class: ./src/Reserves/LlistaReserves.java ./bin/Reserves/Reserva.class
	javac -d . $<

## ARCHIVOS DE CLASES: Package Usuaris ##
# Compilación archivo Usuari.class
./bin/Usuaris/Usuari.class: ./src/Usuaris/Usuari.java
	javac -d . $<
# Compilación archivo LlistaUsuaris.class ( depende de Usuari.class )
./bin/Usuaris/LlistaUsuaris.class: ./src/Usuaris/LlistaUsuaris.java ./bin/Usuaris/Usuari.class
	javac -d . $<

## ARCHIVOS QUE EJECUTAN: Package Entitats ##
# Compilación archivo validador de Entitat
./bin/Aplicacio/UsaEntitat.class: ./src/Aplicacio/UsaEntitat.java ./bin/Entitats/Entitat.class
	javac -d . $<
# Compilación archivo validador de LlistaEntitats
./bin/Aplicacio/UsaLlistaEntitats.class: ./src/Aplicacio/UsaLlistaEntitats.java ./bin/Entitats/LlistaEntitats.class
	javac -d . $<

## ARCHIVOS QUE EJECUTAN: Package Activitats ##
# Compilación archivo validador de Activitat
./bin/Aplicacio/UsaActivitat.class: ./src/Aplicacio/UsaActivitat.java ./bin/Activitats/Activitat.class ./bin/Activitats/Taller.class ./bin/Activitats/Visita.class ./bin/Activitats/Xerrada.class
	javac -d . $<
# Compilación archivo validador de LlistaActivitats
./bin/Aplicacio/UsaLlistaActivitats.class: ./src/Aplicacio/UsaLlistaActivitats.java ./bin/Activitats/LlistaActivitats.class
	javac -d . $<

## ARCHIVOS QUE EJECUTAN: Package Reserves ##
# Compilación archivo validador de Reserva
./bin/Aplicacio/UsaReserva.class: ./src/Aplicacio/UsaReserva.java ./bin/Reserves/Reserva.class
	javac -d . $<
# Compilación archivo validador de LlistaReserves
./bin/Aplicacio/UsaLlistaReserves.class: ./src/Aplicacio/UsaLlistaReserves.java ./bin/Reserves/LlistaReserves.class
	javac -d . $<

## ARCHIVOS QUE EJECUTAN: Package Usuaris ##
# Compilación archivo validador de Usuari
./bin/Aplicacio/UsaUsuari.class: ./src/Aplicacio/UsaUsuari.java ./bin/Usuaris/Usuari.class
	javac -d . $<
# Compilación archivo validador de LlistaEntitats
./bin/Aplicacio/UsaLlistaUsuaris.class: ./src/Aplicacio/UsaLlistaUsuaris.java ./bin/Usuaris/LlistaUsuaris.class
	javac -d . $<

## ARCHIVOS QUE EJECUTAN: Clase Aplicacio ##
./bin/Aplicacio/ArxiusApp.class: ./src/Aplicacio/ArxiusApp.java
	javac -d . $<
./bin/Aplicacio/App.class: ./src/Aplicacio/App.java ./src/Aplicacio/ArxiusApp.java
	javac -d . $<

# Regla que obliga a ir compilando todos los archivos anteriores
all: 	./bin/Entitats/Entitat.class \
		./bin/Entitats/LlistaEntitats.class \
		./bin/Reserves/Reserva.class \
		./bin/Reserves/LlistaReserves.class \
		./bin/Usuaris/Usuari.class \
		./bin/Usuaris/LlistaUsuaris.class \
		./bin/Activitats/Activitat.class \
		./bin/Activitats/Taller.class \
		./bin/Activitats/Xerrada.class \
		./bin/Activitats/Visita.class \
		./bin/Activitats/LlistaActivitats.class \
		./bin/Aplicacio/UsaEntitat.class \
		./bin/Aplicacio/UsaLlistaEntitats.class \
		./bin/Aplicacio/UsaReserva.class \
		./bin/Aplicacio/UsaLlistaReserves.class \
		./bin/Aplicacio/UsaUsuari.class \
		./bin/Aplicacio/UsaLlistaUsuaris.class \
		./bin/Aplicacio/UsaActivitat.class \
		./bin/Aplicacio/UsaLlistaActivitats.class \
		./bin/Aplicacio/ArxiusApp.class \
		./bin/Aplicacio/App.class

UsaEntitat: ./bin/Aplicacio/UsaEntitat.class
	java bin.Aplicacio.UsaEntitat

UsaLlistaEntitats: ./bin/Aplicacio/UsaLlistaEntitats.class
	java bin.Aplicacio.UsaLlistaEntitats

UsaUsuari: ./bin/Aplicacio/UsaUsuari.class
	java bin.Aplicacio.UsaUsuari

UsaLlistaUsuaris: ./bin/Aplicacio/UsaLlistaUsuaris.class
	java bin.Aplicacio.UsaLlistaUsuaris

UsaReserva: ./bin/Aplicacio/UsaReserva.class
	java bin.Aplicacio.UsaReserva

UsaLlistaReserves: ./bin/Aplicacio/UsaLlistaReserves.class
	java bin.Aplicacio.UsaLlistaReserves

UsaActivitat: ./bin/Aplicacio/UsaActivitat.class
	java bin.Aplicacio.UsaActivitat

UsaLlistaActivitats: ./bin/Aplicacio/UsaLlistaActivitats.class
	java bin.Aplicacio.UsaLlistaActivitats

App: ./bin/Aplicacio/App.class
	java bin.Aplicacio.App

app: App

# Eliminar todos los .class de ./bin/ y directorios
clean:
	find ./bin/* -iname "*.class" | xargs rm -f
	find ./bin/* -type d | xargs rmdir
