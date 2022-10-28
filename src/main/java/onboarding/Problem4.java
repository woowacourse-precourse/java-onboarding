package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //알파벳 대문자일 경우 변환

        //알파벳 소문자일 경우 변환

        //공백일 경우 유지

        return answer;
    }

    private static boolean isUpperCase(char a){
        if('A'<=a && a<='Z') {
            return true;
        }else{
            return false;
        }
    }
}
