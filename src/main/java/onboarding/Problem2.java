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

    //2. 연속된 중복 문자가 존재할 경우, 삭제한 결과를 반환하는 기능
    static String removeRepetition(String str){
        String result = "";
        for (int i=0 ; i<str.length()-1 ; i++){
            if (str.charAt(i) != str.charAt(i+1)){
                result += str.charAt(i);
            } else {
                i++;
            }
        }
        if (str.length() > 2){
            result += str.charAt(str.length()-1);
        }
        return result;
    }
}

