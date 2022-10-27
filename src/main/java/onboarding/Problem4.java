package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 입력받은 문자열을 어절 단위로 자름
        
        // 변환하기

        // 변환된 문자열 만들기

        return answer;
    }

    /**
     * 청개구리 사전 기준으로 문자 변환하는 메소드
     * @param c
     * @return 변환된 문자를 반환
     */
    static char changeChar(char c){
        int asci = (int)c;
        int changeNum = 155 - asci;
        char result = (char) changeNum;

        return result;
    }
}
