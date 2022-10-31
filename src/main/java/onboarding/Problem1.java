package onboarding;

import java.util.List;

/*
페이지의 두 수가 모두 2보다 크면 곱하는 값이 더하는 값보다 커지기 때문에
맨 처음 페이지를 입받지 않으므로, 곱하는 값만 비교함.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        //두 배열의 사이즈가 2가 아닐경우
        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        }
        //페이지의 정보가 옳지 않을 경우
        if ((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) {
            return -1;
        }
        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            return -1;
        }
        if (pobi.get(0) <= 1 || crong.get(0) <= 1) {
            return -1;
        }
        if (pobi.get(1) >= 400 || crong.get(0) >= 400) {
            return -1;
        }
        //비김
        if (multi(pobi) == multi(crong)) {
            return 0;
        }
        //pobi가 이김 : crong 이김
        answer = multi(pobi) > multi(crong) ? 1 : 2;
        return answer;
    }

    //숫자를 곱하여 출력하는 Method.
    static int multi(List<Integer> cuteGuy) {
        int num1 = multiOne(cuteGuy.get(0));
        int num2 = multiOne(num1 + 1);
        return num1 * num2;
    }

    static int multiOne(int num) {
        int num1 = num / 100 == 0 ? 1 : num / 100;
        int num2 = (num / 100) == 0 && ((num % 100) / 10) == 0 ? 1 : ((num % 100) / 10);
        int num3 = (num % 10) / 1;
        return num1 * num2 * num3;
    }
}