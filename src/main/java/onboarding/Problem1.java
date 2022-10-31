package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int result_1 = 0;
        int result_2 = 0;
        int pobi_result = 0;
        int crong_result = 0;
        int[] arr = new int[4];
        arr[0] = pobi.get(0);
        arr[1] = pobi.get(1);
        arr[2] = crong.get(0);
        arr[3] = crong.get(1);
        int temp_add = 0;
        int temp_mul = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i] >= 100) {
                int a = arr[i] / 100;
                int x = arr[i] - a * 100;
                int b = x / 10;
                int c = x % 10;
                temp_add = a + b + c;
                temp_mul = a * b * c;
                if (temp_add > temp_mul) {
                    if (i == 0 || i == 2)
                        result_1 = temp_add;
                    else result_2 = temp_add;
                } else {
                    if (i == 0 || i == 2)
                        result_1 = temp_mul;
                    else result_2 = temp_mul;
                }
            } else if (arr[i] >= 10) {
                int a = arr[i] / 10;
                int b = arr[i] % 10;
                temp_add = a + b;
                temp_mul = a * b;
                if (temp_add > temp_mul) {
                    if (i == 0 || i == 2)
                        result_1 = temp_add;
                    else result_2 = temp_add;
                } else {
                    if (i == 0 || i == 2)
                        result_1 = temp_mul;
                    else result_2 = temp_mul;
                }
            } else {
                if (i == 0 || i == 2) {
                    result_1 = arr[i];
                } else result_2 = arr[i];
            }
            if (i == 1) {
                if (result_1 > result_2)
                    pobi_result = result_1;
                else pobi_result = result_2;
            }
            if (i == 3) {
                if (result_1 > result_2)
                    crong_result = result_1;
                else crong_result = result_2;
            }
        }
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1))
            answer = -1;
        else if (crong_result > pobi_result)
            answer = 2;
        else if (crong_result == pobi_result)
            answer = 0;
        else answer = 1;
        return answer;
    }
}