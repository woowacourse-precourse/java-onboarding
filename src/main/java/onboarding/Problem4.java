package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);

            if(target >= 65 && target <= 90) {
                int ascii = 90 - (int) target  + 65;
                target = (char) ascii;
            } else if (target >= 97 && target <= 122) {
                int ascii = 122- (int) target  + 97;
                target = (char) ascii;
            }

            result.append(target);
        }

        return answer;
    }
}
