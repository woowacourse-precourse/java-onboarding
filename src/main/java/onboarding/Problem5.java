package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};

        int temp = money;

        for(int i = 0; i < 9; i++){
            answer.add(i,temp/arr[i]);
            temp%=arr[i];
        }

//        for(int i = 0; i < answer.size(); i++){
//            System.out.println(answer.get(i));
//        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

//        solution(num);
        System.out.println(solution(num));
    }
}
