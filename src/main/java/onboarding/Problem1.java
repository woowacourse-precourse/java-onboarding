package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 페이지 숫자를 이용하여 자릿수 연산 결과를 반환
    static class DigitDecoder {
        int product = 1;
        int sum = 0;

        DigitDecoder(int num) {
            while (num > 1) {
                int digit = num % 10;
                product *= digit;
                sum += digit;
                num /= 10;
            }
        }

        int getMax() {
            return Math.max(this.product, this.sum);
        }
    }
}