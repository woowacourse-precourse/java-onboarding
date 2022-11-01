package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)){
                answer.append((char)('A'+('Z'-ch)));
            } else if(Character.isLowerCase(ch)){
                answer.append((char)('a'+('z'-ch)));
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
