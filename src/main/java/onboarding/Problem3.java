package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!validate(number)) return -1;

        int answer = getClapCount(number);

        return answer;
    }

    private static boolean validate(int number) {
        if (number < 1 || number > 1000) return false;
        return true;
    }

    private static int getClapCount(int number) {
        int[] clapCount = new int[number + 1];
        clapCount[1] = 0;

        for (int i = 2; i <= number; i++) {
            clapCount[i] = clapCount[i-1] + clapCheck(i);
        }

        return clapCount[number];
    }

    private static int clapCheck(int number) {
        String strNum = String.valueOf(number);
        int count = 0;

        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9'){
                count += 1;
            }
        }

        return count;
    }
}
