package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        return cryptogram;
    }

    //중복 제거 함수
    private static String deduplication(String cryptogram){
        String changeString = cryptogram.replaceAll("(([a-zA-Z0-9])\\2{1,})","");
        
        //원래 문자와 같다면 FALSE 문자 반환
        if(cryptogram.equals(changeString)){
            return "FALSE";
        }
        //다르다면 바뀐 문자 반환
        else{
            return changeString;
        }
    }
}
