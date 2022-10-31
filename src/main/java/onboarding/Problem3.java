package onboarding;

// 기능1. 숫자를 숫자별로 자릿수 분리후 리스트에 넣는다 ex) number=13이면 1,2,3,4,5,6,7,8,9,1,0,1,1,1,2,1,3 으로 분리후 리스트에
// 기능2. 리스트 중 3,6,9 가 있으면 answer++ 한뒤 반환한다

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int j = 1;

        //기능1
        for (int i=1;i<number+2;i++) {
            while (j>0) {
                list.add(j%10);
                j = j/10;
            }
            j = i;
        }

        //기능2
        for (int i=0;i<list.toArray().length;i++) {
            if (list.get(i)==3 || list.get(i)==6 || list.get(i)==9) {
                answer++;
            }
        }
        return answer;
    }
}
