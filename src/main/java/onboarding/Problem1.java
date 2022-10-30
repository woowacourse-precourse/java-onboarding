package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        System.out.println(pobi.get(0));
        System.out.println(pobi.get(1));
        System.out.println(crong.get(0));
        System.out.println(crong.get(1));
        // 포비와 크롱의 페이지가 잘못되었을 경우 -1리턴
        if (pobi.get(0) + 1 != pobi.get(1) || pobi.get(0) % 2 == 0) {
            System.out.println(-1);
            return -1;
        }
        if (crong.get(0) + 1 != crong.get(1) || crong.get(0) % 2 == 0) {
            System.out.println(-1);
            return -1;
        }

        int pobimax = 0, crongmax = 0;
        int tmp;

        // 포비 페이지 번호의 각 자리 수를 모두 더하기
        tmp = 0;
        for (int num = pobi.get(0); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (pobimax < tmp) {
            pobimax = tmp;
        }
        tmp = 0;
        for (int num = pobi.get(1); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (pobimax < tmp) {
            pobimax = tmp;
        }
        // 포비 페이지 번호의 각 자리 수를 모두 곱하기
        tmp = 1;
        for (int num = pobi.get(0); num > 0; num /= 10) {
            tmp *= num % 10;
        }
        if (pobimax < tmp) {
            pobimax = tmp;
        }
        tmp = 1;
        for (int num = pobi.get(1); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (pobimax < tmp) {
            pobimax = tmp;
        }

        // 크롱 페이지 번호의 각 자리 수를 모두 더하기
        tmp = 0;
        for (int num = crong.get(0); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (crongmax < tmp) {
            crongmax = tmp;
        }
        tmp = 0;
        for (int num = crong.get(1); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (crongmax < tmp) {
            crongmax = tmp;
        }
        // 크롱 페이지 번호의 각 자리 수를 모두 곱하기
        tmp = 1;
        for (int num = crong.get(0); num > 0; num /= 10) {
            tmp *= num % 10;
        }
        if (crongmax < tmp) {
            crongmax = tmp;
        }
        tmp = 1;
        for (int num = crong.get(1); num > 0; num /= 10) {
            tmp += num % 10;
        }
        if (crongmax < tmp) {
            crongmax = tmp;
        }
        if (pobimax > crongmax) {
            System.out.println(1);
            return 1;
        } else if (pobimax < crongmax) {
            System.out.println(2);
            return 2;
        } else {
            System.out.println(0);
            return 0;
        }
    }
}