package onboarding;

public class Problem3 {
	
	static int[] clap = new int[]{12000, 900, 60, 3, 0};
    static int[] unit = new int[]{10000, 1000, 100, 10, 1};
	
    private static int curPositionCalc(int value, int position) {
        int curClap = 0;

        for (int i = 0; i < value; i++) {
            curClap += clap[position];
            if (i == 3 || i == 6 || i == 9) curClap += unit[position];
        }

        return curClap;
    }
    
    public static int solution(int number) {
    	int[] digit = new int[5];

        for (int i = 0, temp = number; i < 5; i++, temp /= 10) digit[4 - i] = temp % 10;

        int totalClap = 0;

        for (int i = 0; i < 5; i++) {
            int value = digit[i];
            totalClap += curPositionCalc(value, i);

            number = number - value * unit[i];
            if (value == 3 || value == 6 || value == 9) totalClap += number + 1;
        }

        return totalClap;
    }
}
