package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int dn = 0;
        int answer = 0;
        int[] arr = new int[10];
        for(int j=1; j<=number; j++) {
            for (int i = 0; i < 10; i++) {
                int a = j;
                dn=0;
                while (a > 0) {
                    dn = a % 10;
                    a /= 10;
                    arr[dn]++;
                }
                if (dn < 10) {
                    break;
                }
                a=dn;

            }
        }
        for(int i=0; i<10; i++) {
            if (i == 3 || i == 6 || i == 9) {
                answer += arr[i];
            }
        }






        return answer;
    }
}
