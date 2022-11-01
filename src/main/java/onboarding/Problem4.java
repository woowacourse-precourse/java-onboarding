package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = solutionAnswer(word);
        return answer;
    }

    static String solutionAnswer(String inputString){
        String answer = "";
        String s = inputString;

        for(int i=0;i<s.length();i++) {
            char k = s.charAt(i);
            if(Character.isUpperCase(k)) {
                answer += (char)(155 - k);

            }
            else if(Character.isLowerCase(k)) {
                answer += (char)(219 - k);
            }
            else {
                answer += k;
            }
        }
        return answer;
    }

}
