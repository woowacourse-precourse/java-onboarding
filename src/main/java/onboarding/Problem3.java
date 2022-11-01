package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] arr = new int[10000 + 1];

        int count = 0;

        for (int i = 0; i < number + 1; i++) {
            for (char ch : String.valueOf(i).toCharArray()) {
                if (ch == '3' || ch == '6' || ch == '9')
                    ++count;
            }

            arr[i] = count;
        }

        return arr[number];
    }
}
