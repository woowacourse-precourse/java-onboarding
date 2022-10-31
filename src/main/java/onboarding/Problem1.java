package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if (isNormal(pobi) && isNormal(crong))
            switch (getMax(pobi).compareTo(getMax(crong))) {
                case -1: // getMax(pobi) < getMax(crong)
                    answer = 2;
                    break;
                case 0: // getMax(pobi) == getMax(crong)
                    answer = 0;
                    break;
                case 1: // getMax(pobi) > getMax(crong)
                    answer = 1;
                    break;
            }
        return answer;
    }

    private static boolean isNormal(List<Integer> pages) {
        if (pages.get(0) + pages.get(1) < 2 || pages.get(0) + pages.get(1) > 800) return false;
        if (pages.get(0) - pages.get(1) != -1) return false;
        if (pages.get(0) % 2 == 0) return false;
        return true;
    }

    private static Integer getMax(List<Integer> pages) {
        Integer left = getAddition(pages.get(0)) > getMultiple(pages.get(0)) ?
                getAddition(pages.get(0)) : getMultiple(pages.get(0));
        Integer right = getAddition(pages.get(1)) > getMultiple(pages.get(1)) ?
                getAddition(pages.get(1)) : getMultiple(pages.get(1));
        return left.intValue() > right.intValue() ?
                Integer.valueOf(left.intValue()) : Integer.valueOf(right.intValue());
    }

    private static Integer getAddition(int num) { // 자릿수의 합 return
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return Integer.valueOf(sum);
    }

    private static Integer getMultiple(int num) { // 자릿수의 곱 return
        int sum = 1;
        while (num != 0) {
            sum *= (num % 10);
            num /= 10;
        }
        return Integer.valueOf(sum);
    }

}