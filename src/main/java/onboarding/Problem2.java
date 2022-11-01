package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 조건에 해당되는 알파벳 모음을 삭제하는 함수 deleteAlphabet()

        // immutable한 cryptogram 대신 가변적인 StringBuffer class인 cryptogram_buffer 사용
        StringBuffer cryptogram_buffer = new StringBuffer(cryptogram);

        deleteAlphabet(cryptogram_buffer);

        return cryptogram_buffer.toString();
    }

    public static void deleteAlphabet(StringBuffer stringBuffer) {

        int res = 0;
        int length = stringBuffer.length();

        while (res < length - 1 && length > 0) {

            if (stringBuffer.charAt(res) == stringBuffer.charAt(res + 1)) {
                stringBuffer.delete(res, res + 2);
                res = 0;
                length = stringBuffer.length();
                continue;
            }

            res += 1;
        }
    }
}
