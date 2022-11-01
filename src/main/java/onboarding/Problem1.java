package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0;
        int crongScore = 0;

        // 예외 사항이 있다면 -1 리턴
        if (checkException(pobi, crong)) {
            answer = -1;
            return answer;
        }

        // 포비의 점수를 계산하는 메서드 호출
        pobiScore = calculationPobi(pobi);

        // 크롱의 점수를 계산하는 메서드 호출
        crongScore = calculationCrong(crong);

        // 포비와 크롱의 점수를 비교하는 메서드 호출
        answer = compareScore(pobiScore, crongScore);

        return answer;
    }

    // 예외 사항이 있는지 검사하는 메서드
    static boolean checkException(List<Integer> pobi, List<Integer> crong) {
        boolean pobiException = false;
        boolean crongException = false;
        for (int i = 0; i < 2; i++) {
            if (pobi.get(1) - pobi.get(0) != 1) {
                pobiException = true;
                break;
            }
            if ((pobi.get(0) > 400 || pobi.get(0) < 0) || (pobi.get(1) > 400 || pobi.get(1) < 0)) {
                pobiException = true;
                break;
            }
            if (crong.get(1) - crong.get(0) != 1) {
                crongException = true;
            }
            if ((crong.get(0) > 400 || crong.get(0) < 0) || (crong.get(1) > 400 || crong.get(1) < 0)) {
                crongException = true;
                break;
            }
        }
        return pobiException || crongException;
    }

    // 포비의 점수를 계산하는 메서드
    static int calculationPobi(List<Integer> pobi) {
        String[] left = String.valueOf(pobi.get(0)).split("");
        int leftMax = 0;
        int sumLeft = 0;
        int multipleLeft = 1;
        for (int i = 0; i < left.length; i++) {
            sumLeft += Integer.parseInt(left[i]);
            multipleLeft *= Integer.parseInt(left[i]);
            leftMax = Math.max(sumLeft, multipleLeft);
        }

        String[] right = String.valueOf(pobi.get(1)).split("");
        int rightMax = 0;
        int sumRight = 0;
        int multipleRight = 1;
        for (int i = 0; i < right.length; i++) {
            sumRight += Integer.parseInt(right[i]);
            multipleRight *= Integer.parseInt(right[i]);
            rightMax = Math.max(sumRight, multipleRight);
        }

        return Math.max(leftMax, rightMax);
    }

    // 크롱의 점수를 계산하는 메서드
    static int calculationCrong(List<Integer> crong) {
        String[] left = String.valueOf(crong.get(0)).split("");
        int leftMax = 0;
        int sumLeft = 0;
        int multipleLeft = 1;
        for (int i = 0; i < left.length; i++) {
            sumLeft += Integer.parseInt(left[i]);
            multipleLeft *= Integer.parseInt(left[i]);
            leftMax = Math.max(sumLeft, multipleLeft);
        }

        String[] right = String.valueOf(crong.get(1)).split("");
        int rightMax = 0;
        int sumRight = 0;
        int multipleRight = 1;
        for (int i = 0; i < right.length; i++) {
            sumRight += Integer.parseInt(right[i]);
            multipleRight *= Integer.parseInt(right[i]);
            rightMax = Math.max(sumRight, multipleRight);
        }

        return Math.max(leftMax, rightMax);
    }

    // 포비와 크롱의 점수를 비교하는 메서드
    static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }
}