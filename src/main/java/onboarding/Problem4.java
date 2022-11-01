package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            if (isAlpha(word.charAt(i))){
                answer+=changeAlpha(word.charAt(i));
            }else {
                answer+=word.charAt(i);
            }
        }
        return answer;
    }

    //대응하는 알파벳으로 변환
    public static char changeAlpha(char alpha){
        int numAlpha = (int)alpha;
        char result = 0;
        if (65 <= numAlpha && numAlpha <= 90){//대문자
            int minus = 90 - numAlpha;
            return (char) (65 + minus);
        }else{
            int minus = 122 - numAlpha;
            return (char) (97+minus);
        }

    }
    //알파벳인지 그 외 문자인지 판별하는 기능
    public static boolean isAlpha(char alpha){
        return (65 <= (int)alpha && (int)alpha <= 90) || (97 <= (int)alpha && (int)alpha <= 122);
    }
}
