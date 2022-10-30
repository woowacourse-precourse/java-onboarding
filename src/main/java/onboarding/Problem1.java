package onboarding;

import java.util.List;
import java.util.ArrayList;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1){
                return -1;
            }
            if(pobi.get(1)>400 || crong.get(1)>400 || pobi.get(0)<=0 || crong.get(0)<=0 || pobi.get(0)%2!=1 || crong.get(0)%2!=1){
                return -1;
            }
            String pobi_str_first=Integer.toString(pobi.get(0));
            String pobi_str_second=Integer.toString(pobi.get(1));
            int pobi_add_sum=0;
            int pobi_multi_sum=1;
            for(int i=0;i<pobi_str_first.length();++i){
                String s=pobi_str_first.substring(i,i+1);
                pobi_add_sum+=Integer.parseInt(s);
                pobi_multi_sum*=Integer.parseInt(s);
            }
            for(int i=0;i<pobi_str_second.length();++i){
                String s=pobi_str_second.substring(i,i+1);
                pobi_add_sum+=Integer.parseInt(s);
                pobi_multi_sum*=Integer.parseInt(s);
            }
            int fin_pobi_num=Math.max(pobi_add_sum,pobi_multi_sum);

            String crong_str_first=Integer.toString(crong.get(0));
            String crong_str_second=Integer.toString(crong.get(1));
            int crong_add_sum=0;
            int crong_multi_sum=1;
            for(int i=0;i<crong_str_first.length();++i){
                String s=crong_str_first.substring(i,i+1);
                crong_add_sum+=Integer.parseInt(s);
                crong_multi_sum*=Integer.parseInt(s);
            }
            for(int i=0;i<crong_str_second.length();++i){
                String s=crong_str_second.substring(i,i+1);
                crong_add_sum+=Integer.parseInt(s);
                crong_multi_sum*=Integer.parseInt(s);
            }
            int fin_crong_num=Math.max(crong_add_sum,crong_multi_sum);
            if(fin_pobi_num>fin_crong_num){
                answer=1;
            }else if(fin_pobi_num==fin_crong_num){
                answer=0;
            }else{
                answer=2;
            }
            return answer;
        }catch (NumberFormatException e){
            return -1;
        }

    }
//    public static void main(String[] args){
//        List<Integer> pobi = new ArrayList<>();
//        pobi.add(102);
//        pobi.add(103);
//        List<Integer> crong = new ArrayList<>();
//        crong.add(2);
//        crong.add(3);
//        System.out.println(solution(pobi,crong));
//    }
}