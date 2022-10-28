package onboarding;

import java.util.ArrayList;
import java.util.List;



class Problem1{
    public static Integer Plus(int num){
        int result = 0;
        while(num!=0){
            result += num%10;
            num /=10;

        }
        return result;
    }
    public  static Integer Multiply(int num){
        int result = 1;
        while(num!=0){
            result *= num%10;
            num /=10;

        }
        return result;
    }

    public static List<Integer> PobiResult(List<Integer> pobi){
        List<Integer> PobiResult = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            if (Plus(pobi.get(i)) < Multiply(pobi.get(i))) {
                PobiResult.add(i, Multiply(pobi.get(i)));
            } else if (Plus(pobi.get(i)) > Multiply(pobi.get(i))) {
                PobiResult.add(i, Multiply(pobi.get(i)));
            } else if (Plus(pobi.get(i)) == Multiply(pobi.get(i))) {
                PobiResult.add(i, Multiply(pobi.get(i)));
            }
        }
        return PobiResult;
    }
    public static List<Integer> CrongResult(List<Integer> crong){
        List<Integer> CrongResult = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (Plus(crong.get(i)) < Multiply(crong.get(i))) {
                CrongResult.add(i, Multiply(crong.get(i)));
            } else if (Plus(crong.get(i)) > Multiply(crong.get(i))) {
                CrongResult.add(i, Multiply(crong.get(i)));
            } else if (Plus(crong.get(i)) == Multiply(crong.get(i))) {
                CrongResult.add(i, Multiply(crong.get(i)));
            }
        }
        return CrongResult;
    }

    public static int AllPobi(List<Integer> PobiResult){
        int AllPobi = 0;
        if (PobiResult.get(0) < PobiResult.get(1)) {
            AllPobi = PobiResult.get(1);
        } else if (PobiResult.get(0) > PobiResult.get(1)) {
            AllPobi = PobiResult.get(0);
        }
        return  AllPobi;
    }

    public static int AllCrong(List<Integer> CrongResult){
        int AllCrong = 0;
        if (CrongResult.get(0) < CrongResult.get(1)) {
            AllCrong = CrongResult.get(1);
        } else if (CrongResult.get(0) > CrongResult.get(1)) {
            AllCrong = CrongResult.get(0);
        }
        return AllCrong;
    }

    public static int FinalResult(int AllPobi,int AllCrong){
        int answer = 0;
        if (AllPobi > AllCrong) {
            answer = 1;
        } else if (AllPobi < AllCrong) {
            answer = 2;
        } else if (AllPobi == AllCrong) {
            answer = 0;
        }
        return answer;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if ((pobi.get(1)-pobi.get(0)==1) && (crong.get(1)-crong.get(0)==1)) {
            List<Integer> PobiResult = PobiResult(pobi);
            List<Integer> CrongResult = CrongResult(crong);

            int AllPobi = AllPobi(PobiResult);
            int AllCrong = AllCrong(CrongResult);


            answer = FinalResult(AllPobi,AllCrong);
        }else{
            answer = -1;
        }
        return answer;
    }
}