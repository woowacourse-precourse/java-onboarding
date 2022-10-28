package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // crytogram와 길이, 값이 일치한 StringBuffer 생성
        StringBuffer sb = getStringBuffer(cryptogram);
        // sb의 중복을 제거하여 반환
        sb = decodeCryptogram(sb);
        // 중복 제거된 cryptogramStringBuffer을 String으로 변환
        answer = sb.toString();
        return answer;
    }

    // String 매개변수와 길이, 값이 일치한 StringBuffer 반환
    private static StringBuffer getStringBuffer(String cryptogarm) {
        StringBuffer sb = new StringBuffer(cryptogram.length());
        sb.append(cryptogram);
        return sb;
    }

    // StringBuffer의 중복을 제거하여 암호해독한 StringBuffer를 반환
    private static StringBuffer decodeCryptogram(StringBuffer cryptogarmStringBuffer) {

    }
}
