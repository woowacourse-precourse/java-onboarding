package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] clap = new int[]{0, 3, 60, 900};
        int[] unit = new int[]{1, 10, 100, 1000};

        String s = String.valueOf(number);
        int total = 0;
        int length = s.length();
        int last_index = length - 1;
        int[] digit = new int[length];
        for (int i = 0; i < length; i++) {
            digit[i] = s.charAt(i) - '0';
        }


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < digit[i]; j++) {
                total += clap[last_index - i];
                if (j == 3 || j == 6 || j == 9) total += unit[last_index - i];

            }

            number = number - digit[i] * unit[last_index - i];
            if (digit[i] == 3 || digit[i] == 6 || digit[i] == 9) total += number + 1;

        }


        return total;
    }
}
