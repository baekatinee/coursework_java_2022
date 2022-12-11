package by.bsu.zorg.test;

import java.util.Random;

public class Util {

    private static Random r = new Random();

    public static String generatePassword() {
        final StringBuilder password = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            password.append((char) (r.nextInt(26) + 'a'));
            if (i == 1) {
                password.append("@");
            }
            if (i == 4) {
                password.append("!");
            }
        }
        return password.toString();
    }

    public static String generateEmail() {
        final StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append((char) (r.nextInt(26) + 'a'));
        }
        return email.append("@gmail.com").toString();
    }
}
