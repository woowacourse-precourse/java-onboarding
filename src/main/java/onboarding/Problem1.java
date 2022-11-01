package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2) return getException("리스트의 요소가 2가 아닙니다.");
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if(!isInRange(pobiLeft) || !isInRange(pobiRight) || !isInRange(crongLeft)
                || !isInRange(crongRight)) return getException("페이지의 범위가 1~400이 아닙니다.");;

        if(pobiLeft % 2 != 1 || crongLeft % 2 != 1) return getException("왼쪽 페이지가 홀수가 아닙니다.");;

        if(pobiRight != pobiLeft + 1 || crongRight != crongLeft + 1) return getException("오른쪽 페이지가 왼쪽의 다음 페이지가 아닙니다.");;

        int pobiScore = Integer.max(getMaxScore(pobiLeft), getMaxScore(pobiRight));
        int crongScore = Integer.max(getMaxScore(crongLeft), getMaxScore(crongRight));
        System.out.println("pobi: " + pobiScore + " crong: " + crongScore);

        if(pobiScore == crongScore) return 0;
        if(pobiScore > crongScore) return 1;
        else return 2;
    }

    static int getException(String message){
        System.out.println(message);
        return -1;
    }

    static boolean isInRange(int value) {
        return value > MIN_PAGE && value < MAX_PAGE;
    }

    static int getMaxScore(Integer page) {
        List<Integer> newList = new ArrayList<>();
        int num = page;
        while (num > 0) {
            newList.add(num % 10);
            num /= 10;
        }
        int sum = 0;
        int duplecate = 1;
        for(int i : newList) {
            sum += i;
            duplecate *= i;
        }
        return sum >= duplecate ? sum : duplecate;
    }
}