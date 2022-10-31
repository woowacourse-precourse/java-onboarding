package onboarding;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobi_max = 0;
        int crong_max = 0;
        int temp = 0;

        for(int i=0;i<2;i++){
            int num = pobi.get(i);
            while(num > 0){
                temp += num%10;
                num = num/10;
            }
            if(temp>pobi_max) pobi_max = temp;
        }

        for(int i=0;i<2;i++){
            int num = crong.get(i);
            while(num > 0){
                temp += num%10;
                num = num/10;
            }
            if(temp>crong_max) crong_max = temp;
        }

        if(pobi_max>crong_max) answer = 0;
        else if(pobi_max<crong_max) answer = 1;
        else answer = -1;

        return answer;
    }

    public static void main(String[] args){
        List<Integer> pobi = new ArrayList<>(2);
        List<Integer> crong = new ArrayList<>(2);

        Scanner sc = new Scanner(System.in);
        for(int i=0;i<2;i++){
            pobi.add(sc.nextInt());
        }
        for(int i=0;i<2;i++){
            crong.add(sc.nextInt());
        }

        System.out.write(solution(pobi, crong));
    }
}