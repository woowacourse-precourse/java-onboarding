package onboarding;


public class Problem3 {
    public static int howManyThree(String number) {
        int cnt=0;
        for (int i=0; i<number.length(); i++) {
            int iNumber= (int) Character.getNumericValue(number.charAt(i));
            if (iNumber!=0&&iNumber%3==0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer=0;
        for (int i=1; i<=number; i++) {
            answer+=howManyThree(Integer.toString(i));
        }
        return answer;
    }
}
