package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_sum[] = new int[2];
        int pobi_mul[] = new int[2];
        int crong_sum[] = new int[2];
        int crong_mul[] = new int[2];

        int pobi_temp, crong_temp;


        if(pobi.get(0) %2==0 || crong.get(0) %2==0) return -1;

        if(pobi.get(1)- pobi.get(0)!=1 || crong.get(1)- crong.get(0)!=1) return -1;



        for(int i = 0; i < 2; i++){
            pobi_temp = pobi.get(i);
            crong_temp = crong.get(i);
            pobi_mul[i] = 1;
            crong_mul[i] = 1;
            while(pobi_temp!=0){
                pobi_sum[i] += pobi_temp%10;
                pobi_mul[i] *= pobi_temp%10;

                pobi_temp /= 10;
            }
            while(crong_temp!=0){
                crong_sum[i] += crong_temp%10;
                crong_mul[i] *= crong_temp%10;

                crong_temp /= 10;
            }
        }

        pobi_temp = Math.max(pobi_mul[0],Math.max(pobi_mul[1],Math.max(pobi_sum[0],pobi_sum[1])));
        crong_temp = Math.max(crong_mul[0],Math.max(crong_mul[1],Math.max(crong_sum[0],crong_sum[1])));

        if(pobi_temp==crong_temp) return 0;
        else if(pobi_temp>crong_temp) return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = 0;

        List<Integer> p = new ArrayList<>(2);
        List<Integer> c = new ArrayList<>(2);

        for(int i = 0; i < 2; i++){
            temp = Integer.parseInt(br.readLine());
            p.add(i,temp);
        }
        for(int i = 0; i < 2; i++){
            temp = Integer.parseInt(br.readLine());
            c.add(i,temp);
        }
        System.out.println(solution(p,c));
    }
}
