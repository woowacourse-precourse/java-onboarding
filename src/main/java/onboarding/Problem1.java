package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        boolean pobiValidate = checkValidate(pobi);
        boolean crongValidate = checkValidate(crong);
        if (pobiValidate == false || crongValidate==false) {
            return answer;
        }

        int pobiLeftScore = getScore(pobi.get(0));
        int pobiRightScore = getScore(pobi.get(1));
        int crongLeftScore = getScore(crong.get(0));
        int crongRightScore =getScore(crong.get(1));

        int pobiScore = Math.max(pobiLeftScore, pobiRightScore);
        int crongScore = Math.max(crongLeftScore, crongRightScore);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    public static boolean checkValidate(List<Integer> pageList) {

        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (leftPage<=0 || rightPage>=401) {
            return false;
        } else if (leftPage+1 != rightPage) {
            return false;
        } else if (leftPage % 2 != 1) {
            return false;
        }
        return true;
    }

    public static int getScore(int page) {
        int plusScore = 0;
        int multiScore = 1;

        String strPage = Integer.toString(page);
        for (int i = 0; i<strPage.length(); i++) {
            plusScore += Integer.parseInt(strPage.substring(i,i+1));
            multiScore *= Integer.parseInt(strPage.substring(i,i+1));
        }

        return Math.max(plusScore,multiScore);
    }


}