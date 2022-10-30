package onboarding;

/**
 * Programs should be written for people to read, and only incidectally for machine to execute
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decoding(cryptogram);
        return answer;
    }

    /**
     * 문제 요구사항에 따라 재귀적으로 중복을 제거해 나간다.
     * 반복문의 수를 줄여 코드의 가독성을 높인다.
     */

    private static String decoding(String cryptogram){
        char[] chars = cryptogram.toCharArray();
        StringBuffer decryptionText = new StringBuffer();
        boolean isClear = true;
        char prevChar = ' ';
        for(char ch : chars){
            if(ch != prevChar){
                prevChar = ch;
                decryptionText.append(ch);
            }
            else{
                int duplicateCharIndex = decryptionText.length() - 1;
                decryptionText.deleteCharAt(duplicateCharIndex);
                isClear = false;
            }
        }
        if(isClear){
            return decryptionText.toString();
        }
        return decoding(decryptionText.toString());
    }


}
