package onboarding;

public class Problem2 {
    /**
     * 기능 구현
     * 1. 무한 루프를 돌려서 인접한 문자가 나오지 않을 때까지 돌린다.
     *      - 인접한 문자가 있으면 flag를 true로 바꾼다.
     * 2. 입력 받은 문자열의 인덱스값으로 문자를 접근하여 인접한 문자와 같은지 비교
     * 3. 같으면 인접한 문자 시작 인덱스까지 자르고, 인접한 문자 끝 인덱스부터 잘라서 합친 값을 answer에 담는다.
     * 4. 인접한 문자가 있었는지 flag 값을 비교하고, 없으면 무한 루프를 멈춘다.
     */
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 1.
        while (true) {
            boolean flag = false;
            // 2.
            for (int i = 0; i < answer.length() - 1; i++) {
                // 3.
                if (answer.charAt(i) == answer.charAt(i+1)) {
                    answer = answer.substring(0, i) + answer.substring(i + 2);
                    flag = true;
                    break;
                }
            }
            // 4.
            if (!flag) break;
        }

        return answer;
    }
}
