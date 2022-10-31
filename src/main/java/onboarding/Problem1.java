package onboarding;

import onboarding.domain.problem1.Person;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return getAnswer(pobi, crong);
    }

    private static int getAnswer(List<Integer> pobiPage, List<Integer> crongPage) {
        int answer = -1;
        try {
            Person pobi = new Person(pobiPage);
            Person crong = new Person(crongPage);
            int pobiValue = pobi.getLargeValue();
            int crongValue = crong.getLargeValue();
            if (pobiValue > crongValue)
                answer = 1;
            else if (pobiValue < crongValue)
                answer = 2;
            else if (pobiValue == crongValue)
                answer = 0;
        } catch (IllegalArgumentException e) {
            answer = -1;
        }
        return answer;
    }
}