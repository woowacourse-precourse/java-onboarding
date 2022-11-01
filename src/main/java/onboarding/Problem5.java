/*
기능 목록
i) getExchange(int money) -> 돈을 입력받고 exchange 개수를 list 형태로 반환한다.
ii) solution -> i) 를 이용하여 정답을 반환한다.
 */


package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {


    ArrayList getExchange(int money){
        ArrayList temp_array = new ArrayList();
        int temp_int = money;
        temp_array.add(temp_int/50000);
        temp_int = money % 50000;
        temp_array.add(temp_int/10000);
        temp_int = money % 10000;
        temp_array.add(temp_int/5000);
        temp_int = money % 5000;
        temp_array.add(temp_int/1000);
        temp_int = money % 1000;
        temp_array.add(temp_int/500);
        temp_int = money % 500;
        temp_array.add(temp_int/100);
        temp_int = money % 100;
        temp_array.add(temp_int/50);
        temp_int = money % 50;
        temp_array.add(temp_int/10);
        return temp_array;
    }


    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
