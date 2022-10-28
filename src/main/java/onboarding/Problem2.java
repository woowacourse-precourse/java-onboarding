package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // crytogram와 길이, 값이 일치한 StringBuffer 생성
        StringBuffer sb = getStringBuffer(cryptogram);
        // sb의 중복을 제거
        decodeCryptogram(sb);
        // 중복 제거된 cryptogramStringBuffer을 String으로 변환
        answer = sb.toString();
        return answer;
    }

    /* String 매개변수와 길이, 값이 일치한 StringBuffer 반환 */
    private static StringBuffer getStringBuffer(String cryptogarm) {
        StringBuffer sb = new StringBuffer(cryptogram.length());
        sb.append(cryptogram);
        return sb;
    }

    /* StringBuffer의 중복을 제거하는 메서드 */
    private static void decodeCryptogram(StringBuffer cryptogarmStringBuffer) {
        // 중복이 없을 때까지 중복을 찾아 제거하는 함수 실행
        do {
            // 특정 인덱스의 char와 연속된 중복을 찾아 제거
            boolean isRemoved = removeDuplication(cryptogarmStringBuffer);
        } while(isRemoved == true) // 더이상 중복이 제거되지 않으면 while문 종료
        return;
    }

    private static boolean removeDuplication(StringBuffer cryptogarmStringBuffer);

}
