package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // ---------- 예외 상황 확인 ----------
        // 각 List에 요소가 2개인지 확인
        if(pobi.size() != 2 || crong.size() != 2) return getException("리스트의 요소가 2가 아닙니다.");
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
        // 페이지가 1~400 인지 확인
        if(!isInRange(pobiLeft) || !isInRange(pobiRight) || !isInRange(crongLeft)
                || !isInRange(crongRight)) return getException("페이지의 범위가 1~400이 아닙니다.");;
        // 왼쪽 페이지 번호가 홀수인지 확인
        if(pobiLeft % 2 != 1 || crongLeft % 2 != 1) return getException("왼쪽 페이지가 홀수가 아닙니다.");;
        // 오른쪽 페이지가 왼쪽페이지 다음 페이지인지 확인
        if(pobiRight != pobiLeft + 1 || crongRight != crongLeft + 1) return getException("오른쪽 페이지가 왼쪽의 다음 페이지가 아닙니다.");;
        // --------------------------------
        // 포비와 크롱의 점수 구하기
        int pobiScore = Integer.max(getMaxScore(pobiLeft), getMaxScore(pobiRight));
        int crongScore = Integer.max(getMaxScore(crongLeft), getMaxScore(crongRight));
        System.out.println("pobi: " + pobiScore + " crong: " + crongScore);
        // 점수가 같으면 무승부
        if(pobiScore == crongScore) return 0;
        if(pobiScore > crongScore) return 1;
        else return 2;
    }
    // 예외 상황 발생시 메세지 출력 후 -1 반환
    static int getException(String message){
        System.out.println(message);
        return -1;
    }
    // 페이지가 범위 내에 있는지(시작이나 마지막면 제외)
    static boolean isInRange(int value) {
        return value > MIN_PAGE && value < MAX_PAGE;
    }
    // 페이지를 넣으면 각 자리의 합과 곱중에 큰 수를 반환한다.
    static int getMaxScore(Integer page) {
        List<Integer> newList = new ArrayList<>();
        int num = page;
        while (num > 0) {
            newList.add(num % 10);
            num /= 10;
        }
        int sum = 0;
        int duplecate = 1;
        for(int i : newList) {
            sum += i;
            duplecate *= i;
        }
        return sum >= duplecate ? sum : duplecate;
    }



}
