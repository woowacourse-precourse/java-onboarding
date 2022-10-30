package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] result = new int[10001];
        result[0] = result[1] = result[2] = 0;
        for (int i = 3; i <= 10000; i++) {
            result[i] = result[i-1];
            int tmp = i;
            while(tmp > 0){
                int decimal = tmp % 10;
                if(decimal == 3 || decimal == 6 || decimal == 9){
                    result[i]++;
                }
                tmp /= 10;
            }
        }
        return result[number];
    }
}
