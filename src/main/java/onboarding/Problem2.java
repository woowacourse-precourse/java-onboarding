package onboarding;

public class Problem2 {



    public static String solution(String cryptogram) {
        while (endPoint(cryptogram)) {
            cryptogram = deduplication(cryptogram);
        }
        return cryptogram;
    }


    /**
     * [연속 중복 문자 제거]
     * - 입력으로 받은 문자열의 중복 문자를 제거한다.
     * - 제거되지 않은 문자열을 반환한다.
     */
    public static String deduplication(String cryptogram){
        String returnCryptogram = "";
        int cryptogramLen = cryptogram.length();
        if (cryptogramLen == 0) {
            return "";
        }
        if (cryptogram.charAt(0) != cryptogram.charAt(1)) {
            returnCryptogram += cryptogram.charAt(0);
        }
        for (int i=1;i< cryptogramLen-1;i++) {
            if (cryptogram.charAt(i) != cryptogram.charAt(i-1) && cryptogram.charAt(i) != cryptogram.charAt(i+1)){
                returnCryptogram += cryptogram.charAt(i);
            }
        }
        if (cryptogram.charAt(cryptogramLen-1) != cryptogram.charAt(cryptogramLen-2)) {
            returnCryptogram += cryptogram.charAt(cryptogramLen-1);
        }
        return returnCryptogram;
    }

    /**
     * [종료 조건 확인]
     * - 입력받은 문자열에 제거할 문자가 있는지 확인한다.
     * - 계속 진행하는 상황이면 true, 끝났으면 false를 리턴한다.
     */
    public static boolean endPoint(String cryptogram){
        int beforeCryptogramSize = cryptogram.length();
        int afterCryptogramSize = deduplication(cryptogram).length();
        if (beforeCryptogramSize == afterCryptogramSize || beforeCryptogramSize == 0) {
            return false;
        }else {
            return true;
        }
    }
}
