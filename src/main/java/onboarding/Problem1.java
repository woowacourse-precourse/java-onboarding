package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = process(pobi, crong);

        return answer;
    }
    static boolean book_range_check(int left, int right) {
        if(left<=2 || right<=2 || left>=399 || right >=399){
            return false;
        }
        if(left%2 != 1 || right%2 != 0) {
            return false;
        }
        if(left+1 != right){
            return false;
        }
        return true;
    }

    static int max_number(int num) {
        int sum = 0;
        int multiple =1;

        while (num>0){
            sum += num%10;
            multiple *= num%10;

            num /=10;
        }

        return Math.max(sum,multiple);
    }

    static int my_score(int left, int right){
        return Math.max(left,right);
    }

    static int process(List<Integer> pobi, List<Integer> crong) {
        int ans = -1;

        int pobi_l = pobi.get(0), pobi_r = pobi.get(1);
        int crong_l = crong.get(0), crong_r = crong.get(1);

        if(book_range_check(pobi_l,pobi_r) && book_range_check(crong_l,crong_r)){
           int pobi_max = my_score(max_number(pobi_l),max_number(pobi_r));
           int crong_max = my_score(max_number(crong_l),max_number(crong_r));

           if(pobi_max>crong_max){
               ans = 1;
           }

           if(pobi_max == crong_max) {
               ans = 0;
           }

           if(pobi_max < crong_max) {
               ans = 2;
           }


        }

        return ans;
    }

}

