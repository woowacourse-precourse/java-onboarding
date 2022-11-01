package onboarding;

import java.util.Objects;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //1씩 증가하는 number
        int index = 0;
        //number의 수까지 반복한다.
        while (index < number){
            index += 1;
            String indexString = String.valueOf(index);
            //숫자가 3,6,9를 포함할경우
            if (checkContains(indexString)) {
                //현재 순자에서 박수를 치는 갯수를 더한다.
                answer += countAnswer(index);
            }
        }
        return answer;
    }

    private static Boolean checkContains(String indexString) {
        // 3,6,9 가 있는지 체크한다.
        return indexString.contains("3") |
                indexString.contains("6") |
                indexString.contains("9");
    }

    private static int countAnswer(int index) {
        int returnValue = 0;
        //해당 숫자의 박수갯수를 구한다.
        for (String s: String.valueOf(index).split("")){
            if (s.equals("3")) returnValue +=1;
            if (s.equals("6")) returnValue +=1;
            if (s.equals("9")) returnValue +=1;
        }
        return returnValue;
    }
}
