package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (checkRepetition(cryptogram)){
            cryptogram = removeRepetition(cryptogram);
        }
        return cryptogram;
    }

    //1. 연속된 중복 문자 존재 여부 판별 기능
    static boolean checkRepetition(String str){
        for (int i=0 ; i<str.length()-1 ; i++){
            if (str.charAt(i) == str.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

}

