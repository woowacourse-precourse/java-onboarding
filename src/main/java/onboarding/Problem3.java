package onboarding;

public class Problem3 {
    static int count=0;
    public static int solution(int number) {
        if (number<3) return 0;

        for (int i=3;i<=number;i++){
            getCount(i);
        }

        return count;
    }

    public static void getCount(int num){
        String s = String.valueOf(num);
        int num_length = s.length();
        count+= num_length - s.replaceAll("[369]","").length();
    }
}
