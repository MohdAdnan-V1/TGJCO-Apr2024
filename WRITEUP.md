Features Implemented:

1. Dice Expression Parsing: We implemented a method to parse input expressions into individual components such as dice rolls, operators, and numeric values using regular expressions. This allows for flexible input handling and supports a variety of expression formats.

2. Dice Rolling: The program simulates rolling dice of various types and quantities. It utilizes the `DiceRoll` class to generate random numbers within the specified range for each die roll.

3. Arithmetic Operations: The program supports basic arithmetic operations (addition, subtraction, multiplication) between dice rolls and numeric values. It evaluates these operations according to the specified operator in the input expression.

4. Error Handling: We incorporated custom exception classes to handle errors such as invalid expression types, dice types, or numbers of dice. This improves the robustness of the program and provides informative error messages to users.

5. Output Display: After evaluating each input expression, the program prints the original expression along with the resulting value. This gives users immediate feedback on the outcome of their dice rolls and calculations.

How It Works:

- Dice Expression Parsing: Regular expressions are used to match patterns in the input string, identifying components such as dice rolls (e.g., "3d6"), operators (e.g., "+"), and numeric values (e.g., "5"). The `findExpType()` method in the `DiceExpression` class determines the type of each component based on these patterns.

- Dice Rolling: The `DiceRoll` class utilizes Java's `java.util.Random` class to generate random numbers within the range of the specified sides for each die roll. The `rollDie()` method returns the result of a single die roll.

- Arithmetic Operations: The `evaluateExpression()` method in the `DiceExpression` class performs arithmetic operations between dice rolls and numeric values based on the specified operator. It utilizes Java's switch statement to handle different operator cases (e.g., addition, subtraction, multiplication).

- Error Handling: Custom exception classes (`InvalidExpressionTypeException`, `InvalidDiceTypeException`, `InvalidNumberOfDiceException`) are thrown when errors occur during expression evaluation. These exceptions provide descriptive error messages to guide users in correcting their input.

- Output Display: After evaluating each input expression, the program prints the original expression along with the resulting value. This output is displayed in the console, allowing users to quickly see the outcome of their dice rolls and calculations.

Why We Should Win:

- Comprehensive Implementation: We have implemented a comprehensive solution that handles various aspects of dice rolling and expression evaluation, including parsing, rolling dice, performing arithmetic operations, and error handling.

- Modular Design: The program is well-structured and modular, with separate classes for different functionalities. This makes the code easy to understand, maintain, and extend in the future.

Overall, our implementation demonstrates a strong understanding of the problem requirements and delivers a functional and well-designed solution that meets the needs of users seeking to simulate dice rolls and perform arithmetic operations.