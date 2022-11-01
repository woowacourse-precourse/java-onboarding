package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            int val = (int) c;
            if(65<= val & val <= 90){
                val = 155-val;
                c = (char) val;
            } else if( 97 <= val & val<= 122){
                val = 219 - val;
                c = (char) val;
            }
            answer += c;
        }
        return answer;
    }
}
