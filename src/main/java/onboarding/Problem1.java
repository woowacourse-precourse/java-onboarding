package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        boolean isValid;

        // 예외 사항 처리 메소드 호출
        isValid = validData(pobi, crong);

        if (isValid) {
            answer = calcData(pobi, crong);
        } else {
            answer = -1;
        }

        return answer;
    }

    // 예외 사항 처리 메소드
    static boolean validData(List<Integer> pobi, List<Integer> crong) {
        boolean isValid = true;

        // 페이지 번호가 범위 내인지 검증
        for(Integer page: pobi) {
            if (page < 0 | page > 400) {
                isValid = false;
                break;
            }
        }

        for(Integer page: crong) {
            if (page < 0 | page > 400) {
                isValid = false;
                break;
            }
        }

        // 페이지 번호의 차가 1인지 (서로 마주보고 있는 페이지인지 검증)
        if (pobi.get(1) - pobi.get(0) != 1) {
            isValid = false;
        } else if (crong.get(1) - crong.get(0) != 1) {
            isValid = false;
        }

        // 두 페이지의 번호가 홀수와 짝수인지
        if ((pobi.get(0) % 2 == 0) | (pobi.get(1) % 2 != 0)) {
            isValid = false;
        } else if ((crong.get(0) % 2 == 0) | (crong.get(1) % 2 != 0)) {
            isValid = false;
        }

        return isValid;
    }

    // 점수 산출 후 승자 결정하는 메소드
    static int calcData(List<Integer> pobi, List<Integer> crong) {
        int result = Integer.MAX_VALUE;

        List<int[]> pobiPage = new ArrayList<>();
        List<int[]> crongPage = new ArrayList<>();

        int pobiScore = 0;
        int crongScore = 0;

        for (int i = 0; i < 2; i ++) {
            pobiPage.add(i, Stream.of(String.valueOf(pobi.get(i)).split(""))
                    .mapToInt(Integer::parseInt).toArray());
            crongPage.add(i, Stream.of(String.valueOf(crong.get(i)).split(""))
                    .mapToInt(Integer::parseInt).toArray());
        }

        // pobi의 점수 산출
        for (int[] page: pobiPage) {
            int tempSum = 0;
            int tempMultiply = 1;
            int tempMaxVal;

            for (int num: page) {
                tempSum += num;
            }

            for (int num: page) {
                tempMultiply *= num;
            }

            tempMaxVal = Math.max(tempSum, tempMultiply);

            if (pobiScore < tempMaxVal) {
                pobiScore = tempMaxVal;
            }
        }

        // crong의 점수 산출
        for (int[] page: crongPage) {
            int tempSum = 0;
            int tempMultiply = 1;
            int tempMaxVal;

            for (int num: page) {
                tempSum += num;
            }

            for (int num: page) {
                tempMultiply *= num;
            }

            tempMaxVal = Math.max(tempSum, tempMultiply);

            if (crongScore < tempMaxVal) {
                crongScore = tempMaxVal;
            }
        }

        // 점수 비교 후 조건문을 통해 반환 값 결정
        if (pobiScore == crongScore) {
            result = 0;
        } else if (pobiScore > crongScore) {
            result = 1;
        } else if (pobiScore < crongScore) {
            result = 2;
        }

        return result;
    }
}
