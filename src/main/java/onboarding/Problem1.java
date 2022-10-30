package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int WRONG_INPUT = -1;
        final int TIE = 0;
        final int POBI_WINS = 1;
        final int CRONG_WINS = 2;

        List[] players = {pobi, crong};
        for(List<Integer> player: players) {
            int left = player.get(0);
            int right = player.get(1);

            if (right - left != 1 || right % 2 != 0 || left % 2 != 1 || right > 399 || left < 2) {
                return WRONG_INPUT;
            }
        }




        int answer = Integer.MAX_VALUE;
        return answer;
    }
}