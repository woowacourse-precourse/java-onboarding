package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);   //문자열을 다루기 위한 StringBuilder 이용

        String firstIndexStr = answer.substring(0, 1); // 바로 이전의 문자를 저장

        for (int i = 1; i < answer.length(); i++) {
            if (answer.length() == 0) {
                break;
            }

            String secondIndexStr = answer.substring(i, i + 1);

            if (firstIndexStr.equals(secondIndexStr)) { // 바로 이전의 문자와 현재의 문자가 같다면, 그 이후의 연속된 문자도 탐색하기 시작
                i = deleteDuplicatedStr(answer, i, secondIndexStr);
            } else {
                firstIndexStr = secondIndexStr;
            }

        }

        return answer.toString();
    }

    /**
     * 연속되어 중복된 부분을 체크하고 삭제한다.
     * @param answer
     * @param i
     * @param secondIndexStr
     * @return
     */
    private static int deleteDuplicatedStr(StringBuilder answer, int i, String secondIndexStr) {
        int j = i;
        for (; j < answer.length(); j++) {
            if (!secondIndexStr.equals(answer.substring(j, j + 1))) {   // 문자가 일치하지 않는다면 탐색중지
                break;
            }
        }
        answer.delete(i - 1, j);    // 중복된 문자를 지운다.
        return i - 3;        // 삭제한 첫 부분의 바로 뒤로 돌아간다.
    }


}
