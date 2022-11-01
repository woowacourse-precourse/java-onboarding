package onboarding;

import java.util.ArrayList;
import java.util.List;

/*기능 요구 사항*/
/* 1. 3,6,9가 나올 때 3,6,9의 개수만큼 손뼉을 쳐야한다.
 * 2. 1부터 number 까지 손뼉을 몇번 쳐야하는지 Return
 <solution>
 *  - list에 3,6,9를 넣고, num%10이 포함되면 answer를 하나씩 더해준다.
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> con = new ArrayList<>();
        con.add(3);
        con.add(6);
        con.add(9);
        for(int i=1; i<=number; i++){
            int num = i;
            do{
                if(con.contains(num%10)) answer++;
            }while((num/=10) > 0);
        }
        return answer;
    }
}
