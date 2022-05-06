package gr.aueb.cf.projects;

import java.util.Scanner;

/**
 * Project 9
 *
 *
 */
public class EncryptDecrypt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phraseToEncrypt;
        String numberSequenceToDecrypt;

        System.out.println("Type the phrase that you want to encrypt");
        phraseToEncrypt = scanner.nextLine();
        System.out.println(encryption(phraseToEncrypt));

        System.out.println("Type the phrase that you want to decrypt");
        numberSequenceToDecrypt = scanner.nextLine();
        System.out.println(decryption(numberSequenceToDecrypt));

    }

    public static String encryption(String s) {

        final int KEY = 1024;
        int pivot = 0;
        StringBuilder sb = new StringBuilder();

        if (s.equals("")) {
            return null;
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (i == 0) {
                sb.append((int) chars[0]).append(" ");
            } else if (chars[i] == '#') {
                sb.append("-1");
            } else {
                chars[i] = (char) ((chars[i] + chars[i - 1]) % KEY);
                sb.append( (int) chars[i]).append(" ");
            }
        }

        return sb.toString();
    }

    public static String decryption(String s) {

        final int KEY = 1024;
        StringBuilder sb = new StringBuilder();
        char[] chars;

        String[] val = s.split(" ");

        chars = new char[val.length];
        for (int i = 0; i < val.length; i++) {
            chars = val[i].toCharArray();
        }

        for (int i = 0; i < chars.length; i++) {

            if (i == 0) {
                sb.append(chars[0]);
            } else if (chars[i] == Integer.parseInt("-1")) {
                sb.append("#");
            } else {
                chars[i] = (char) (chars[i] * (KEY + chars[i] - chars[i - 1]));
                sb.append(chars[i]);
            }
        }

        return sb.toString();

    }
}
