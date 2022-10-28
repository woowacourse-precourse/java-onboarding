package onboarding;

public class Problem3 {
    final static char THREE = '3';
    final static char SIX = '6';
    final static char NINE = '9';

    public static int solution(int number) {
        return count369(number);
    }

    private static int count369(int range){
        int count = 0;

        for (int i=0; i<=range; i++){
            String num = String.valueOf(i);
            count += charCount(num);
        }

        return count;
    }

    private static int charCount(String num){
        int count = 0;
        for (Character ch : num.toCharArray()){
            if(ch == THREE | ch == SIX | ch == NINE){
                count++;
            }
        }
        return count;
    }

}
