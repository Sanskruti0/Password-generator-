
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("Y");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("The Generated password is " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                           boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        if (!includeUppercase && !includeLowercase && !includeNumbers && !includeSpecialChars) {
            throw new IllegalArgumentException("No character set selected");
        }

        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}<>.,:;?/\\";
        String characterSet = "";

        if (includeUppercase) {
            characterSet += uppercaseLetters;
        }
        if (includeLowercase) {
            characterSet += lowercaseLetters;
        }
        if (includeNumbers) {
            characterSet += numbers;
        }
        if (includeSpecialChars) {
            characterSet += specialChars;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            char randomChar = characterSet.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}