package onboarding;

import java.util.List;

class Problem1 {
    public static int sum(int n) {
        int sum = 0;
        while(n!=0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public static int mul(int n){
        int mul = 1;
        while(n!=0){
            mul *= n%10;
            n /= 10;
        }
        return mul;
    }
    public static int max(int n1, int n2) {
        int n1_max = Math.max(sum(n1), mul(n1));
        int n2_max = Math.max(sum(n2), mul(n2));
        return Math.max(n1_max, n2_max);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        try {
            int n1_pobi = pobi.get(0);
            int n2_pobi = pobi.get(1);
            int n1_crong = crong.get(0);
            int n2_crong = crong.get(1);
            if(n1_pobi != n2_pobi -1 || n1_crong != n2_crong -1) {
                throw new Exception();  //연속된 두 페이지가 아니거나 역순일경우 예외처리
            } else if(n1_pobi <= 1 || n1_crong <= 1) {
                throw new Exception();  // 시작면을 펴거나 그 이하의 수가 나오면 예외처리
            } else if (n2_pobi >= 400 || n2_crong >= 400) {
                throw new Exception();  // 마지막면을 펴거나 그 이상의 수가 나오면 예외처리
            } else if (n1_pobi % 2 == 0 || n1_crong % 2 == 0) {
                throw new Exception();  //왼쪽면이 짝수일 경우 예외 처리
            }

            if(max(n1_pobi, n2_pobi) > max(n1_crong, n2_crong)) {
                answer = 1;
            } else if (max(n1_pobi, n2_pobi) < max(n1_crong, n2_crong)) {
                answer = 2;
            } else {
                answer = 0;
            }

        } catch (Exception e) {
            answer = -1;
        }
        return answer;
    }
}