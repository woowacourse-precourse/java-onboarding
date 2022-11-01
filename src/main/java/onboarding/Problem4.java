package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == ' '){
                answer += ' ';
            }
            else{
                if(Character.isUpperCase(ch)){
                    answer += (char)(155 - (int)ch);
                }
                else if(Character.isLowerCase(ch)){
                    answer += (char)(219 - (int)ch);
                }
            }
        }
        return answer;
    }
}
