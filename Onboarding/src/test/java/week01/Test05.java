package week01;

public class Test05 {
    public static void main(String[] args) {
        int money = 110000;
        Problem05 problem = new Problem05();
        for(int i = 0; i < 9; i++){
            System.out.println(problem.solution(money)[i]);
        }

    }
}
