package onboarding;

public class Problem4 {
    static boolean isCheck(String word) {
        if(word.length()<1 || word.length()>1000) {
            return true;
        }
        return false;
    }

    public static String solution(String word) {
        String answer="";

        if(isCheck(word)) {
            answer = "문자열의 길이가 잘못되었습니다.";
        }

        word = word.replaceAll("[^a-zA-Z]", " ");
        return answer;
    }
}

