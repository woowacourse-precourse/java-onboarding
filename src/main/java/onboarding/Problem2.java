package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static boolean isUnique(String str){
        if(str.length() == 1)return true;
        char before = str.charAt(0);
        for (int i = 1; i<str.length(); i++){
            if(before == str.charAt(i)) return false;
        }
        return true;
    }
}
