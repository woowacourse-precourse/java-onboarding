package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int index = 0;index < word.length();index++){
            int cur_ascii = (int)word.charAt(index);
            if(cur_ascii>=65 && cur_ascii<=90){
                answer += (char)(90-(cur_ascii-65));
            }
            else if(cur_ascii>=97 && cur_ascii<=122){
                answer += (char)(122-(cur_ascii-97));
            }
            else{
                answer+=(char)cur_ascii;
            }
        }

        return answer;
    }
}
