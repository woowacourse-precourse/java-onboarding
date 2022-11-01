package onboarding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
        // 각 캐릭터의 점수 계산
        int[] pobi_arr = new int[4];
        for(int i = 0; i<pobi.size(); i++){
            int sum = 0;
            int mul = 1;
            int num = 0;
            int val = pobi.get(i);
            while(val>0){
                num = val%10;
                sum+=num;
                mul*=num;
                val=val/10;
            }pobi_arr[2*i] = sum;
            pobi_arr[2*i+1] = mul;
        }
        
        int[] crong_arr = new int[4];
        for(int i = 0; i<crong.size(); i++){
            int sum = 0;
            int mul = 1;
            int num = 0;
            int val = crong.get(i);
            while(val>0){
                num = val%10;
                val=val/10;
                sum+=num;
                System.out.println("mul=mul*num" + mul +", " + num);
                mul*=num;
                System.out.println("mul : " + mul);

            }crong_arr[2*i] = sum;
            crong_arr[2*i+1] = mul;
        }

        // 각 캐릭터의 점수 최댓값 구하기
        int pobi_max = pobi_arr[0];
        for (int i = 1; i < pobi_arr.length; i++){
            if (pobi_arr[i]>pobi_max)pobi_max = pobi_arr[i];
        }
        for(int c : pobi_arr){
            System.out.println(c);
        }
        int crong_max = crong_arr[0];
        for (int i = 1; i < crong_arr.length; i++){
            if (crong_arr[i]>crong_max)crong_max = crong_arr[i];
        }

        int answer = 0;
        return answer;
    }
    
}