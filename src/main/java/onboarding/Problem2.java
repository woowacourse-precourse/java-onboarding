package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //연속된 char 하나 삭제 후 return | 연속된 char가 없다면 그대로 return
    private static String nextString(String str){

    }

    //str에서 idx번째 char 삭제
    private static String removeChar(String str, int idx){
        return str.substring(0, idx)+str.substring(idx+1);
    }
}
