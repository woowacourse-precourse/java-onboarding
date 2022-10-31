package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            char tmp;
            if(c<91){       //대문자 일 때, space
                if(c==32){
                    tmp=(char) 32;
                }else{
                    tmp = (char) (65 + (90 - c));
                }
            }else{          //소문자 일 때
                tmp = (char) (97 + (122 - c));
            }
            answer += Character.toString(tmp);
        }
        return answer;
    }

}
