package onboarding;

import java.util.List;



class Problem1 {
    public static int max_return(List<Integer> target) {
        //pagenum 예외처리 추가필요
        int first_p=target.get(0);
        int second_p=target.get(1);
        if ((first_p+1)!=second_p || first_p==0 || first_p==399)
            return -1;
        int all_add=0;
        int all_multi=1;
        for(int num=first_p;num!=0;num/=10){
            all_add += num%10;
            all_multi *= num%10;
        }
        int first_num = Integer.max(all_add, all_multi);
        all_add=0;
        all_multi=1;
        for(int num=second_p;num!=0;num/=10){
            all_add += num%10;
            all_multi *= num%10;
        }
        int second_num = Integer.max(all_add, all_multi);
        return Integer.max(first_num, second_num);

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobi_num = max_return(pobi);
        int crong_num = max_return(crong);
        if(pobi_num == -1 || crong_num == -1)
            return -1;
        else if(pobi_num > crong_num)
            return 1;
        else if(pobi_num < crong_num)
            return 2;
        else
            return 0;


    }
}