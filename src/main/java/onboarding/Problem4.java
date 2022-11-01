package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = solution2(word);
        return answer;
    }

    private static String solution2(String word) {
        String flog_answer = "";

        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(i, i + 1);
            flog_answer = flog_answer.concat(getReverseWord(temp));

        }
        return flog_answer;

    }

    /**
     * 입력받은 문자의 리버스 문자를 리턴함.
     * 
     * @param word "a", "A"
     * @return "z", "Z"
     */
    private static String getReverseWord(String word) {
        String alpabat = "";
        if (isUpperCase(word.charAt(0))) {
            alpabat = getUpperCase();
        } else if (isLowerCase(word.charAt(0))) {
            alpabat = getLowerCase();
        } else {
            return word;
        }

        int index = alpabat.indexOf(word);

        String rWord = alpabat.substring(alpabat.length() - 1 - index, alpabat.length() - index);
        return rWord;
    }

    private static String getUpperCase() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    private static String getLowerCase() {
        return "abcdefghijklmnopqrstuvwxyz";
    }

    private static boolean isUpperCase(char character) {
        return ('A' <= character && character <= 'Z');
    }

    private static boolean isLowerCase(char character) {
        return ('a' <= character && character < 'z');
    }

}