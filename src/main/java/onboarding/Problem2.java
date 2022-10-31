package onboarding;

/**
 * Programs should be written for people to read, and only incidentally for machine to execute
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
        StringBuffer decryptionText = new StringBuffer(); // 순서에 따라 해독된 cryptogram이 담길 stringBuffer
        boolean isClear = true; // 재귀 종료를 판별할 변수
        char prevChar = ' '; // 반복문에서 이전 단어를 저장할 previousChar 변수
        for(char ch : chars){
            if(ch != prevChar){ // 연속되지 않다면 stringBuffer 에 저장
                prevChar = ch;
                decryptionText.append(ch);
            }
            else{ // previousChar 과 currentChar 이 같다면 연속된 것으로 판별. currentChar 저장하지 않고 previousChar 도 삭제해준다.
                decryptionText = removeContinuous(decryptionText);
                isClear = false;
            }
        }
        if(isClear){ // 연속된 것을 제거해야하는 상황이 판별되지 않을 시 재귀를 끝냄
           return decryptionText.toString();
        }
        return decoding(decryptionText.toString());
    }

    /**
     * 연속된 값 제거를 위한 함수
     */

    private static StringBuffer removeContinuous(StringBuffer decryptionText){
        int duplicateCharIndex = decryptionText.length() - 1; // 연속됨이 판별되면 마지막으로 저장한 값 제거
        return decryptionText.deleteCharAt(duplicateCharIndex);
    }




}
