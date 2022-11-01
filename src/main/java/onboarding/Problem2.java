package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return slove(cryptogram);
    }
    static String slove(String n) {
        String result1= "";
        String result = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == (n.charAt(i + 1))) {
                for (int j = 0; j < i; j++) {
                    result += n.charAt(j);
                }
                for (int k = i + 2; k < n.length(); k++) {
                    result += n.charAt(k);
                }
                break;

            }

        }
        for (int i = 0; i < result.length()-1; i++) {
            if (result.charAt(i) == (result.charAt(i + 1))) {
                return slove(result);
            }

        }
        return result;
    }
}
