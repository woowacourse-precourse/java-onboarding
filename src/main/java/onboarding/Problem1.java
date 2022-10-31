package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 첫 페이지 혹은 마지막 페이지 혹은 범위를 벗어나는 페이지를 선택했을 시 에러처리
        if(Math.min(pobi.get(0), crong.get(0))<=0 && Math.max(pobi.get(1), crong.get(1))>=400){
            return -1;
        }

        // 연속되는 페이지를 선택하였을 시 로직 실행
        if(pobi.get(0) == pobi.get(1)-1 && crong.get(0) == crong.get(1)-1){
            int pobiMax = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
            int crongMax = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));

            if(pobiMax == crongMax) return 0;
            return (pobiMax > crongMax) ? 1 : 2;
        }else{
            return -1;
        }
    }

    public static int findMaxNum(int n) {
        int add = n % 10;
        int mul = n % 10;
        n /= 10;

        while(n > 0) {
            int temp = n % 10;
            add += temp;
            mul *= temp;
            n /= 10;
        }

        return Math.max(add, mul);
    }
}