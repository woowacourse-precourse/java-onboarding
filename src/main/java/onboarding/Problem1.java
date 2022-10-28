package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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

}