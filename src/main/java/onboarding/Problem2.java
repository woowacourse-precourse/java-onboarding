package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //모든 연속된 char 삭제 후 return
    private static String nextString(String str){
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                str = removeChar(str, i--);
            }
        }
        return str;
    }

    //str에서 idx번째, idx+1번째 char 삭제
    private static String removeChar(String str, int idx){
        return str.substring(0, idx)+str.substring(idx+2);
    }
}