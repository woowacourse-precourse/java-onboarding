package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chars = word.toCharArray();
        for(char c : chars){

            if(Character.isLowerCase(c)){
                answer += (char)(219-(int)c);
            }
            else if(Character.isUpperCase(c)) {
                answer += (char)(155-(int)c);
            }
            else{
                answer+=c;
            }

        }
        return answer;
    }
}
