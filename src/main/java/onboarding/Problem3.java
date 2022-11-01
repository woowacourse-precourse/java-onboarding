package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;


        for (int i = 1; i < number+1; i++){
            int num = i;

            int[] intArray = {0,0,0,0};
            int j = 0;
            while(true){
                intArray[j] = num % 10;
                j++;
                if(!((num / 10) > 0))
                    break;
                num = num / 10;
            }
            for(int k = 0; k < intArray.length; k++){
                if(intArray[k] == 3 || intArray[k] == 6 || intArray[k] == 9)
                    answer++;
            }
        }

        return answer;
    }
}
