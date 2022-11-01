package onboarding;

/**
 * 기능목록
 * 1. 중복된 문자 유,무를 찾는 기능
 * 2. 1에서 중복된 문자가 있을 시 해당 문자를 삭제하는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while (findDuplication(cryptogram)) {

        }
        return answer;
    }

    /**
     * 기능 1
     * @param check
     * @return 중복된 문자가 있으면 true, 없으면 false
     */
    private static boolean findDuplication(String check) {
        for (int i = 0; i < check.length(); i--) {
            if (check.charAt(i) == check.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
