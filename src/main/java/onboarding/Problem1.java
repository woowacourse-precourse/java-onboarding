package onboarding;

import problem1.*;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        JudgeException judgeException = new JudgeException();

        Integer firstPage = 1;
        Integer LastPage = 400;

        boolean isPobiException = judgeException.judgeException(pobi);
        boolean isCrongException = judgeException.judgeException(crong);

        if(isPobiException || isCrongException) {
            answer = -1;
        }else {
            CalPage plusPage = new PlusPage();
            CalPage mulPage = new MulPage();
            CalUserPage calUserPage = new CalUserPage();

            Integer maxPobi = Integer.MIN_VALUE;
            Integer maxCrong = Integer.MIN_VALUE;

            for(Integer e : pobi) {
                Integer plusPobiPage = calUserPage.calUserPage(plusPage, e);
                Integer mulPobiPage = calUserPage.calUserPage(mulPage, e);

                maxPobi = (maxPobi > plusPobiPage) ? maxPobi : plusPobiPage;
                maxPobi = (maxPobi > mulPobiPage) ? maxPobi : mulPobiPage;
            }

            for(Integer e : crong) {
                Integer plusCrongPage = calUserPage.calUserPage(plusPage, e);
                Integer mulCrongPage = calUserPage.calUserPage(mulPage, e);

                maxCrong = (maxCrong > plusCrongPage) ? maxCrong : plusCrongPage;
                maxCrong = (maxCrong > mulCrongPage) ? maxCrong : mulCrongPage;
            }

            if (maxPobi > maxCrong) {
                answer = 1;
            }else if(maxPobi < maxCrong) {
                answer = 2;
            }else {
                answer = 0;
            }
        }

        return answer;
    }

}