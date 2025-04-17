# MSS-P1-24-25
**University:** Universidad de La Laguna  
**Degree:** Grado en Ingeniería Informática  
**Course:** Modelado de Sistemas Software (2024/2025)   
**Author:** Alejandro Rodríguez Rojas  
**Mail:** alu0101317038@ull.edu.es  


---

## 🧠 Project Overview

This Java project applies object-oriented programming principles to model several software components in a clean, modular, and testable way.

The main objective is to demonstrate good software modeling practices such as encapsulation, reusability, test coverage, and proper documentation.

---

## 🧱 Project Modules

### 1. 🔢 Prime Numbers
**Class:** `PrimeNumbers`
- Generates all prime numbers up to a user-defined limit.
- Calculates the total sum of those primes.
- Uses optimized primality logic.

### 2. 📈 Fibonacci Series
**Class:** `FibonacciSeries`
- Generates the first `n` Fibonacci numbers.
- Lists Fibonacci numbers within a given range `[min, max]`.
- Checks if a specific number belongs to the sequence.
- Internally reuses a single private method for logic consistency.

### 3. 🧮 Vectors
**Class:** `Vector`
- Represents an `n`-dimensional vector of real numbers (`double[]`).
- Computes the dot product between two vectors.
- Supports console input and `.txt` file output.
- Includes methods for printing and converting to CSV-style text.

### 4. 🧾 Matrices
**Class:** `Matrix`
- Implemented as an array of `Vector` objects (one per row).
- Supports matrix multiplication (`A × B`).
- Allows input via console or file, and output to `.txt`.
- Provides column access and clean structure for reuse.

---

## 🧪 Unit Testing

All classes are fully tested using **JUnit 5**.  
Tests are located in the `test/` directory and cover:

- Standard use cases
- Boundary conditions
- Expected exceptions (e.g., invalid matrix dimensions)

---

## 📚 Documentation

The project includes complete **Javadoc documentation**, generated via IntelliJ IDEA.  
It documents:

- All classes and public methods
- Constructors, attributes, and usage details
- Module interactions

Open `doc/index.html` in any browser to navigate the documentation.

---

## 📂 Project Structure

```
MSS-P1-24-25/
├── src/
│   ├── app/               → Main.java
│   ├── numbers/           → PrimeNumbers.java, FibonacciSeries.java
│   └── algebra/           → Vector.java, Matrix.java
│
├── test/                  → JUnit 5 unit tests
│   ├── numbers/
│   └── algebra/
│
├── doc/                   → Generated Javadoc HTML
└── README.md              → This file
```

---

## 🧩 Program Menu

The `Main` class displays an interactive menu allowing the user to choose:

1. Prime number operations
2. Fibonacci series functions
3. Dot product between vectors
4. Matrix multiplication (manual and from file)

---

## ✅ Conclusion

This project brings together various key concepts of Java object-oriented programming, combining functionality, testing, and documentation in a coherent way.
