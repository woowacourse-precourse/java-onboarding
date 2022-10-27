package onboarding;


public class Problem3 {
    static int cnt=0;
    public static void howManyThree(String number) {
        for (int i=0; i<number.length(); i++) {
            int iNumber= (int) Character.getNumericValue(number.charAt(i));
            if (iNumber!=0&&iNumber==3) {
                cnt++;
            }
        }
    }
    public static int solution(int number) {
        int n=33;
        int answer=0;

        for (int i=1; i<=n; i++) {
            howManyThree(i);
        }
        return cnt;
    }
}
