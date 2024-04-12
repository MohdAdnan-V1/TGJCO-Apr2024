public class DiceRoller {
    public static void main(String[] args) {
        // Placeholder for user input handling
        String[] inputs = {"3d6", "d20 + 5", "3d4 * 1.5", "2d10 + 3d8 - 5", "3d17"}; // Example inputs
        for (String input : inputs) {
            try {
                DiceExpression expression = new DiceExpression(input);
                expression.evaluate();
            } catch (InvalidExpressionTypeException ex){
                System.out.println(" Invalid Expression Type");
            }catch (InvalidDiceTypeException ex){
                System.out.println(" Invalid Dice Type");
            } catch (InvalidNumberOfDiceException ex){
                System.out.println(" Invalid Number of Dice");
            }
        }

    }
}
