import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRoll {
    // Method to find the random dice number
    public static int rollDie(int sides) {
        Random random = new Random();
        return random.nextInt(sides);
    }

}
