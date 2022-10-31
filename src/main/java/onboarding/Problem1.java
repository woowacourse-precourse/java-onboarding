package onboarding;

import java.util.List;

class Problem1 {
    /**
     *  1. 왼쪽/오른 쪽 페이지 번호의 각 자리 숫자를 모두 더한 값을 구하는 부분 구현
     *  2. 왼쪽/오른 쪽 페이지 번호의 각 자리 숫자를 모두 곱한 값을 구하는 부분 구현
     *  3. 포비가
     *  3. 포비와 크롱의 점수를 비교해서 결과 값을 반환한다.(포비가 이기면 1, 크롱이 이기면 2, 무승부는 0, 예외사항 -1)
     **/
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_plus_value, crong_plus_value; //각 자리수의 값을 더한 것 중 가장 큰 값
        int pobi_multiple_value, crong_multiple_value; //각 자리수의 값을 곱한 것 중 가장 큰 값
        int pobi_max_value, crong_max_value; //가장 큰 결과

        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1 )
            return -1;

        /**
         * 각 자리수를 더한 것 중 더 큰 페이지의 값 구하기
         * */
        crong_plus_value = plusValue(crong.get(0)) > plusValue(crong.get(1)) ? plusValue(crong.get(0)) : plusValue(crong.get(1));
        pobi_plus_value = plusValue(pobi.get(0)) > plusValue(pobi.get(1)) ? plusValue(pobi.get(0)) : plusValue(pobi.get(1));

        /**
         * 각 자리수를 곱한 것 중 더 큰 페이지의 값 구하기
         * */
        crong_multiple_value = multipleValue(crong.get(0)) > multipleValue(crong.get(1)) ? multipleValue(crong.get(0)) : multipleValue(crong.get(1));
        pobi_multiple_value = multipleValue(pobi.get(0)) > multipleValue(pobi.get(1)) ? multipleValue(pobi.get(0)) : multipleValue(pobi.get(1));

        /**
         * 각 자리 수를 더한 값과 곱한 값 중 더 큰 값을 포비와 크롱의 값으로 한다.
         * */
        pobi_max_value = pobi_multiple_value > pobi_plus_value ? pobi_multiple_value : pobi_plus_value;
        crong_max_value = crong_multiple_value > crong_plus_value ? crong_multiple_value : crong_plus_value;

        System.out.println("pobi" + "\t" + "crong" + "\t" + "result");

        /**
         * 승자 가리기
         * */
        if(pobi_max_value > crong_max_value) {
            answer = 1;
        }
        else if(pobi_max_value < crong_max_value) {
            answer = 2;
        }
        else if(pobi_max_value == crong_max_value) {
            answer = 0;
        }

        System.out.println("[" + pobi.get(0) + ", " + pobi.get(1) + "]\t" + "[" + crong.get(0) + ", " + crong.get(1) + "]\t" + answer);

        return answer;
    }

    /**
     * 각 자리 숫자들을 더한 결과를 반환하는 함수
     * */
    public static int plusValue(int page) {
        int result = 0;
        int len = String.valueOf(page).length(); //숫자의 길이

        for(int i = 0; i < len; i++) {
            result += page % 10;

            page = page / 10;
        }

        return result;
    }

    /**
     * 각 자리 숫자들을 곱한 결과를 반환하는 함수
     * */
    public static int multipleValue(int page) {
        int result = 1;
        int len = String.valueOf(page).length(); //숫자의 길이

        for(int i = 0; i < len; i++) {
            result *= page % 10;

            page = page / 10;
        }

        return result;
    }
}