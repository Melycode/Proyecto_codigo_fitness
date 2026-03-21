# 🏋️‍♂️ Fitness Code Project - Gym Management

## 📝 Project Description  
**Fitness Code** is an application designed for comprehensive gym management. The system allows efficient administration of both staff and offered services, ensuring a professional and realistic workflow.

## 👥 Development Team  
- Alba Ruiz de la Vega  
- Melissa Frida Guerrero Carnero  
- Brandon David Chusgo Paico  

## 📊 Rubric Compliance  

### 1. Structure and Modeling  
- **Class Hierarchy:** Implementation of 11 total classes, including 2 parent classes (*Person* and *Service*) and 9 child classes.  
- **Instantiation in Main:** 18 objects have been created (2 per child class) to validate system logic.  
- **Encapsulation:** All classes include full/empty constructors, getters, setters, and overridden methods: `equals`, `hashCode`, and `toString`.  
- **Data Types:** Extensive use of primitive types and enumerations.  

### 2. Control Structures and Collections  
- **Dynamic Collections:** Use of `ArrayList` and `HashSet` in classes such as *Enrollment*, *Employee*, and *Class*.  
- **Dictionaries (Maps):** Implementation of 2 `HashMap`s for state control in *Machine* and payment history in *Receptionist*.  
- **CRUD Operations:** Specific methods in each class to add, search, delete, and update elements in collections.  
- **Flow Logic:** The `Main` executes 4 loops and 4 conditional structures, including a `switch` block.  

### 3. Error Handling and Quality  
- **Custom Exceptions:** 4 custom exceptions have been defined, thrown, and handled using `try-catch` blocks:  
  - `MaxCapacityException`: Capacity control  
  - `ClientNotFoundException`: Search errors  
  - `PaymentAlreadyMadeException`: Duplicate payment control  
  - `InsufficientBalanceException`: Transaction validation  
- **Unit Testing:** JUnit test coverage for main classes, including 5 negative test cases to validate behavior under errors.  

### 4. Interface and Persistence  
- **JSON Persistence:** Use of a JSON library for reading and writing enrollment history in the `inscriptions.json` file.  
- **Graphical User Interface (GUI):** Implementation of a BMI calculator using the `javax.swing` library, optionally accessible after console execution.  

> **Note:** The console input system uses `.toLowerCase()` and `.trim()` to ensure smooth and error-resistant user interaction 🗿  
