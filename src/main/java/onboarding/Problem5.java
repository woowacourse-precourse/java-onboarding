package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> save = new ArrayList<>();
        int temp;
        while(true){
            if(money <= 0)
                break;
            if(money % 50000 != 0){
                temp = money/50000;
                save.add(temp);
                money %= 50000;
            }
            if(money % 10000 != 0){
                temp = money/10000;
                save.add(temp);
                money %= 10000;
            }
            if(money % 5000 != 0){
                temp = money/5000;
                save.add(temp);
                money %= 5000;
            }
            if(money % 1000 != 0){
                temp = money/1000;
                save.add(temp);
                money %= 1000;
            }
            if(money % 500 != 0){
                temp = money/500;
                save.add(temp);
                money %= 500;
            }
            if(money % 100 != 0){
                temp = money/100;
                save.add(temp);
                money %= 100;
            }
            if(money % 50 != 0){
                temp = money/50;
                save.add(temp);
                money %= 50;
            }
            if(money % 10 != 0){
                temp = money/10;
                save.add(temp);
                money %= 10;
            }
            if(money % 1 != 0){
                temp = money/1;
                save.add(temp);
                money %= 1;
            }
        }
        System.out.print(save.toString());
        return answer;
    }*/
    public static List<Integer> solution(int money) {
            List<Integer> answer = Collections.emptyList();
            List<Integer> save = new ArrayList<>();
            int temp;
            while(true){
                if(money <= 0)
                    break;
                if(money / 50000 != 0){
                    save.add(money/50000);
                    money %= 50000;
                }
                else
                    save.add(0);
                if(money / 10000 != 0){
                    save.add(money/10000);
                    money %= 10000;
                }
                else
                    save.add(0);
                if(money / 5000 != 0){
                    save.add(money/5000);
                    money %= 5000;
                }
                else
                    save.add(0);
                if(money / 1000 != 0){
                    save.add(money/1000);
                    money %= 1000;
                }
                else
                    save.add(0);
                if(money / 500 != 0){
                    save.add(money/500);
                    money %= 500;
                }
                else
                    save.add(0);
                if(money / 100 != 0){
                    save.add(money/100);
                    money %= 100;
                }
                else
                    save.add(0);
                if(money / 50 != 0){
                    save.add(money/50);
                    money %= 50;
                }
                else
                    save.add(0);
                if(money / 10 != 0){
                    save.add(money/10);
                    money %= 10;
                }
                else
                    save.add(0);
                if(money / 1 != 0){
                    save.add(money/1);
                    break;
                }
                else
                    save.add(0);
            }
            answer = save;
            return answer;
        }
    public static void main(String[] args) {
        int money = 50237;
        List<Integer> answer = Collections.emptyList();
        answer = solution(money);
        System.out.print(answer.toString());
    }
}
