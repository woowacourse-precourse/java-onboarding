package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int length = word.length();

        for( int i=0; i<length; i++){
            int atASCII = (int)word.charAt(i);
            if (atASCII >= 65 && atASCII <= 90){
                // 1. 대문자인 경우
                if(atASCII <= 77 ){
                    atASCII = 90-(atASCII-65);
                }else{
                    atASCII = 65+(90-atASCII);
                }
            }else if (atASCII >= 97 && atASCII <= 122){
                // 2. 소문자인 경우
                if(atASCII <= 109 ){
                    atASCII = 122-(atASCII-97);
                }else{
                    atASCII = 97+(122-atASCII);
                }
            }

            answer += (char)atASCII;
//            System.out.println(answer);
        }
        return answer;
    }
}
