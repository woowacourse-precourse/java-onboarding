package onboarding;

public class Problem2 {
    /**
     * 기능 구현
     * 1. 입력받은 문자열을 배열로 만든다.
     * 2. 배열을 돌며 연속한 문자들은 ' '로 치환한다.
     * 3. 배열을 문자열로 붙인 다음, ' '은 없앤 결과값을 리턴한다.
     */
    public static String solution(String cryptogram) {
        String answer = "";

        // 1.
        char[] arr = cryptogram.toCharArray();

        // 2.
        while (true) {
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[i+1]) {
                    arr[i] = ' ';
                    arr[i + 1] = ' ';
                    flag = true;
                }
            }
            if (!flag) break;
        }


        return answer;
    }
}
