package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /**
     * 문장을 청개구리 사전으로 변환
     * @param word : 변환할 문장
     * @return 변환된 문장
     */
    private static String getChangedWord(String word){
        // 결과 변수 초기화
        String result = "";
        // 각 글자마다 청개구리 사전으로 변환
        for (int index = 0; index < word.length(); index ++){
            result += getChangedChar(word.charAt(index));
        }
        return result;
    }

    /**
     * 글자를 청개구리 사전으로 변환
     * @param letter : 변환할 글자
     * @return 변환된 글자
     */
    private static char getChangedChar(char letter){

    }
}
