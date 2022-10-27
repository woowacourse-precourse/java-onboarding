package onboarding;


public class Problem3 {
    static int answer=0;
    public static void howManyThree(String number) {
        for (int i=0; i<number.length(); i++) {
            int iNumber= (int) Character.getNumericValue(number.charAt(i));
            if (iNumber!=0&&iNumber%3==0) {
                answer++;
            }
        }
    }
    public static int solution(int number) {

        for (int i=1; i<=number; i++) {
            howManyThree(Integer.toString(i));
        }
        return answer;
    }
}
