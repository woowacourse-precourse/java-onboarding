package onboarding;

// 중복된 문자열 검사
// 어렵다...
public class Problem2 {

    public static String overlapRemover(String cryptogram) {
        // delete 를 위한 StringBuilder 메서드로 입력 문자열 치환
        StringBuilder cryptogramStringBuilder = new StringBuilder(cryptogram);

        // 문자열 접근을 위한 인덱스
        int i = 0;

        // 암호 문자열 길이 -1 까지 반복한다. (인덱스 + 1 을 하기 때문에 -1 까지 반복하는 것임)
        while (i < cryptogramStringBuilder.length() - 1) {

            // 인덱스 0, 1 쌍을 시작으로하여 순차적으로 비교를 시작한다. 그 값이 같을경우 제거 로직 시작
            if (cryptogramStringBuilder.charAt(i) == cryptogramStringBuilder.charAt(i + 1)) {
                // 중복 시작 인덱스 (현재 순회중인 인덱스로 초기화한다.)
                int overlapStartIndex = i;
                // 중복 종료 인덱스 (현재 순회중인 인덱스 + 1 로 초기화한다.)
                int overlapEndIndex = i + 1;

                // 중복 검사 대상을 위한 인덱스가 문자열의 최대 길이 보다 크지 않을때 까지 반복
                while (overlapEndIndex + 1 < cryptogramStringBuilder.length()) {
                    // 중복 종료 인덱스의 값과 그 다음 값이 일치하면 중복 종료 인덱스 + 1
                    if (cryptogramStringBuilder.charAt(overlapEndIndex) ==
                            cryptogramStringBuilder.charAt(overlapEndIndex + 1)) {
                        overlapEndIndex += 1;
                    }
                    // 중복 종료 인덱스 값과 그 다음 값이 일치하지 않으면 중복 종료 인덱스 셋팅 끝
                    else if (cryptogramStringBuilder.charAt(overlapEndIndex) !=
                            cryptogramStringBuilder.charAt(overlapEndIndex + 1)) {
                        break;
                    }
                }
                // 중복 문자열 제거 후 처음 인덱스 부터 다시 검사
                cryptogramStringBuilder.delete(overlapStartIndex, overlapEndIndex + 1);
                i = 0;
            }
            // 중복된 문자가 없으면 다음 문자로 넘어가기
            else if (cryptogramStringBuilder.charAt(i) != cryptogramStringBuilder.charAt(i + 1)) {
                i += 1;
            }
        }
        return cryptogramStringBuilder.toString();
    }

    public static String solution(String cryptogram) {
        return overlapRemover(cryptogram);
    }
}
