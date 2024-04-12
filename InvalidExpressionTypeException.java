public class InvalidExpressionTypeException extends RuntimeException {
    public InvalidExpressionTypeException(String message) {
        super("Invalid expression type in expression " + message);
    }
}
