package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        // 예외조건 보내기
        if(check_except(pobi, crong) == -1) return -1;

        int L_sum = 0;
        int L_mult = 0;
        int L_score = 0;
        int R_sum = 0;
        int R_mult = 0;
        int R_score = 0;

        int P_score = 0;
        int C_score = 0;

        //pobi 점수계산
        L_sum = summ(pobi.get(0));
        L_mult = mult(pobi.get(0));
        R_sum = summ(pobi.get(1));
        R_mult = mult(pobi.get(1));
        L_score = Math.max(L_sum, L_mult);
        R_score = Math.max(R_sum, R_mult);
        P_score = Math.max(L_score, R_score);


        //crong 점수계산
        L_sum = summ(crong.get(0));
        L_mult = mult(crong.get(0));
        R_sum = summ(crong.get(1));
        R_mult = mult(crong.get(1));
        L_score = Math.max(L_sum, L_mult);
        R_score = Math.max(R_sum, R_mult);
        C_score = Math.max(L_score, R_score);

        answer = get_winner(P_score, C_score);

        System.out.println("포비" + Integer.toString(P_score));
        System.out.println("크롱" + Integer.toString(C_score));

        System.out.println(answer);
        return answer;
    }
        public static int summ ( int N){
            // 각 자리의 수를 합한 값을 반환
            int total = 0;
            if (N >= 100) { // 100 이상인 경우
                total += N / 100;
                total += (N % 100) / 10;
            } else if (N >= 10) { // 10 이상인 경우
                total += (N % 100) / 10;
            }
            total += N % 10;

            return total;
        }

        public static int mult ( int N){
            int total = 1;
            if (N >= 100) {
                total *= N / 100;
                total *= (N % 100) / 10;
            } else if (N >= 10) {
                total *= (N % 100) / 10;
            }
            total *= N % 10;

            return total;
        }

        public static int get_winner ( int p_score, int c_score){
            if (p_score > c_score) return 1;
            else if (p_score < c_score) return 2;
            else if (p_score == c_score) return 0;

            else return -1;
        }

        public static int check_except(List<Integer> pobi, List<Integer> crong){
            int p1 = pobi.get(0);
            int p2 = pobi.get(1);
            int c1 = crong.get(0);
            int c2 = crong.get(1);

            if (p1 == 1 || p1 == 399 || c1 == 1 || c1 == 399 || p2 == 2 || p2 == 400 || c2 == 2 || c2 == 400) return -1;
            if (p2 != (p1 + 1) || c2 != (c1 + 1)) return -1;
            if (p1 % 2 != 1 || c1 % 2 != 1 || p2 % 2 != 0 || c2 % 2 != 0) return -1;
            if (p1<3 || p1>398 || p2<3 || p2>398 || c1<3 || c1>398 || c2<3 || c2>398) return -1;

            return 1;
        }

}