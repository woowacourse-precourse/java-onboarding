package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        List<Integer> num = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10,1));
        //1.오만원 권
        //오만원 나눈 몫 저장
        //나머지 갱신
        //2.만원권
        //3.오천원권
        //4.천원권
        //5.오백원
        //6.백원
        //7.오십원
        //8.십원
        //9.일원
        //주의: answer 가 Collections.emptyList(); 으로 생성해서 값을 add 하려면 에러 발생
        //해결: 대체 리스트 new ArrayList<>(); 로 저장
        for(int i=0;i<num.size();i++){
            res.add((money/num.get(i)));
            money%=num.get(i);
        }
        return answer=res;
    }
}