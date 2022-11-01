package onboarding.problem3;

public class Game {

    public static int getHandsClapCount(int maximumNum) {
        int cnt = 0;

        for(int num = 1; num <= maximumNum; num++) {
            int tempNum = num;

            while(tempNum > 0) {
                int subNum = tempNum % 10;
                if(subNum == 3 || subNum == 6 || subNum == 9) cnt++;
                tempNum /= 10;
            }
        }

        return cnt;
    }
}
