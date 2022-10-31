package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String decoding(String str){
        String result = "";
        char preCh = ' ';
        for(int index = 1; index < str.length(); index++){
            char ch = str.charAt(index);
            if(ch != preCh){
                result += ch;
            }
        }
        return result;
    }
}
