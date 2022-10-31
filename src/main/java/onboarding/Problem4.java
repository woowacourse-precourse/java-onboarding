package onboarding;

public class Problem4 {
    public static boolean checkNotAlphabet(char alphabet) {
        if (alphabet >= 65 && alphabet <= 122) {
            return false;
        }
        return true;
    }

    public static boolean checkLowerCase(char alphabet) {
        int ascii = (int)alphabet;
        if (ascii >= 97 && alphabet <= 122) {
            return true;
        }
        return false;
    }

    public static char toLowerCase(char alphabet) {
        int ascii = (int)alphabet;
        char lowerCase = (char)(ascii - 32);
        char frog = changeFrog(lowerCase);
        char result = (char)((int)frog + 32);
        return result;
    }

    public static char changeFrog(char alphabet) {
        int ascii = (int)alphabet;
        int frog = ascii-65;
        char result = (char)(90-frog) ;
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        for (int i = 0, n = word.length(); i < n; i++) {
            char c = word.charAt(i);
            if (checkNotAlphabet(c)) {
                answer += c;
                continue;
            }
            if (checkLowerCase(c)) {
                char changedChar = toLowerCase(c);
                answer += changedChar;
                continue;
            }
            char changedChar = changeFrog(c);
            answer += changedChar;
        }
        return answer;
    }
}
