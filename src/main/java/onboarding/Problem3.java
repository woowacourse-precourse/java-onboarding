package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count=0;
        if (validation("number_limit", number)) {
            if (number < 3) return 0;
            else {
                for (int i = 3; i <= number; i++) {
                    count+=getCount(i);
                }
                return count;
            }
        }
        return count;
    }

    public static int getCount(int num){
        String s = String.valueOf(num);
        int num_length = s.length();
        return num_length - s.replaceAll("[369]","").length();
    }

    private static <T> boolean validation(String err_type,T err_param){
        if (err_type.equals("number_limit")&&err_param instanceof Integer){
            int number_limit = (int) err_param;
            return 0<number_limit&&number_limit<10001;
        }
        return false;
    }

}
