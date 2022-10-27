package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++){
            count += clap(i);
        }

        return count;
    }
    static int clap(int number){
        int count = 0;
        String[] array = Integer.toString(number).split("");
        for(int i = 0; i < array.length; i++){
            if(haveToClap(array[i])){
                count++;
            }
        }
        return count;
    }
    static boolean haveToClap(String numberString){
        String[] compare = {"3","6","9"};
        for(int i = 0; i < 3; i++){
            if(numberString.equals(compare[i])){
                return true;
            }
        }
        return false;
    }
}
