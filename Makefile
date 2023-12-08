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

## ARCHIVOS QUE EJECUTAN: Package Entitats ##
# Compilación archivo validador de Entitat
./bin/UsaEntitat.class: ./src/Aplicacio/UsaEntitat.java ./bin/Entitats/Entitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<
# Compilación archivo validador de LlistaEntitats
./bin/UsaLlistaEntitats.class: ./src/Aplicacio/UsaLlistaEntitats.java ./bin/Entitats/LlistaEntitats.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN: Package Activitats ##
# Compilación archivo validador de Activitat
./bin/UsaActivitat.java: ./src/Aplicacio/UsaActivitat.java ./bin/Activitats/Activitat.class ./bin/Activitats/Taller.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

# Regla que obliga a ir compilando todos los archivos anteriores
all: ./bin/Entitats/Entitat.class \
		./bin/Entitats/LlistaEntitats.class \
		./bin/Activitats/Activitat.class \
		./bin/Activitats/Taller.class \
		./bin/UsaEntitat.class \
		./bin/UsaLlistaEntitats.class \
		./bin/UsaActivitat.java

UsaEntitat: ./bin/UsaEntitat.class
	java -cp $(CP) $@

UsaLlistaEntitats: ./bin/UsaLlistaEntitats.class
	java -cp $(CP) $@

UsaActivitat: ./bin/UsaActivitat.class
	java -cp $(CP) $@

# Eliminar todos los .class de ./bin/ y directorios
clean:
	find $(OUTPUT_DIR)/* -iname *.class | xargs rm -f
	find $(OUTPUT_DIR)/* -type d | xargs rmdir
