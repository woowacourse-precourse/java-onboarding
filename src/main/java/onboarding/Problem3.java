package onboarding;

public class Problem3 {
    static int count=0;
    public static int solution(int number) {

        try {
            checkNumberLength(number);
            if (number < 3) return 0;

            else {
                for (int i = 3; i <= number; i++) {
                    getCount(i);
                }
                return count;
            }
        }catch (Exception e){
            return 0;
        }
    }

    public static void getCount(int num){
        String s = String.valueOf(num);
        int num_length = s.length();
        count+= num_length - s.replaceAll("[369]","").length();
    }

    public static void checkNumberLength(int number) throws Exception{
        if (number<1||number>10000) throw new Exception("수의 범위가 제한을 벗어났습니다");
    }

}
