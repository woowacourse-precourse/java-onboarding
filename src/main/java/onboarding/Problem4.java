package onboarding;

public class Problem4 {
    private static char[] dictionary = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

    public static String solution(String word) {
        String answer = "";

        if (checkInput(word)) {
            return "-1";
        }

        for (int i = 0; i < word.length(); i++) {
            answer += changeAlphabet(word.charAt(i));
        }

        return answer;
    }

    public static boolean checkInput(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return true;
        }
        return false;
    }

    public static int checkUpperOrLower(char alphabet) {
        if (alphabet >= 'A' && alphabet <= 'Z') {
            return 2;
        }
        if (alphabet >= 'a' && alphabet <= 'z') {
            return 1;
        }
        return 0;
    }

    private static char changeAlphabet(char alphabet) {
        int check = checkUpperOrLower(alphabet);

        if (check == 2) {
            return dictionary[(int)alphabet - 65];
        }
        if (check == 1) {
            return Character.toLowerCase(dictionary[(int)Character.toUpperCase(alphabet) - 65]);
        }

        return alphabet;
    }
}
