package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validateInput(pobi) || !validateInput(crong)) {
            return -1;
        }
        int pobiNum = findMax(pobi);
        int crongNum = findMax(crong);
        if (pobiNum < crongNum) {
            return 2;
        } else if (pobiNum > crongNum) {
            return 1;
        } else if (pobiNum == crongNum) {
            return 0;
        }
        return -1;

    }

    public static boolean validateInput(List<Integer> input){
        if (input == null) {
            // 페이지 번호가 null 인지 확인
            return false;
        }else if (input.get(0) == 0 && input.get(0)>= 400 && input.get(1) == 0 && input.get(1)>= 400){
            // 페이지의 범위가 1-400 인지 확인
            return false;
        }else if (input.get(0) % 2 != 1 || input.get(1) != input.get(0)+1) {
            // 왼쪽 페이지 번호가 홀수이고, 오른쪽 페이지 번호가 왼쪽 페이지 번호 + 1 인지 확인
            return false;
        }
        return true;
    }

    public static int addEachDigit(int input){
        int sum = 0;
        while (input != 0) {
            sum += input % 10;
            input /= 10;
        }
        return sum;
    }

    public static int multipleEachDigit(int input) {
        int sum = 1;
        while (input != 0) {
            sum *= input % 10;
            input /= 10;
        }
        return sum;
    }

    public static int findMax(List<Integer> input) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(addEachDigit(input.get(0)));
        numbers.add(multipleEachDigit(input.get(0)));
        numbers.add(addEachDigit(input.get(1)));
        numbers.add(multipleEachDigit(input.get(1)));
        int max = numbers.stream()
                .mapToInt(x -> x)
                .max()
                .getAsInt();
        return max;
    }
}