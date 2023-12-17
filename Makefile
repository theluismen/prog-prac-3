## CONSTANTES ##
CP = ./bin
OUTPUT_DIR = ./bin

## ARCHIVOS DE CLASES: Package Entitats ##
# Compilación archivo Entitat.class
./bin/Entitats/Entitat.class: ./src/Entitats/Entitat.java
	javac -d $(OUTPUT_DIR) $<
# Compilación archivo LlistaEntitats.class ( depende de Entitat.class )
./bin/Entitats/LlistaEntitats.class: ./src/Entitats/LlistaEntitats.java ./bin/Entitats/Entitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS DE CLASES: Package Activitats ##
# Compilación archivo Activitat.class
./bin/Activitats/Activitat.class: ./src/Activitats/Activitat.java
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo Taller.class ( clase hija de Activitat.class )
./bin/Activitats/Taller.class: ./src/Activitats/Taller.java ./bin/Activitats/Activitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo Visita.class ( clase hija de Activitat.class )
./bin/Activitats/Visita.class: ./src/Activitats/Visita.java ./bin/Activitats/Activitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo Xerrada.class ( clase hija de Activitat.class )
./bin/Activitats/Xerrada.class: ./src/Activitats/Xerrada.java ./bin/Activitats/Activitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo LlistaReserves.class ( depende de Reserva.class )
./bin/Activitats/LlistaActivitats.class: ./src/Activitats/LlistaActivitats.java ./bin/Activitats/Activitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS DE CLASES: Package Reserves ##
# Compilación archivo Reserva.class
./bin/Reserves/Reserva.class: ./src/Reserves/Reserva.java
	javac -d $(OUTPUT_DIR) $<
# Compilación archivo LlistaReserves.class ( depende de Reserva.class )
./bin/Reserves/LlistaReserves.class: ./src/Reserves/LlistaReserves.java ./bin/Reserves/Reserva.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS DE CLASES: Package Usuaris ##
# Compilación archivo Usuari.class
./bin/Usuaris/Usuari.class: ./src/Usuaris/Usuari.java
	javac -d $(OUTPUT_DIR) $<
# Compilación archivo LlistaUsuaris.class ( depende de Usuari.class )
./bin/Usuaris/LlistaUsuaris.class: ./src/Usuaris/LlistaUsuaris.java ./bin/Usuaris/Usuari.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN: Package Entitats ##
# Compilación archivo validador de Entitat
./bin/UsaEntitat.class: ./src/Aplicacio/UsaEntitat.java ./bin/Entitats/Entitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo validador de LlistaEntitats
./bin/UsaLlistaEntitats.class: ./src/Aplicacio/UsaLlistaEntitats.java ./bin/Entitats/LlistaEntitats.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN: Package Activitats ##
# Compilación archivo validador de Activitat
./bin/UsaActivitat.class: ./src/Aplicacio/UsaActivitat.java ./bin/Activitats/Activitat.class ./bin/Activitats/Taller.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo validador de LlistaActivitats
./bin/UsaLlistaActivitats.class: ./src/Aplicacio/UsaLlistaActivitats.java ./bin/Activitats/LlistaActivitats.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN: Package Reserves ##
# Compilación archivo validador de Reserva
./bin/UsaReserva.class: ./src/Aplicacio/UsaReserva.java ./bin/Reserves/Reserva.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo validador de LlistaReserves
./bin/UsaLlistaReserves.class: ./src/Aplicacio/UsaLlistaReserves.java ./bin/Reserves/LlistaReserves.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN: Package Usuaris ##
# Compilación archivo validador de Usuari
./bin/UsaUsuari.class: ./src/Aplicacio/UsaUsuari.java ./bin/Usuaris/Usuari.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo validador de LlistaEntitats
./bin/UsaLlistaUsuaris.class: ./src/Aplicacio/UsaLlistaUsuaris.java ./bin/UsaLlistaEntitats.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

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
		./bin/UsaEntitat.class \
		./bin/UsaLlistaEntitats.class \
		./bin/UsaReserva.class \
		./bin/UsaLlistaReserves.class \
		./bin/UsaUsuari.class \
		./bin/UsaLlistaUsuaris.class \
		./bin/UsaActivitat.class \
		./bin/UsaLlistaActivitats.class

UsaEntitat: ./bin/UsaEntitat.class
	java -cp $(CP) $@

UsaLlistaEntitats: ./bin/UsaLlistaEntitats.class
	java -cp $(CP) $@

UsaUsuari: ./bin/UsaEntitat.class
	java -cp $(CP) $@

UsaLlistaUsuaris: ./bin/UsaLlistaUsuaris.class
	java -cp $(CP) $@

UsaReserva: ./bin/Reserves/Reserva.class
	java -cp $(CP) $@

UsaLlistaReserves: ./bin/Reserves/LlistaReserves.class
	java -cp $(CP) $@

UsaActivitat: ./bin/UsaActivitat.class
	java -cp $(CP) $@

UsaLlistaActivitats: ./bin/UsaLlistaActivitats.class
	java -cp $(CP) $@

# Eliminar todos los .class de ./bin/ y directorios
clean:
	find $(OUTPUT_DIR)/* -iname *.class | xargs rm -f
	find $(OUTPUT_DIR)/* -type d | xargs rmdir
