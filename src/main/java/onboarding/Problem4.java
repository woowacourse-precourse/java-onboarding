package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = new String(word);

        int len = answer.length();
        for(int i=0; i<len; i++){
            char now = answer.charAt(i);

            if(now >= 'A' && now <= 'Z'){
                now = (char)('Z' - (now - 'A'));
            }
            else if(now >= 'a' && now <='z'){
                now = (char)('z' - (now - 'a'));
            }


            answer = answer.substring(0, i)+now +answer.substring(i+1);


        }
        return answer;
    }
}
