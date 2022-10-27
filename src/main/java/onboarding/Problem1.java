package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!exceptions(pobi) || !exceptions(crong)){
            return -1;
        }
        int pobi_point = user_point(pobi);
        int crong_point = user_point(crong);
        int answer = (pobi_point > crong_point) ? 1 :((pobi_point < crong_point) ? 2 : 0);

        return answer;
    }
    public static boolean exceptions(List<Integer> person){
        if(person.get(0)>1 && person.get(0)<399 && person.get(1)>1 && person.get(1)<399){
            if(person.get(0)%2==1 && person.get(1)%2==0){
                if(person.get(0)+1 == person.get(1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int user_point(List<Integer> pages){
        int left = big_int(sum_plus(pages.get(0)),sum_multiply(pages.get(0)));
        int right = big_int(sum_plus(pages.get(1)),sum_multiply(pages.get(1)));

        return big_int(left,right);
    }

    public static int sum_plus(int page){
        String s = Integer.toString(page);
        int sum=0;
        for(String num : s.split("")){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    public static int sum_multiply(int page){
        String s = Integer.toString(page);
        int sum=1;
        for(String num : s.split("")){
            sum *= Integer.parseInt(num);
        }
        return sum;
    }
    public static int big_int(int a, int b){
        return a>b ? a : b;
    }


}