package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String referenceA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String referencea = "abcdefghijklmnopqrstuvwxyz";

        String reverseA = "";
        String reversea = "";
        for (int i = referenceA.length() - 1; i >= 0; i--) {
            reverseA += referenceA.charAt(i);
            reversea += referencea.charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if ('A' <= s && s <= 'Z') {

                int idx = referenceA.indexOf(s);
                answer += reverseA.charAt(idx);
            }
            else if ('a' <= s && s <= 'z') {

                int idx = referencea.indexOf(s);
                answer += reversea.charAt(idx);
            }
            else {
                answer += " ";
            }
        }
                return answer;
    }
}
