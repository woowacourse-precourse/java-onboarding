package onboarding;

public class Problem4 {

    public static String solution(String word) {
        int[] array = {25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13,
            -15, -17, -19, -21, -23, -25};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);

            if ('A' <= character && character <= 'Z') {
                character += array[character - 'A'];
            } else if ('a' <= character && character <= 'z') {
                character += array[character - 'a'];
            }

            sb.append(character);
        }

        return sb.toString();
    }
}
