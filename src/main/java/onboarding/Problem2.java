package onboarding;

public class Problem2 {

    public static String removeTextDuplication(String cryptogram) {

        String result;

        /* String -> StringBuilder 형변환 */
        StringBuilder crypto = new StringBuilder();
        crypto.append(cryptogram);

        while (hasTextDuplication(crypto)) {    // 중복 문자가 있다면 다시 반복

            int len = crypto.length(); // 문자열 길이 갱신

            for (int i = 0; i < len - 1; i++){

                // 현재 인덱스와 다음 인덱스 중복 비교
                if (crypto.charAt(i) == crypto.charAt(i + 1)) {
                    crypto.delete(i, i + 2);    // 중복 구간 삭제(i <= interval < i + 2)
                    break;
                }

            }
        }

        // 중복 제거된 문자열 저장 String 객체로 변환
        result = crypto.toString();

        return result;

    }

    public static boolean hasTextDuplication(StringBuilder crypto) {

        int len = crypto.length();

        for (int i = 0; i < len - 1; i++) {

            // 현재 위치와 다음 위치의 문자가 같을 경우 중복
            if (crypto.charAt(i) == crypto.charAt(i + 1)) {
                    return true;
            }
        }

        return false;

    }

    public static String solution(String cryptogram) {

        String answer = "answer";
        answer = removeTextDuplication(cryptogram);

        return answer;
    }

    public static void main(String[] args) {
        String result = solution("browoanoommnaon");
        System.out.println(result);
    }
}
