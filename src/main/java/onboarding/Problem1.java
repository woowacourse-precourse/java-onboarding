package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiRes, crongRes;

        if (!isBookPageViable(pobi) || !isBookPageViable(crong)) {
            return -1;
        }

        pobiRes = getLargestNum(pobi);
        crongRes = getLargestNum(crong);

        if (pobiRes == crongRes) {
            return 0;
        }

        if (pobiRes > crongRes) {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean isBookPageViable(List<Integer> bookPage) {
        //  왼쪽 페이지가 짝수 일경우 스킵
        if (bookPage.get(0) % 2 != 1) {
            return false;
        }

        //  오른쪽 페이지가 왼쪽페이지의 차이가 1이 아닐경우 스킵
        if (bookPage.get(1) - bookPage.get(0) != 1) {
            return false;
        }

        //  왼쪽 페이지가 첫 페이지 이거나, 오른쪽 페이지가 마지막 페이지일 경우 스킵
        if (bookPage.get(0) == 1 || bookPage.get(1) == 400) {
            return false;
        }

        return true;
    }

    public static int getLargestNum(List<Integer> bookPage) {
        int largestNum = 0, leftAdd = 0, leftMul = 1, rightAdd = 0, rightMul = 1;
        List<Integer> leftElement = new ArrayList<>(), rightElement = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();

        leftElement = getPageElement(bookPage.get(0));
        rightElement = getPageElement(bookPage.get(1));

        for (int num :
                leftElement) {
            leftAdd += num;
            leftMul *= num;
        }

        for (int num :
                rightElement) {
            rightAdd += num;
            rightMul *= num;
        }

        holder.add(leftAdd);
        holder.add(leftMul);
        holder.add(rightAdd);
        holder.add(rightMul);

        return holder.stream().mapToInt(Integer::intValue).max().orElseThrow();
    }

    public static List<Integer> getPageElement(int page) {
        int holder = page;
        int mod10 = 0;
        List<Integer> result = new ArrayList<>();

        while (holder > 0) {
            mod10 = holder % 10;
            holder /= 10;
            result.add(mod10);
        }

        return result;
    }
}