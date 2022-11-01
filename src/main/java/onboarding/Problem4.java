package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = frogWord(word);
        return answer;
    }
    public static String frogWord(String word){

        if(exceptionCheck(word)) return null;

        StringBuffer fword = new StringBuffer(word);
        //문자열을 돌면서 각 위치의 문자가 영어 대소문자이면 청개구리사전에 맞추어 변환한다
        //A는 Z, B는 Y, C는 X ... 이 사전의 규칙에 따르면
        //아스키코드로 각 대응하는 문자의 합이 대문자는 155, 소문자는 219 이다
        for(int i = 0 ; i < fword.length() ; i++){
            char fword_c = fword.charAt(i);
            //문자가 대문자인 경우
            if(fword_c > 64 && fword_c < 91)
                fword.replace(i,i+1, Character.toString(155-fword_c));
                //문자가 소문자인 경우
            else if(fword_c > 96 && fword_c < 123)
                fword.replace(i,i+1, Character.toString(219-fword_c));
        }
        return fword.toString();
    }
    public static boolean exceptionCheck(String word){
        //number는 1이상 10,000 이하인 자연수이다.
        if(word.length() < 0 || word.length() > 1000) return true;
        return false;
    }
}
