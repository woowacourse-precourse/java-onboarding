package onboarding;

public class Problem3 {
    public static int solution(int number) {

        // number는 1 이상 10,000 이하인 자연수이다.
        if (number < 1 || number > 10000){
            return -1;
        }

        return countLogic(number);

    }

    private static int countLogic(int num){
        int count = 0;

        for(int i = 1; i <= num; i++){
            int tens = i / 10;
            int units = i % 10;

            if(tens == 3 || tens == 6 || tens == 9){
                count += 1;

                if(unitsCounts(units)) {
                    count += 1;
                }
            }

            else if (unitsCounts(units)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean unitsCounts(int unit){
        if(unit == 3 || unit == 6 || unit == 9){
            return true;
        }

        return false;
    }

}
