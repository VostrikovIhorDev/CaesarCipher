Caesar Cipher

A Java application that encrypts and decrypts text using the Caesar cipher.

The project supports encryption and decryption of text and files using a configurable shift value.


Features
Caesar cipher encryption
Caesar cipher decryption
File encryption and decryption
Input validation
Support for the English alphabet and punctuation
Unit tests with JUnit 5
Maven project structure


Technologies
Java
Maven
JUnit 5
Git


Project Structure

src/
├── main/
│   └── java/
│       ├── Alphabet.java
│       ├── CaesarCipher.java
│       ├── FileManager.java
│       ├── Main.java
│       └── Validator.java
│
└── test/
└── java/
├── AlphabetTest.java
├── CaesarCipherTest.java
├── FileManagerTest.java
└── ValidatorTest.java


Description

The application implements the Caesar cipher, a simple substitution cipher in which each character is replaced by another character at a fixed position in the alphabet.

The shift value determines how many positions each character is moved.

Characters that are not part of the supported alphabet are preserved without changes.


File Operations

The application can encrypt and decrypt text files.

File processing is handled by the FileManager class, while the encryption logic is implemented in CaesarCipher.


Validation

The Validator class is responsible for validating user input, including the shift value and file-related parameters.

Testing

The project contains unit tests for the main application components:

Alphabet
CaesarCipher
FileManager
Validator


Tests are written using JUnit 5.

To run all tests:

mvn test
Maven

The project uses Maven for dependency management, project configuration, compilation, testing, and packaging.

Compile the project:

mvn compile

Run tests:

mvn test

Create a packaged application:

mvn package
How to Run

Run the Main class from your IDE or using the compiled project.

The application provides the functionality required to encrypt and decrypt text and files using the Caesar cipher.