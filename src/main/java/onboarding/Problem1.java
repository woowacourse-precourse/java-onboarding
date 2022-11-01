package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong){
        int answer;
        try {
            constraint1(pobi);
            constraint1(crong);

            int pobi_score = score(pobi);
            int crong_score = score(crong);

            answer = result(pobi_score, crong_score);
        }catch(Exception e) {
            System.out.println("Problem1 exception : " + e.getMessage());
            return -1;
        }
        return answer;
    }

    //리스트의 제한사항을 검사하는 constraint
    static void constraint1(List<Integer> pages) throws Exception {
        //주어진 페이지들이 연속된 페이지인지 확인한다.
        int leftpage = pages.get(0);
        int rightpage = pages.get(1);

        if (leftpage % 2 == 0) {
            throw new Exception("좌측 페이지는 홀수이어야 합니다.");
        }
        if (leftpage + 1 != rightpage) {
            throw new Exception("두페이지는 연속되어야 합니다.");
        }
        if(pages.size() != 2){
            throw new Exception("페이지는 두 장만 주어져야 합니다.");
        }
        if(leftpage < 1 || rightpage > 400) {
            throw new Exception("페이지는 1~400 사이어야 합니다.");
        }
    }
    //리스트에서 가장 큰 수를 점수로 반환하는 score
    static int score(List<Integer> pages) {
        int final_score = 0;
        for (int i = 0; i <= 1; i++) {
            int page = pages.get(i);
            int size = (int)Math.log10(page);
            int add = 0;
            int mul = 1;
            for (int j = 0; j <= size ; j++) {
                int n = page%10;
                add += n;
                mul *= n;
                page /= 10;
            }
            int temp_score = Math.max(add,mul);
            final_score = Math.max(final_score, temp_score);
        }
        return final_score;
    }

    // 승자 판별
    static int result(int pobi_score, int crong_score)throws Exception {
        if (pobi_score > crong_score) {
            return 1;
        } else if (pobi_score < crong_score) {
            return 2;
        } else if (pobi_score == crong_score) {
            return 0;
        }
        throw new Exception("논리 오류.");
    }
}