package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decode(cryptogram);
        return answer;
    }

    /**
     * 입력 받은 암호문을 복호화시켜줌
     * @param cryptogram
     * @return String: 복호화된 문자열
     */
    private static String decode(String cryptogram) {
        StringBuilder sbCryptogram = new StringBuilder(cryptogram);
        boolean result;

        do {
            result = removeRepeatChar(sbCryptogram);
        } while (result);

        return sbCryptogram.toString();
    }

    /**
     * 입력 받은 문자열 안에 같은 문자가 연달아 나오는지 확인한다.
     * 만약 존재한다면 연달아 나오는 부분을 삭제하고, true를 반환한다.
     * 그렇지 않으면, false를 반환한다.
     * @param sbCryptogram
     * @return boolean: 연달아 나오는 문자가 존재하여 이를 삭제하여 true를 반환
     */
    private static boolean removeRepeatChar(StringBuilder sbCryptogram) {
        boolean isModified = false;
        char currChar, nextChar;
        for(int i=0;i<sbCryptogram.length() - 1;i++){
            currChar = sbCryptogram.charAt(i);
            nextChar = sbCryptogram.charAt(i+1);
            if(currChar == nextChar){
                sbCryptogram.delete(i, i+2);
                isModified = true;
            }
        }
        return isModified;
    }
}
