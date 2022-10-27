package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String delete_continuous(String str, char c){
        int index = str.indexOf(c);
        while(index == 0){
            str = str.substring(1);
            index = str.indexOf(c);
        }
        return str;
    }
}
