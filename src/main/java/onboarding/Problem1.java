package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.size() != 2 || crong.size() != 2) || // 사이즈가 2가 아닌 경우
                (pobi.get(0) >= pobi.get(1) || crong.get(0) >= crong.get(1)) || // 왼쪽 페이지, 오른쪽 페이지 번호가 틀린 경우
                (pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0) || // 포비의 숫자가 왼쪽은 홀수, 오른쪽은 짝수가 아닌 경우
                (crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) || // 크롱의 숫자가 왼쪽은 홀수, 오른쪽은 짝수가 아닌 경우
                (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) || // 왼쪽페이지와 오른쪽페이지 숫자가 연결이 안되는 경우
                (pobi.get(0) < 1 || pobi.get(1) > 400) || (crong.get(0) < 1 || crong.get(1) > 400)) { // 1 ~ 400 아닌 경우
            return -1;
        }

        List<List<Integer>> usersNumbers = List.of(pobi, crong);
        List<Integer> usersMaxValue = new ArrayList<>();

        for (List<Integer> usersNumber : usersNumbers) {
            List<Integer> newUserNumbers = new ArrayList<>();
            for (Integer integer : usersNumber) {
                List<Integer> firstUserNumbers = new ArrayList<>();
                int num = integer;
                while (num > 0) {
                    firstUserNumbers.add(num % 10);
                    num /= 10;
                }
                int plusSum = 0;
                for (Integer firstUserNumber : firstUserNumbers) {
                    plusSum += firstUserNumber;
                }
                int multiplicationSum = 1;
                for (Integer firstUserNumber : firstUserNumbers) {
                    multiplicationSum *= firstUserNumber;
                }
                newUserNumbers.add(plusSum);
                newUserNumbers.add(multiplicationSum);
            }
            usersMaxValue.add(Collections.max(newUserNumbers));
        }

        if (usersMaxValue.get(0) > usersMaxValue.get(1)) {
            return 1;
        } else if (usersMaxValue.get(0) < usersMaxValue.get(1)) {
            return 2;
        }
        return 0;
    }

}