package onboarding;

/**
 * 객체지향적으로 변환하기
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Problem4 pro = new Problem4();
        // 문제로 온 문자열을 바이트 배열로 한자리씩 구분한다.
        byte[] wordToBytes = word.getBytes();

        for (int i = 0; i < wordToBytes.length; i++) {
            wordToBytes[i] = pro.playGreenFrog(wordToBytes[i]);
        }
        answer = new String(wordToBytes);

        return answer;
    }

    // 청개구리 짓 하기!
    public byte playGreenFrog(byte data) {
        byte result = data; // 각 자리 문자열의 아스키코드 값을 넣는다.
        if (97 <= data && data <= 122) { // data가 소문자 아스키 값일 경우
            int no = data - 96; // 알파벳의 순서를 구한다. a = 1번째
            result = (byte) (123 - no); // 역순으로 청개구리 짓을 하기 위해 알파벳 순서를 z번째에서 부터 구한다

        } else if (65 <= data && data <= 90) { // data가 대문자 아스키 값일 경우
            int no = data - 64; // 알파벳의 순서를 구한다. A = 1번째
            result = (byte) (91 - no); // 역순으로 청개구리 짓을 하기 위해 알파벳 순서를 Z번째에서 부터 구한다
        }
        return result;
    }
}
