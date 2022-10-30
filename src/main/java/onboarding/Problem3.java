package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    // 숫자를 자리수별로 분할하는 함수
    // input : 정수형 숫자 (10, 15 등..)
    // output: 자리수별로 분열된 정수형 숫자 리스트 ([1, 0], [1, 5])
    private static List<Integer> splitInt(int num) {
        List<Integer> list = new ArrayList<>();

        String str = String.valueOf(num);
        String[] digits = str.split("(?<=.)");

        for (int i = 0; i < digits.length; i ++) {
            list.add(Integer.parseInt(digits[i]));
        }

        return list;
    }

    // 정수형 숫자로 이루어진 배열에서 3, 6, 9를 찾는 함수
    // input : 정수형으로 이루어진 List
    // output: 숫자 개수(정수형)
    private static int findNumCount(List<Integer> numList) {
        int count = 0;

        for (int i = 0; i < numList.size(); i ++) {
            int num = numList.get(i);
            if (num == 3 || num == 6 || num == 9)
                count ++;
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i ++) {
            List<Integer> splittedNum = splitInt(i);
            answer += findNumCount(splittedNum);
        }

        return answer;
    }
}
