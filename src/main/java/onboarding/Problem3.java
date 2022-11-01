package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        String[] numbers = new String[number + 1];
        for (int i = 0; i <= number; i++) {
            numbers[i] = String.valueOf(i);
        }

        for (String num : numbers) {
            char[] partition = num.toCharArray();
            for (char part : partition) {
                if (part == '3' || part == '6' || part == '9') {
                    result += 1;
                }
            }
        }
        return result;
    }

}
