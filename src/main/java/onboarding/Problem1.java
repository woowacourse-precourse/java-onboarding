package onboarding;

import java.util.*;

class Problem1 {

    /**
     *  인풋 유효성 검사
     *  1. 리스트 사이즈가 2인지 체크
     *  2. 리스트의 값이 첫 페이지이거나 마지막 페이지인지 검사
     *  3. 리스트의 왼쪽이 홀수인지 오른쪽이 짝수인지 검사
     *  4. 리스트의 왼쪽과 오른쪽이 1차이 나는지 검사
     */
    private static boolean validateInput(List<Integer> list) {
        if(list.size() != 2)
            return false;
        if(list.get(0) < 1 || list.get(0) > 399 || list.get(1) < 2 || list.get(1) > 400)
            return false;
        if(list.get(0) % 2 != 1 || list.get(1) % 2 != 0)
            return false;
        if(!list.get(1).equals(list.get(0)+1))
            return false;
        return true;
    }

    // 페이지를 입력받아 각 자리수로 쪼갠 리스트를 리턴하는 메서드
    private static List<Integer> makeEachDigitFromPageNumber(int pageNumber) {
        ArrayList<Integer> eachDigit = new ArrayList<>();
        while(pageNumber > 0) {
            eachDigit.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return eachDigit;
    }

    // 각 자리수의 곱을 리턴하는 메서드
    private static int getMulFromEachDightOfPageNumber(List<Integer> eachDigit) {
        return eachDigit.stream().reduce((total, n) -> total + n).get();
    }

    // 각 자리수의 합을 리턴하는 메서드
    private static int getSumFromEachDightOfPageNumber(List<Integer> eachDigit) {
        return eachDigit.stream().reduce(1, (total, n) -> total * n);
    }

    // 최종 점수를 구하는 메서드
    private static int getScore(List<Integer> pages) {
        int answer = Integer.MIN_VALUE;
        for (Integer page : pages) {
            List<Integer> eachNumber = makeEachDigitFromPageNumber(page);
            answer = Math.max(answer, Math.max(getSumFromEachDightOfPageNumber(eachNumber), getMulFromEachDightOfPageNumber(eachNumber)));
        }
        return answer;
    }

    // 우승자를 구하는 메서드드
    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore)
            return 1;
        else if (pobiScore == crongScore)
            return 0;
        else
            return 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!validateInput(pobi) || !validateInput(crong))
            return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return getWinner(pobiScore, crongScore);
    }
}