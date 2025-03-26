# Stemmer

## Description 

My stemmer is a paragraph processor that aims to tokenize, "stemm" and remove stop words so it can be integrated to a basic files search engine, it uses part of the snowball software for even further word processing.

## Table of contents
- [Installation](#installation)
- [Usage](#usage)
- [TODO](#TODO)
- [License](#license)
- [Contact](#contact)

## Installation

### Prerequisites
- JDK 17 or above

### Steps

- Clone the repository
```bash
git clone --recursive https://github.com/HugeErick/Stemmer.git
cd Stemmer
```

## Usage

1. Compile (If need it) 
```bash
javac -d bin -cp jansi-2.4.0.jar src/*.java src/snowball/*.java
```
2. Run it
```bash
java --enable-native-access=ALL-UNNAMED -cp bin:jansi-2.4.0.jar Main
```

## TODO
- GUI
- Functional Search Engine

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Erick Gonzalez Parada - erick.parada101@gmail.com

Project Link: [https://github.com/HugeErick/Stemmer](https://github.com/HugeErick/Stemmer)
