package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // validation
        if (pobi.get(0) + 1 != pobi.get(1) || pobi.get(0) % 2 != 1) { // 포비 페이지차이가 1이 맞는지, 왼쪽이 홀수 맞는지
            return -1;
        } else if (crong.get(0) + 1 != crong.get(1) || crong.get(0) % 2 != 1) { // 크롱 페이지차이가 1이 맞는지, 왼쪽이 홀수 맞는지
            return -1;
        }

        int pobi1 = cal(pobi.get(0));
        int pobi2 = cal(pobi.get(1));
        int crong1 = cal(crong.get(0));
        int crong2 = cal(crong.get(1));
        // 포비 크롱의 각 최대값
        int large_pobi = (pobi1 > pobi2) ? pobi1 : pobi2;
        int large_crong = (crong1 > crong2) ? crong1 : crong2;

        // 포비 크롱 크기 비교
        if (large_pobi > large_crong) {
            answer = 1;
        } else if (large_pobi < large_crong) {
            answer = 2;
        } else if (large_pobi == large_crong) {
            answer = 0;
        } else {
            answer = -1;
        }
        return answer;
    }

    // 페이지가 합이큰지 곱이큰지 구해주는 함수
    public static int cal(Integer num) {
        int result = 0;
        int sum = num % 10;
        int mul = num % 10;
        while (num / 10 != 0) {
            num = num / 10;
            sum += num % 10;
            mul *= num % 10;
        }
        result = (sum > mul) ? sum : mul;
        return result;
    }
}