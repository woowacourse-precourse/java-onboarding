package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //A는65 a는 97 Z는90 z는122
        //아스키코드값 대문자는 합 155 소문자는 합219
        for (int i =0;i<word.length();i++){
            char ascnum = word.charAt(i);
            if (ascnum>=65 && ascnum<=90){
                answer = String.valueOf((char)(155-ascnum));
            }//대문자에 속하면 반대되는 대문자로 변환
            if (ascnum>=97 && ascnum<=122){
                answer = String.valueOf((char)(219-ascnum));
            }//소문자에속하면 반대되는 소문자로 변환
            System.out.println("answer = " + answer);
        }
        return answer;
    }
}
