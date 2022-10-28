package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getGameResult(pobi, crong);
        return answer;
    }

    public static int getGameResult(List<Integer> player1, List<Integer> player2) {

        if(identifyException(player1, player2)) return -1;

        int player1Left = calculatePageScoreV1(player1.get(0));
        int player1Right = calculatePageScoreV1(player1.get(1));

        int player2Left = calculatePageScoreV1(player2.get(0));
        int player2Right = calculatePageScoreV1(player2.get(1));


        int player1UltimateScore = Math.max(player1Left, player1Right);
        int player2UltimateScore = Math.max(player2Left, player2Right);

        return player1UltimateScore > player2UltimateScore ? 1 :
                player1UltimateScore == player2UltimateScore ? 0 : 2;
    }

    public static int calculatePageScoreV1(int pageNum) {
        int zeroExistence = 0;
        int temp = pageNum;
        int [] placeValues = {0, 0, 0};

        for(int i = 0; temp > 0; temp /= 10, i++) {
            placeValues[i] = temp % 10;
            if(placeValues[i] == 0)  zeroExistence = 1;
        }

        int result = 0;
        if(zeroExistence == 1)
            return placeValues[0] + placeValues[1] + placeValues[2];

        result = 1;
        for(int i = 0; i < placeValues.length && placeValues[i] != 0; i++)
            result *= placeValues[i];

        return result;

    }

    public static int calculatePageScoreV2(int pageNum) {
        int zeroExistence = 0;
        int temp = pageNum;
        int [] placeValues = {0, 0, 0};
        int result = 1;

        for(int i = 0; temp > 0; temp /= 10, i++) {
            if(temp % 10 == 0 && zeroExistence != 1)  zeroExistence = 2;

            switch(zeroExistence) {
                case(0) :
                    result *= temp % 10;
                    placeValues[i] = temp % 10;
                    break;
                case(1) :
                    result += temp % 10;
                    break;
                case(2) :
                    result = 0;
                    for(int r = 0; r < i; r++)
                        result += placeValues[r];
                    zeroExistence = 1;
            }
        }

        return result;

    }

    public static boolean identifyException(List<Integer> player1, List<Integer> player2) {
        if (player1.size() != 2 || player2.size() != 2) return true;

        int player1Left = player1.get(0);
        int player1Right = player1.get(1);

        int player2Left = player2.get(0);
        int player2Right = player2.get(1);

        return (player1Left % 2 != 1) || (player2Left % 2 != 1) ||
                (player1Right % 2 != 0) || (player2Right % 2 != 0) ||
                (player1Right - player1Left != 1) || (player2Right - player2Left != 1) ||
                (player1Left <= 1) || (player2Left <= 1) ||
                (player1Right >= 400) || (player2Right >= 400);
    }

}