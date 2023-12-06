# CP -> Classpath
CP = ./bin
OUTPUT_DIR = ./bin

## ARCHIVOS DE CLASES ##
# Compilación archivo Entitat.class
./bin/Entitats/Entitat.class: ./src/Entitats/Entitat.java
	javac -d $(OUTPUT_DIR) $<

# Compilación archivo LlistaEntitats.class ( depende de Entitat.class )
./bin/Entitats/LlistaEntitats.class: ./src/Entitats/LlistaEntitats.java ./bin/Entitats/Entitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

## ARCHIVOS QUE EJECUTAN ##
# Compilación archivo validador de LlistaEntitats
./bin/UsaEntitat.class: ./src/Aplicacio/UsaEntitat.java ./bin/Entitats/Entitat.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

# Compilación archivo validador de LlistaEntitats
./bin/UsaLlistaEntitats.class: ./src/Aplicacio/UsaLlistaEntitats.java ./bin/Entitats/LlistaEntitats.class
	javac -d $(OUTPUT_DIR) -cp $(CP) $<

# Regla que obliga a ir compilando todos los archivos anteriores
all: ./bin/Entitats/Entitat.class \
		./bin/Entitats/LlistaEntitats.class \
		./bin/UsaLlistaEntitats.class

UsaEntitat: ./bin/UsaEntitat.class
	java -cp $(CP) $@

UsaLlistaEntitats: all
	java -cp $(CP) $@

# Eliminar todos los .class de ./bin/
clean:
	find $(OUTPUT_DIR)/* -iname *.class | xargs rm -f
