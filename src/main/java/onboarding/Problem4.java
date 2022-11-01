package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if (isAlpha(word.charAt(i))) {
                if (isUpperCase(word.charAt(i))) {
                    answer += (char) (155 - (int) word.charAt(i));
                } else if (isLowerCase(word.charAt(i))) {
                    answer += (char) (219 - (int) word.charAt(i));
                }
            } else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }

    private static boolean isUpperCase(char s) {
        if (s >= 'A' && s <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowerCase(char s) {
        if (s >= 'a' && s <= 'z') {
            return true;
        }
        return false;
    }

    private static boolean isAlpha(char s) {
        if (!(s >= 'A' && s <= 'Z') && !(s >= 'a' && s <= 'z')) {
            return false;
        }
        return true;
    }
}


//        if i.isupper():
//          result.append(chr(ord(i) + (-2*(ord(i) - 65) + 25)))
//        else:
//          result.append(chr(ord(i) + (-2*(ord(i) - 97) + 25)))