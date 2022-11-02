import java.util.Random;
public class NumberGenerator {
    private String generateString;
    public String generateString() {
        Random random = new Random();
        generateString = "";

        while (generateString.length() < 4) {
            int x = random.nextInt(10);
            if (!generateString.contains(Integer.toString(x))) {
                generateString = generateString + x;
            }
        }
        return generateString;
    }
}
