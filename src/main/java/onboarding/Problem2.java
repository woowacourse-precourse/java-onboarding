package onboarding;

public class Problem2 {
    public static String removeReduplicate(String str) {
        String result = "";

        if (str.charAt(0) != str.charAt(1))
            result += str.charAt(0);

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i) != str.charAt(i + 1))
                result += str.charAt(i);
        }

        if (str.length() > 2 && str.charAt(str.length() - 1) != str.charAt(str.length() - 2))
            result += str.charAt(str.length() - 1);

        return result;
    }

    public static String solution(String cryptogram) {
        int length = cryptogram.length();
        String answer = "";

        while (true) {
            if(cryptogram.length()==0)
                break;

            answer = removeReduplicate(cryptogram);

            if (answer.length() == cryptogram.length()) {
                break;
            } else {
                cryptogram = answer;
            }
        }

        return answer;
    }
}
