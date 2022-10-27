package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //기능 1.
    public static int index(String str){
        int answer = -1;
        char [] chars = str.toCharArray();
        int charsLen = chars.length-1;
        for (int i = 0; i < charsLen; i++) {
            answer = i;
            break;
        }
        return answer;
    }

    //기능 2.
    public static String delChar(String str, int index){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, index));
        sb.append(str.substring(index + 2));

        return sb.toString();
    }

}
