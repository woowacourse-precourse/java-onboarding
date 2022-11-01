package onboarding;

import java.util.List;
import java.util.ArrayList;
public class Problem5 {
<<<<<<< HEAD
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] money_unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};  //화폐단위 별로 리스트 삽입

        for(int x = 0; x < money_unit.length; x++){ //제일 큰 화폐단위부터 순서대로 나눈다.
            answer.add(money / money_unit[x]);
            money %= money_unit[x];
=======
    public static int[] solution(int money) {
        int[] answer=new int[9];
        int[] sort_money = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        for(int s = 0; s< sort_money.length; s++){ //s= sort
            if(s==0) answer[s]=(money/sort_money[s]);
            else answer[s] = (money%sort_money[s-1])/sort_money[s];
>>>>>>> 3afd1abe0f212509fa246e1880a2f2cea9b5a981
        }
        return answer;
    }
}

