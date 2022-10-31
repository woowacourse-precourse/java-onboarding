package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외사항 검출
        if (!bookExpandException(pobi, crong)) return -1;

        //포비와 크롱의 좌우 페이지 번호의 각자리 숫자 추출
        //[[왼쪽 페이지 번호 각자리 숫자 추출],[오른쪽 페이지 번호 각자리 숫자 추출]]
        String[][] pobi_each_num_arr =
                {String.valueOf(pobi.get(0)).split(""),String.valueOf(pobi.get(1)).split("")};
        String[][] crong_each_num_arr =
                {String.valueOf(crong.get(0)).split(""),String.valueOf(crong.get(1)).split("")};

        int pobi_score = 0; //포비의 점수
        int crong_score = 0; //크롱의 점수
        for (int i = 0; i < 2; i++){
            int pobi_sum = 0; //포비 해당페이지 각 숫자의 합
            int pobi_multi = 1; //포비 해당페이지 각 숫자의 곱
            int crong_sum = 0; //크롱 해당페이지 각 숫자의 합
            int crong_multi = 1; //크롱 해당페이지 각 숫자의 곱
            for (int j = 0; j < pobi_each_num_arr[i].length; j++){ //포비
                pobi_sum += Integer.parseInt(pobi_each_num_arr[i][j]); //2과정
                pobi_multi *= Integer.parseInt(pobi_each_num_arr[i][j]); //3과정
            }
            for (int j = 0; j < crong_each_num_arr[i].length; j++) { //크롱
                crong_sum += Integer.parseInt(crong_each_num_arr[i][j]); //2과정
                crong_multi *= Integer.parseInt(crong_each_num_arr[i][j]); //3과정
            }
            pobi_score = max_score(pobi_score, max_score(pobi_sum, pobi_multi)); //4과정
            crong_score = max_score(crong_score, max_score(crong_sum, crong_multi)); //4과정
        }

        if (pobi_score > crong_score) return 1; //포비가 이길 경우
        else if (pobi_score < crong_score) return 2; //크롱이 이길 경우
        else return 0; //무승부일 경우
    }

    //둘 중 높은 점수 출력 메소드
    private static int max_score(int a, int b){
        if (a > b) return a;
        else return b;
    }

    /*
    예외사항 체크 - 각 페이지 번호 차이가 1이 아닌 경우 적용
    그 외 시작면이나 마지막 면이 나오도록 펼치는 경우나
    왼쪽 페이지 짝수 or 오른쪽 페이지 홀수인 경우 등은 문제에서 명시했기 때문에
    페이지 번호 차이만 적용
     */
    private static boolean bookExpandException(List<Integer> pobi, List<Integer> crong){
        if (1 != Math.abs(pobi.get(1) - pobi.get(0))) return false;
        else if (1 != Math.abs(crong.get(1) - crong.get(0))) return false;
        return true;
    }
}