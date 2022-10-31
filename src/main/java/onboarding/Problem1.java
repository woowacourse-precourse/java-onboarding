package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(!err_check(pobi) || !err_check(crong)) return -1;
        else {
            int pobi_max = page(pobi);
            int crong_max = page(crong);
            //pobi win
            if(pobi_max > crong_max) answer = 1;
            //crong win
            else if(pobi_max < crong_max) answer = 2;
            //no winner
            else answer = 0;
        }
        return answer;
    }

    //select max value in this page
    private static int page(List<Integer> p){
        int max = 0;
        int left = p.get(0), right = p.get(1);
        //calculate max value
        int Max_Sum = Math.max(Sum(left), Sum(right));
        int Max_Mul = Math.max(Mul(left), Mul(right));
        max = Math.max(Max_Sum, Max_Mul);
        return max;
    }

    private static int Sum(int val){
        int sum = 0;
        while(val > 0){
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    private static int Mul(int val){
        int mul = 1;
        while(val > 0){
            mul *= val % 10;
            val /= 10;
        }
        return mul;
    }

    //error check to prohibit exceptional condition
    private static boolean err_check(List<Integer> p){
        //if List is empty, return false
        if(p.isEmpty()) return false;
        //if calculated value(right page - left page) is not 1(not in one sight), return false
        //it implicts the List set [left page, right page]
        else if(p.get(1) - p.get(0) != 1) return false;
        //if left page is even, return false
        //right page is calculated automatically with first conditional sentence
        else if(p.get(0) % 2 == 0) return false;
        //if page is over 400 or under 0, return false
        else if(p.get(0) < 1 || p.get(1) > 400) return false;
        //if not error in page select, return true
        else return true;
    }
}