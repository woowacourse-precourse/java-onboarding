package onboarding;

import java.util.stream.Stream;
//성공
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i =1; i<number+1; i++){
            int[] a = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();

            for(int j:a){
                if(j==3 || j==6|| j==9){
                    answer+=1;
                }
            }


        }



        return answer;
    }
}
