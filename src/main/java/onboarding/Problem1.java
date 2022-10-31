package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiMax, crongMax;
        // 예외처리 1: 배열 길이가 2가 아닌 경우
        if(pobi.size() != 2 || crong.size() != 2) return -1;
        // 예외처리 2: 두 페이지 관계가 x, x+1이 아닐 경우
        if((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) return -1;
        // 예외처리 3: x가 짝수인 경우
        if((pobi.get(0) % 2 == 0) || (crong.get(0) % 2 == 0)) return -1;
        // 예외처리 4: x<1 또는 x>400인 경우
        if((pobi.get(0) < 1 || pobi.get(0) > 400) || (crong.get(0) < 1 || crong.get(0) > 400)) return -1;

        // 포비 점수
        pobiMax = getMaxScore(pobi);
        // 크롱 점수
        crongMax = getMaxScore(crong);

        if(pobiMax > crongMax) answer = 1;
        else if(pobiMax == crongMax) answer = 0;
        else answer = 2;

        return answer;
    }

    private static List<Integer> calculateDigitSum(int num) {
        int sum = 0;
        int multi = 1;
        while(num > 0) {
            sum += num % 10;
            multi *= num % 10;
            num /= 10;
        }

        return List.of(sum, multi);
    }

    private static int getMaxScore(List<Integer> person) {
        int max;
        // 왼쪽 페이지의 자릿수 합과 곱
        List<Integer> calculatedValue = calculateDigitSum(person.get(0));
        max = Math.max(calculatedValue.get(0), calculatedValue.get(1));
        // 오른쪽 페이지의 자릿수 합과 곱
        calculatedValue = calculateDigitSum(person.get(1));
        // 더 큰 값을 취함
        max = Math.max(max, Math.max(calculatedValue.get(0), calculatedValue.get(1)));
        return max;
    }
}