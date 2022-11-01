package onboarding;

public class Problem3 {
    public static int clap(int number){
        String number_str = Integer.toString(number);
        int cnt = 0;

        for (int i=0; i< number_str.length(); i++){
            char a = number_str.charAt(i);
            if (a == '3' || a == '6' || a=='9'){
                cnt +=1;
            }
        }
        return cnt;

    }
    public static int solution(int number) {
        int result = 0;
        for(int i = 1; i <= number; i++ ) {
            result += clap(i);
        }


        return result;
    }
}
