package onboarding;

public class Problem3 {
    public static int[] tqqq;
    public static int solution(int number) {
        int answer = 0;

        tqqq = new int[10000];
        tqqq[0] = 0;
        tqqq[1] = 0;
        tqqq[2] = 0;

        answer = increasingCrapCount(number);

        return answer;
    }

    private static int increasingCrapCount(int number) {
        String idxToStr = "";

        for (int idx = 3; idx <= number; idx++) {
            idxToStr = String.valueOf(idx);
            tqqq[idx] = tqqq[idx - 1];

            for (int strOfIdx = 0; strOfIdx < idxToStr.length(); strOfIdx++) {
                if (idxToStr.charAt(strOfIdx) == '3' || idxToStr.charAt(strOfIdx) == '6' || idxToStr.charAt(strOfIdx) == '9') {
                    tqqq[idx]++;
                }
            }
        }
        return tqqq[number];
    }
}
