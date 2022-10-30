package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /*
    * 기능 요구 사항
    * 1. 주어진 문자에서 연속으로 중복된 문자의 인덱스를 반환
    * */

    private static int duplicate_index(String string) {
        for (int index = 0; index < string.length() - 1; index++) {
            if(string.charAt(index) == string.charAt(index + 1)) return index;
        }
        return -1;  // 중복된 문자가 없으면 -1 반환
    }

    /*
     * 기능 요구 사항
     * 2. 주어진 문자에서 연속으로 중복된 문자를 삭제후 반환
     * */

    private static String duplicate_delete(String  string, int index) {
        String duplicate_delete_complete = string.substring(0, index) + string.substring(index + 2);
        return duplicate_delete_complete;
    }

    /*
     * 기능 요구 사항
     * 3. 주어진 문자에서 연속으로 반복된 문자열이 없을 때 까지 반복
     * */
}
