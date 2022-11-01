package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c >=65 && c <= 90){
                answer += (char)(155 - c);
            }
            else if(c <= 122 && c >= 97){
                answer += (char)(219 - c);
            }
            else{
                answer += c;
            }
        }



        return answer;
    }
}
