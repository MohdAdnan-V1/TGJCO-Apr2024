import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceExpression {
    private String expression;

    public DiceExpression(String expression) {
        this.expression = expression.trim(); // Trim the input string
    }

    public void evaluate() {
        System.out.print("Input: " + expression);
        String[] diceExpressions = expression.split(" ");
        int result = 0;
        char currentOperator = '+';
        // evaluating dice type
        for (String exp : diceExpressions) {
            ExpressionType expressionType = findExpType(exp);
            switch (expressionType) {
                case OPERATOR -> {
                    currentOperator = exp.charAt(0);
                }
                case DICE -> {
                    currentOperator = '+';
                    DiceRollInformation diceRollInformation = getTypeOfDice(exp);
                    result = roleDiceExecution(result, diceRollInformation.diceType().getSides(), diceRollInformation.amountOfDice());
                }
                case NUMBER -> {
                    result = evaluateExpression(result, currentOperator, Float.parseFloat(exp));
                }
                case INVALID -> throw new InvalidExpressionTypeException(exp);
            };
        }
        String resultStr = "Result: " + result;
        System.out.println("\n" + resultStr);
    }

    // Method to execute rolling of dice number of times
    private int roleDiceExecution(int result, int sides, int numberOfTimToRole){
        System.out.print(" Output: ");
        for (int i = 0; i < numberOfTimToRole; i++) {
            int diceNumber = DiceRoll.rollDie(sides);
            System.out.print(diceNumber);
            if (i < numberOfTimToRole - 1)
                System.out.print(", ");
            result += diceNumber;
        }
        return result;
    }

    // Method to get the type of dice
    private DiceRollInformation getTypeOfDice(String diceType) {
        String[] splitDiceType = diceType.split("d");

        String amountOfDiceString = splitDiceType[0];
        if (amountOfDiceString.trim().isEmpty()) {
            amountOfDiceString = "1";
        }

        int amountOfDice = Integer.parseInt(amountOfDiceString);
        if (amountOfDice < 1) {
            throw new InvalidNumberOfDiceException();
        }

        String diceTypeString = splitDiceType[1];

        return new DiceRollInformation(amountOfDice, DiceType.getDiceTypeFromString(diceTypeString));
    }

    // Method to find the type of expression
    private ExpressionType findExpType(String exp) {
        Pattern dicePattern = Pattern.compile("(\\d*)d(\\d+)([\\+\\-\\*]?)(\\d*)");
        Matcher diceMatcher = dicePattern.matcher(exp);

        Pattern operatorPattern = Pattern.compile("([\\+\\-\\*])");
        Matcher operartorMatcher = operatorPattern.matcher(exp);
        if (diceMatcher.matches()) {
            return ExpressionType.DICE;
        }

        if (operartorMatcher.matches()) {
            return ExpressionType.OPERATOR;
        }

        if (isNumeric(exp)) {
            return ExpressionType.NUMBER;
        }

        return ExpressionType.INVALID;
    }

    // Method to check if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    // Method to evaluate an expression
    public static int evaluateExpression(int total, char operator, float modifier) {
        return switch (operator) {
            case '+' -> Math.round(total + modifier);
            case '-' -> Math.round(total - modifier);
            case '*' -> Math.round(total * modifier);
            default -> 0; // For now, assuming only addition, subtraction, and multiplication
        };
    }
}