package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

if (!isValid(pobi, crong)) return -1;

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        if (pobiMax > crongMax) return 1;
        else if (pobiMax == crongMax) return 0;
        else return 2;
    }

    private static int getMax(List<Integer> list) {
        int answer = -1;
        for (int i = 0; i < 2; i++) {
            answer = Math.max(answer, getSumofDigits(list.get(i)));
            answer = Math.max(answer, getSumofDigitsMultiplies(list.get(i)));
        }

        return answer;
    }

    private static int getSumofDigits(int n) {
        int answer = 0;

        for (int i = 0; i < Math.log10(n) + 1; i++) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    private static int getSumofDigitsMultiplies(int n) {
        int answer = 1;

        for (int i = 0; i < Math.log10(n) + 1; i++) {
            answer *= n % 10;
            n /= 10;
        }

        return answer;
    }

    public static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) return false;
        else if (pobi.get(1) > 400 || crong.get(1) > 400 || pobi.get(0) < 1 || crong.get(0) < 1) return false;


        return answer;
    }
}