# Compiler and flags
JAVAC = javac
JAVA = java
JANSI_JAR = jansi-2.4.0.jar
JSON_JAR = json-20250107.jar

# Directories
SRC_DIR = src
BIN_DIR = bin

# Source files
SOURCES = $(wildcard $(SRC_DIR)/*.java) $(wildcard $(SRC_DIR)/snowball/*.java)

# Targets
all: compile

compile:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) -cp $(JANSI_JAR):$(JSON_JAR) $(SOURCES)

run: compile
	$(JAVA) --enable-native-access=ALL-UNNAMED -cp $(BIN_DIR):$(JANSI_JAR):$(JSON_JAR) Main input.json output.json

clean:
	rm -rf $(BIN_DIR)

.PHONY: all compile run clean

