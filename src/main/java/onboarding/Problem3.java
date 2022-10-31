package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer=count369(number);
        return answer;
    }

    // 자릿수를 분리하는 메소드
    static ArrayList<Integer> splitNumber(int number){
        ArrayList<Integer> array = new ArrayList<>();

        while(number>0){
            array.add(number%10);
            number /= 10;
        }
        return array;
    }

    // 0부터 1까지 주어진 수에 대해서 반복문으로 나열하고, splitNumber 메소드를 통해 자리수 별로 369를 세는 메소드
    static int count369(int number){
        int answer = 0;
        for(int i =0; i<number+1;i++) {
            ArrayList<Integer>array=splitNumber(i);
            for (int j = 0; j<array.toArray().length;j++){
                if (array.get(j)%3==0 && array.get(j)!= 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
