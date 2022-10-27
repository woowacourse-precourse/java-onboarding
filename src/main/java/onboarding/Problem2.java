package onboarding;


import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //문자열 길이가 2 이상인지 체크하는 함수
    public static boolean isLengthLong(String cryptogram) {
        int length = cryptogram.length();
        if (length < 2) return false;
        return true;
    }

    //중복 여부를 체크하는 함수
    public static boolean hasDuplicate(String cryptogram){
        int length = cryptogram.length();
        boolean isDuplicate = false;

        for(int i=0;i<length-1;i++){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)) return true;
        }

        return false;
    }

}
