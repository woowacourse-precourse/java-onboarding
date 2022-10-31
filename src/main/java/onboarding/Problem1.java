package onboarding;

import java.util.List;

class Problem1 {

    static final int INVALID = -1;
    static final int DRAW = 0;
    static final int POBI_WINS = 1;
    static final int CRONG_WINS = 2;

    /*
    포비와 크롱의 페이지 스코어 대결
    @param pobi : 포비의 왼쪽 오른쪽 페이지
    @param crong : 크롱의 왼쪽 오른쪽 페이지
    @return 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(invaild(pobi) || invaild(crong)) return INVALID;
        
        int pobiScore = getMax(pobi);
        int crongScore = getMax(crong);

        if(pobiScore == crongScore) return DRAW;
        else if (pobiScore > crongScore) return POBI_WINS;
        else return CRONG_WINS;
    }

    /*
    페이지 자릿수 더하기
    @param num : 페이지
    @return 페이지 자릿수 더하기 결과 반환
     */
    public static int getSumOfPageDigits(int num){
        int sum = 0;

        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    /*
    페이지 자릿수 곱하기
    @param num : 페이지
    @return 페이지 자릿수 곱하기 결과 반환
     */
    public static int getProductOfPageDigits(int num){
        int product = 1;

        while(num > 0){
            product *= num % 10;
            num /= 10;
        }

        return product;
    }

    /*
    먼저 왼쪽 페이지의 페이지 합과 곱 비교 후 오른쪽 페이지 비교
    @param list : 페이지 리스트
    @return 최댓값 페이지 반환
     */
    public static int getMax(List<Integer> list){
        int page = list.get(0);

        int score = Math.max(getSumOfPageDigits(page), getProductOfPageDigits(page));

        page += 1;

        score = Math.max(score, getSumOfPageDigits(page));
        score = Math.max(score, getProductOfPageDigits(page));

        return score;
    }

    /*
    제한 사항 준수 여부 파악
    @param list : 페이지 리스트
    @return 왼쪽 페이지가 짝수거나 왼쪽 오른쪽 페이지가 잘못 매칭 되었을 경우 참을 반환,
            페이지 범위를 넘었을 경우에도 참을 반환.
     */
    public static boolean invaild(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) return true;
        if(left%2 == 0) return true;
        return outOfBound(left) || outOfBound(right);
    }


    public static boolean outOfBound(int num){
        return num < 1 || num > 400;
    }
}