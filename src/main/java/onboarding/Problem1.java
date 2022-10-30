package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int i,j;
        int temp;
        List<Integer> left =  new ArrayList<>();
        List<Integer> right =  new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        int left_sum = 0;
        int right_sum = 0;
        int left_multi = 1;
        int right_multi = 1;

        int pobi_max = 0;
        int crong_max = 0;
        if(pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1)){
            temp = pobi.get(0);
            while(temp > 0) {
                left.add(temp % 10);
                temp/= 10;
            }
            temp = pobi.get(1);
            while(temp > 0) {
                right.add(temp % 10);
                temp/= 10;
            }
            for(i =0; i<left.size(); i++){
                left_sum += left.get(i);
                left_multi *= left.get(i);
            }
            for(i = 0; i<right.size(); i++){
                right_sum += right.get(i);
                right_multi *= right.get(i);
            }
            pobi_max = Math.max(Math.max(Math.max(left_sum, right_sum), left_multi), right_multi);
            left_sum = 0;
            right_sum = 0;
            left_multi =1;
            right_multi = 1;
            List<Integer> lef =  new ArrayList<>();
            List<Integer> rig =  new ArrayList<>();
            temp = crong.get(0);
            while(temp > 0) {
                lef.add(temp % 10);
                temp/= 10;
            }
            temp = crong.get(1);
            while(temp > 0) {
                rig.add(temp % 10);
                temp/= 10;
            }
            for(i =0; i<lef.size(); i++){
                left_sum += lef.get(i);
                left_multi *= lef.get(i);
            }
            for(i = 0; i<rig.size(); i++){
                right_sum += rig.get(i);
                right_multi *= rig.get(i);
            }
            crong_max = Math.max(Math.max(Math.max(left_sum, right_sum), left_multi), right_multi);
            System.out.println(pobi_max);
            System.out.println(crong_max);

            if(pobi_max > crong_max)
                answer = 1;
            else if(pobi_max < crong_max)
                answer = 2;
            else
                answer = 0;
        }
        else
            return -1;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();
        System.out.print("page of pobi: ");
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<2;i++){
            int n = Integer.parseInt(st.nextToken());
            pobi.add(n);
        }
        for(int i = 0; i<2; i++){
            System.out.println(pobi.get(i));
        }
        System.out.print("page of crong: ");
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<2;i++){
            int n = Integer.parseInt(st.nextToken());
            crong.add(n);
        }

        System.out.println("winner: " + solution(pobi, crong)); // pobi-win:1, crong-win:2, draw:0, exception:-1

        br.close();
    }
}