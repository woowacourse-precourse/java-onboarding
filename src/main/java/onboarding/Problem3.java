package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int resultClap = 0;
        for (int i=1; i<=number; i++) {
            String stringNumber = String.valueOf(i);
            int threeCount = count(stringNumber,"3");
            int sixCount = count(stringNumber,"6");
            int nineCount = count(stringNumber,"9");

            resultClap += threeCount + sixCount + nineCount;
        }
        return resultClap;
    }

    public static Integer count(String number, String clapCondition) {
        return number.length() - number.replace(clapCondition,"").length();
    }
}
