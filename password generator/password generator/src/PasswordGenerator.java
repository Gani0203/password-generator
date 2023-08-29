import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        int length = 12; // Desired password length
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        List<String> charCategories = new ArrayList<>();
        charCategories.add(LOWERCASE);
        charCategories.add(UPPERCASE);
        charCategories.add(DIGITS);
        charCategories.add(SPECIAL_CHARACTERS);

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int charIndex = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(charIndex));
        }

        return password.toString();
    }
}
