package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++){
            if (Character.isUpperCase(word.charAt(i))){
                answer += (char)(155 - (int)word.charAt(i));
            }
            else if (Character.isLowerCase(word.charAt(i))){
                answer += (char)(219 - (int)word.charAt(i));
            }
            else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}
