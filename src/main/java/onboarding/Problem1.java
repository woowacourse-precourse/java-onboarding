package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        // 1. 포비의 왼쪽 페이지와 오른쪽 페이지에서 나올 수 있는 가장 큰 수 중 더 큰 수를 구한다.
        int pmax_total = 0;
        for (int i = 0; i < 2; i++) {
            String page = Integer.toString(pobi.get(i));
            int total = 0;
            int N = page.length();
            for (int j = 0; j < N; j++) {
                char num = page.charAt(j);
                // 더해야 할 때
                if (total <= 1 || num == '0' || num == '1') {
                    total += num - '0';
                }
                // 곱해야 할 때
                else {
                    if (total == 0) {
                        total = 1;
                    }
                    total *= num - '0';
                }
            }
            System.out.println(total);
            pmax_total = Math.max(pmax_total, total);
        }
        // 2. 크롱도 1과 마찬가지로 가장 큰 수를 구한다.
        int cmax_total = 0;
        for (int i = 0; i < 2; i++) {
            String page = Integer.toString(crong.get(i));
            int total = 0;
            int N = page.length();
            for (int j = 0; j < N; j++) {
                char num = page.charAt(j);
                // 더해야 할 때
                if (total <= 1 || num == '0' || num == '1') {
                    total += num - '0';
                }
                // 곱해야 할 때
                else {
                    if (total == 0) {
                        total = 1;
                    }
                    total *= num - '0';
                }
            }
            System.out.println(total);
            cmax_total = Math.max(cmax_total, total);
        }
        return answer;
    }
}