package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        // 4. 예외사항에 대한 처리를 한다.
        if (!(Math.abs(pobi.get(0)-pobi.get(1)) == 1 && Math.abs(crong.get(0)-crong.get(1)) == 1)){
            return -1;
        }
        // 1. 포비의 왼쪽 페이지와 오른쪽 페이지에서 나올 수 있는 가장 큰 수 중 더 큰 수를 구한다.
        int pmax_total = 0;
        for (int i = 0; i < 2; i++) {
            String page = Integer.toString(pobi.get(i));
            int addTotal = 0;
            int multiplyTotal = 1;
            int N = page.length();

            for (int j = 0; j < N; j++) {
                char num = page.charAt(j);
                // 더해야 할 때
                addTotal += num - '0';
                // 곱해야 할 때
                multiplyTotal *= num - '0';
            }
            pmax_total = Math.max(pmax_total, addTotal);
            pmax_total = Math.max(pmax_total, multiplyTotal);
        }
        // 2. 크롱도 1과 마찬가지로 가장 큰 수를 구한다.
        int cmax_total = 0;
        for (int i = 0; i < 2; i++) {
            String page = Integer.toString(crong.get(i));
            int addTotal = 0;
            int multiplyTotal = 1;
            int N = page.length();

            for (int j = 0; j < N; j++) {
                char num = page.charAt(j);
                // 더해야 할 때
                addTotal += num - '0';
                // 곱해야 할 때
                multiplyTotal *= num - '0';
            }
            cmax_total = Math.max(cmax_total, addTotal);
            cmax_total = Math.max(cmax_total, multiplyTotal);
        }
        // 3. 포비와 크롱의 점수를 비교해 승, 패, 무승부를 정한다.
        if(pmax_total == cmax_total){
            answer = 0;
        }
        else if(pmax_total > cmax_total){
            answer = 1;
        }
        else if(pmax_total < cmax_total){
            answer = 2;
        }
        return answer;
    }
}