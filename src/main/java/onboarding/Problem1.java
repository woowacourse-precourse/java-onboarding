package onboarding;

import java.util.List;

class Problem1 {
    /**
     * todo 예외처리
     * 2. pobi, crong 배열 길이
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(exception(pobi) || exception(crong))
            return -1;

//        int max_pobi = game(pobi);
//        int max_crong = game(crong);
//
//        if (max_pobi > max_crong) answer = 1;
//        else if (max_pobi < max_crong) answer = 2;
//        else answer = 0;

        return answer;
    }

//    // 왼쪽 페이지 연산 결과의 최댓값과 오른쪽 페이지 연산 결과의 최댓값 중 큰 값을 리턴
//    public static int game(List<Integer> player) {
//        int odd = player.get(0);
//        int even = player.get(1);
//
//        return Math.max(calc(odd), calc(even));
//    }
//
//    // 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
//    public static int calc(int num) {
//        int add = 0, multiply = 1;
//        while(num != 0) {
//            add += num % 10;
//            multiply *= num % 10;
//            num /= 10;
//        }
//        return Math.max(add, multiply);
//    }

    public static boolean exception(List<Integer> player) {
        int odd = player.get(0);
        int even = player.get(1);

        if(odd < 1 || odd > 400 || even < 1 || even > 400) return true; // 페이지 번호 범위(1~400) 벗어남
        if(odd > even) return true; // 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 큼
        if(odd % 2 != 1) return true; // 왼쪽 페이지 번호가 홀수값이 아님
        if(even % 2 != 0) return true; // 오른쪽 페이지 번호가 짝수값이 아님
        if(even - odd != 1) return true; // 연속된 페이지 번호가 아님
        if(odd == 1 || even == 400) return true; // 시작 면이나 마지막 면 제외

        return false;
    }
}