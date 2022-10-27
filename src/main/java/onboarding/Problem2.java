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

        int beginIndex = getRepeatCharacterBeginIndex(sbCryptogram);

        while(beginIndex != -1){
            sbCryptogram.delete(beginIndex, beginIndex + 2); // 오른쪽 범위를 포함해야하기 때문에, +2을 해줌
            beginIndex = getRepeatCharacterBeginIndex(sbCryptogram);
        }

        return sbCryptogram.toString();
    }

    /**
     * 입력 받은 문자열 안에 같은 문자가 연달아 나오는지 확인한다.
     * 만약 존재한다면 시작 부분의 index를 반환한다.
     * 그렇지 않다면, null을 반환한다.
     * @param sbCryptogram
     * @return int: 연달아 문자가 나오는 시작점 index, 그렇지 않다면 -1
     */
    private static int getRepeatCharacterBeginIndex(StringBuilder sbCryptogram) {
        char currChar, nextChar;
        for(int i=0;i<sbCryptogram.length() - 1;i++){
            currChar = sbCryptogram.charAt(i);
            nextChar = sbCryptogram.charAt(i+1);
            if(currChar == nextChar){
                return i;
            }
        }
        return -1;
    }
}
