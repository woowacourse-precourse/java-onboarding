package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            System.out.println("isAlpha(word) = " + isAlpha(word.charAt(i)));

        }
        return answer;
    }

    //알파벳인지 그 외 문자인지 판별하는 기능
    public static boolean isAlpha(char alpha){
        return (65 <= (int)alpha && (int)alpha <= 90) || (97 <= (int)alpha && (int)alpha <= 122);
    }
}
