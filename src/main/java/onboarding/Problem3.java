package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] samYookGoo = new int[number+1];

        for (int i = 1; i < samYookGoo.length; i++) {
            samYookGoo[i] = samYookGoo[i-1];
            int num = i;

            while (num > 0) {
                int mod = num % 10;
                if (mod != 0 && mod % 3 == 0) samYookGoo[i] += 1;
                num /= 10;
            }
        }

        return samYookGoo[number];
    }
}
