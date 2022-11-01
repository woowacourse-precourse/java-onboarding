package onboarding;

public class Problem3 {
    public static final String GAME_NUMBER = "369";
    public static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        int[] cache = new int[MAX_NUMBER+1];
        initCache(cache);
        countClapNumber(cache);
        return cache[number];
    }

    public static void initCache(int[] arr){
        arr[1] = 0;
        arr[2] = 0;
    }

    public static void countClapNumber(int[] arr){
        for(int i=3 ; i <= MAX_NUMBER ; i++){
            arr[i] = arr[i-1] + countIncludedNumberOfGameNumber(i);
        }
    }

    public static int countIncludedNumberOfGameNumber(int number){
        String[] numberArray =  Integer.toString(number).split("");
        int count = 0;
        for (String num: numberArray){
            if(GAME_NUMBER.contains(num)){
            count++;
            }
        }
        return count;
    }
}
