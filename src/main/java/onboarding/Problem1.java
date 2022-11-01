package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobyScore = maxScore(pobi);
        int crongScore = maxScore(crong);

        if(pobyScore == -10 || crongScore == -10)
            answer = -1;
        else
            answer = winResult(pobyScore, crongScore);

        return answer;
    }

    public static int maxScore(List<Integer> name) {

        if (name.get(0)%2==0 || name.get(1)%2==1)
            return -10;
         else if (name.get(0)<1 || name.get(0)>400 || name.get(1)<1 || name.get(1)>400)
            return -10;
         else if (name.get(0)+1 != name.get(1))
            return -10;
         else if (name.size()>2)
             return -10;

        int leftMaxScore = 0;
        int rightMaxScore = 0;

        for (int page = 0; page < 2; page++) {
            int pageNumber = name.get(page);
            int sum = 0;
            int multi = 1;

            while (pageNumber > 0) {
                sum += pageNumber % 10;
                multi *= pageNumber % 10;
                pageNumber /= 10;
            }

            if (sum > multi)
                leftMaxScore = sum;
            else
                rightMaxScore = multi;
        }

        if (leftMaxScore > rightMaxScore)
            return leftMaxScore;

        return rightMaxScore;
    }

    public static int winResult(int poby, int crong) {
        if (poby > crong)
            return 1;
        else if (crong < poby)
            return 2;

        return 0;
    }
}