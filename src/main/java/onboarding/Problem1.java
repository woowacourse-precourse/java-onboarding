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
        List<Integer> calRes = calculateDigitSum(pobi.get(0));
        pobiMax = Math.max(calRes.get(0), calRes.get(1));
        calRes = calculateDigitSum(pobi.get(1));
        pobiMax = Math.max(pobiMax, Math.max(calRes.get(0), calRes.get(1)));

        // 크롱 점수
        calRes = calculateDigitSum(crong.get(0));
        crongMax = Math.max(calRes.get(0), calRes.get(1));
        calRes = calculateDigitSum(crong.get(1));
        crongMax = Math.max(crongMax, Math.max(calRes.get(0), calRes.get(1)));

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
}