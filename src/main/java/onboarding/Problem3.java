package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap_count = 0;
        int target_number = 0;
        for(int current_check_number = 1; current_check_number <= number; current_check_number++){
            target_number = current_check_number;
            while(target_number > 0){
                if(isRemain369(target_number)) {
                    clap_count++;
                }
                target_number /= 10;
            }
        }
        return clap_count;
    }

    private static boolean isRemain369(int number) {
        int remainder = number % 10;
        if (remainder == 3 || remainder == 6 || remainder == 9) {
            return true;
        }
        return false;
    }
}
