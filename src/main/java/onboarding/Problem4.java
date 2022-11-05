package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0;i<word.length();i++){
            if((int)word.charAt(i) == 32){
                answer += " ";
                continue;
            }
            else if((word.charAt(i) >= 65 && word.charAt(i) <= 90) || (word.charAt(i) >= 97 && word.charAt(i) <= 122)){
                if(Character.isUpperCase(word.charAt(i))){
                    answer += (char)(155-(int)word.charAt(i));
                }
                else{
                    answer += (char)(219-(int)word.charAt(i));
                }

            }

        }
        return answer;
    }
}
