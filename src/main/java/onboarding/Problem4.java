package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 참고 : 알파벳의 char 값 A:65 ~ Z:90 & a:97 ~ z:122
        for (int i=0; i<word.length(); i++) {
            //char로 추출해서 int로 변환
            int num = Integer.valueOf(word.charAt(i));
            //1) 대문자의 경우
            if(num >= 65 && num <= 90) {
                if(num <= 77)  num = 77 + (78-num);
                else num = 78 - (num-77);
            //2) 소문자의 경우
	        } else if(num >= 97 && num <= 122){
	            if(num <= 109) num = 109 + (110-num);
	            else num = 110 - (num-109);
	        }
            answer += String.valueOf((char)num);
        }
        return answer;
    }
}