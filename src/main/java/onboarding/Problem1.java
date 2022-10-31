package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 처리
        if ((pobi.size() != 2) || (crong.size() != 2)) { // 잘못된 입력이 들어오는 경우
            return -1;
        }
        if ((pobi.get(0) % 2 == 0) || (crong.get(0) % 2 == 0)) { // 왼쪽 페이지가 홀수가 아닌경우
            return -1;
        }
        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) { // 오른쪽 페이지가 연속되지 않은 경우
            return -1;
        }

        // 점수 계산
        int pobi_score = cal_socre(pobi.get(0), pobi.get(1));
        int crong_score = cal_socre(crong.get(0), crong.get(1));


        if (pobi_score > crong_score) {
            return  1; // pobi win
        } else if (pobi_score < crong_score) {
            return 2; // crong win
        } else {
            return 0; // draw
        }
    }

    public static int cal_socre(int num1, int num2) {

        int[] result = new int[] {0,1,0,1};

        while (num1 > 0) { // left page
            int temp = 0;
            temp += num1 % 10;
            result[0] += temp;
            result[1] *= temp;
            num1 /= 10;
        }

        while (num2 > 0) { // right page
            int temp = 0;
            temp += num2 % 10;
            result[2] += temp;
            result[3] *= temp;
            num2 /= 10;
        }

        int max = result[0]; // pick max value
        for (int i=0; i<result.length; i++) {
            if(result[i] > max) {
                max = result[i];
            }
        }

        return max;
    }
}