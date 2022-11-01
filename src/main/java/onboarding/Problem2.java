package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = PWDecoder(cryptogram);
        return answer;
    }
    public static String PWDecoder(String cryptogram){

        if(exceptionCheck(cryptogram)) return null;

        //cryptogram에서 중복제거를 위해 문자열에 변경이 많으므로 StringBuffer 사용
        StringBuffer decoded = new StringBuffer(cryptogram);
        //더 이상 중복문자가 제거가 안되는 것 확인용
        int flag = 1;
        while(flag == 1){
            flag = 0;
            //문자열을 한번 훑어서 중복문자를 제거한다.
            for(int i = 0 ; i < decoded.length()-1 ; i++){
                if(decoded.charAt(i) == decoded.charAt(i+1)) {
                    //중복문자 제거
                    decoded.replace(i, i + 2, "");
                    i = i - 1;
                    //중복문자를 한번이라도 제거하면 flag = 1이 된다.
                    flag = 1;
                }
            }
        }
        return decoded.toString();
    }
    public static boolean exceptionCheck(String cryptogram){
        //cryptogram의 길이는 1이상 1000이하이다. 범위를 넘어가면 예외처리
        if(cryptogram.length() < 1 || cryptogram.length() > 1000 ) return true;

        //cryptogram은 알파벳 소문자로만 이루어져 있음. 아스키코드와 비교해 범위 넘어가면 에러
        for(int i =0 ; i < cryptogram.length() ;i++){
            if(cryptogram.charAt(i) < 97 || cryptogram.charAt(i) > 122){
                return true;
            }
        }
        return false;
    }
}
