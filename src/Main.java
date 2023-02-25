import java.awt.desktop.PreferencesEvent;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Hier mag je je code scrijven voor de hoofd-opdracht
        Integer[] numeric = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] alphabetic = {"nul", "één", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen"};

        Translator translator = new Translator(alphabetic, numeric);

        boolean play = true;
        String ongeldig = "Ongeldige invoer";
        Scanner scanner = new Scanner(System.in);

        while (play) {
            System.out.println("Type 'x' om te stoppen \nType 'v' om te vertalen");
            String input = scanner.nextLine();

            if (input.equals("x")) {
                play = false;
            } else if (input.equals("v")) {
                System.out.println("Type een cijfer van 0 t/m 9");
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number < 10 && number >= 0) {
                    String result = translator.translate(number);
                    System.out.println("De vertaling van " + number + " is " + result);
                } else {
                    System.out.println(ongeldig);
                }
            } else {
                System.out.println(ongeldig);
            }
        }


        HashSet<Integer> secretNumber = randomNumberGenerator();
        String stringNumber =  setToStringConverter(secretNumber);
        System.out.println(stringNumber);
        feedback(stringNumber);

    }

    public static HashSet<Integer> randomNumberGenerator() {
        HashSet<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();
        int i = 0;
        while(i <= 4) {
            randomNumbers.add(random.nextInt(10));
            i++;
        }
        return randomNumbers;
    }

    public static String setToStringConverter(HashSet<Integer> randomNumbers) {
        StringBuilder randomNumbersString = new StringBuilder();
        for (Integer randomNumber : randomNumbers) {
            randomNumbersString.append(randomNumber.toString());
        }
        return randomNumbersString.toString();
    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringNumber) {
        boolean play = true;
        Scanner scanner = new Scanner(System.in);

        while (play) {
            StringBuilder feedback = new StringBuilder();
            System.out.println("take a guess");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringNumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                play = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringNumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringNumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
            System.out.println("Do you want to guess again? y/n");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                play = true;
            } else if (input.equals("n")) {
                play = false;
            } else {
                System.out.println("Invalid entry!");
            }

        }
    }
}
