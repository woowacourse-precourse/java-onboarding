package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        bank(answer, money);
        return answer;
    }

    public static List<Integer> bank(List<Integer> answer, int money) {
        int total = money;
        int num;
        while(true){
            //5만원
            answer.add(num = (money/50000));
            total = total - (num*50000);

            if(total == 0){
                for(int i=1; i<=8; i++){
                    answer.add(0);
                }
                break;
            }
            //1만원
            answer.add(num = (total/10000));
            total = (total - (num*10000));
            if(total == 0){
                for(int i=1; i<=7; i++){
                    answer.add(0);
                }
                break;
            }

            //5천원
            answer.add(num = (total/5000));
            total = (total - (num*5000));
            if(total == 0){
                for(int i=1; i<=6; i++){
                    answer.add(0);
                }
                break;
            }

            //1천원
            answer.add(num = (total/1000));
            total = (total - (num*1000));
            if(total == 0){
                for(int i=1; i<=5; i++){
                    answer.add(0);
                }
                break;
            }

            //500원
            answer.add(num = (total/500));
            total = (total - (num*500));
            if(total == 0){
                for(int i=1; i<=4; i++){
                    answer.add(0);
                }
                break;
            }

            //100원
            answer.add(num = (total/100));
            total = (total - (num*100));
            if(total == 0){
                for(int i=1; i<=3; i++){
                    answer.add(0);
                }
                break;
            }

            //50원
            answer.add(num = (total/50));
            total = (total - (num*50));
            if(total == 0){
                for(int i=1; i<=2; i++){
                    answer.add(0);
                }
                break;
            }

            //10원
            answer.add(num = (total/10));
            total = (total - (num*10));
            if(total == 0){
                answer.add(0);
                break;
            }

            //1원
            answer.add(total);
            break;

        }

        return answer;
    }
}
