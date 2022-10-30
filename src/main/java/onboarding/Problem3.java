package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++){
            ArrayList<Integer> array = intToArray(i);
            for (int element: array){
                if (element == 3 || element == 6 || element == 9 ){
                    answer += 1;
                }
            }
        }
        return answer;
    }

    // 정수 배열로 변환
    public static ArrayList intToArray(int num){
        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(num % 10);
            num /= 10;
        } while  (num > 0);

        return array;
    }

}
