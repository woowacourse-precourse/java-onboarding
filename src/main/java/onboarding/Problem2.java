package onboarding;

public class Problem2 {

    public static String overlapRemover(String cryptogram) {

        // 문자열 처리의 편의를 위하여 StringBuilder 로 치환하였다.
        StringBuilder cryptogramStringBuilder = new StringBuilder(cryptogram);

        // 문자열 길이만큼 반복한다. (단, 인덱스 + 1 비교하는 구문이 있으므로 문자열 길이의 -1 까지 비교한다.)
        for (int i = 0; i < cryptogramStringBuilder.length() - 1; i++) {
            // 문자열 중복 시작 인덱스 (삭제 대상 시작을 가리킨다.)
            int overlapStartIndex = 0;
            // 문자열 중복 종료 인덱스 (삭제 대상 종료를 가리킨다.)
            int overlapEndIndex = 0;

            // (인덱스 i) 와 (인덱스 i + 1) 의 값이 일치하면
            if (cryptogramStringBuilder.charAt(i) == cryptogramStringBuilder.charAt(i + 1)) {
                // 중복 시작 인덱스 기록
                overlapStartIndex = i;
                // 중복 종료 인덱스 기록
                overlapEndIndex = overlapStartIndex + 1;

                // 중복된 인덱스 이후로 추가적으로 중복된 문자열이 있는지 확인하기 위해 반복문을 수행한다.
                for (int j = overlapEndIndex; j < cryptogramStringBuilder.length() - 2; j++) {
                    // (중복 시작 인덱스)와 (중복 종료 인덱스 + 1) 을 비교한다.
                    // 그 값이 같으면 중복 종료 인덱스를 + 1 한다.
                    if (cryptogramStringBuilder.charAt(j) == cryptogramStringBuilder.charAt(j + 1)) {
                        overlapEndIndex = j + 1;
                    }
                }
                // Delete 범위는 start <= 삭제대상범위 < end 이므로 +1 추가해준다.
                cryptogramStringBuilder.delete(overlapStartIndex, overlapEndIndex + 1);

                // 재귀하여 현재 제거된 문자열을 다시 한 번 검사한다.
                return overlapRemover(cryptogramStringBuilder.toString());
            }
        }

        // 반복문 및 반복분 내의 조건에 맞지 않는 시점이 오면 중복 제거가 끝난 것이다.
        return cryptogramStringBuilder.toString();
    }

    public static String solution(String cryptogram) {
        return overlapRemover(cryptogram);
    }
}
