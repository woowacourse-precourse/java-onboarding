package onboarding;
import java.util.List;

/**
 * 요구사항
 * 각각 리스트(pobi와 crong)에서 두 수를 받아서 각 자리 숫자를 더하거나 곱해 두 수 중 가장 큰 수를 구한다.
 * 비교해서 밑 조건과 같게 출력한다.
 * pobi win 1
 * crong win 2
 * 무승부 3
 * 예외 -1
 */


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외상황 1 : 시작면 or 마지막 면 일 경우(페이지가 1개일 경우)
        if (pobi.size() <= 1 ||crong.size() <= 1){
            return -1;
        }

        int answer;
        int pobi_num = bigNum(pobi);
        int crong_num = bigNum(crong);
        //예외상황 2 : 연속하는 페이지가 아닌 번호일 경우
        if (pobi_num == -1 || crong_num == -1){
            return -1;
        }
        //요구사항 -1, 0, 1, 2 처리
        if (pobi_num == crong_num){
            //무승부
            answer = 0;
        }else if (pobi_num>crong_num) {
            //pobi win
            answer = 1;
        }else if(pobi_num<crong_num){
            //crong win
            answer = 2;
        }else {
            //예외
            answer = -1;
        }
        return answer;

    }


    public static int bigNum(List<Integer> array){
        int left = array.get(0);
        int right = array.get(1);
        if ((right-left)!=1){
            return -1;
        }
        int cal_left = cal(left);
        int cal_right = cal(right);

        if(cal_left > cal_right){
            return cal_left;
        }else {
            return cal_right;
        }
    }

    public static int cal(int num){
        char[] nums = String.valueOf(num).toCharArray();
        int add = Character.getNumericValue(nums[0]);
        int mul = Character.getNumericValue(nums[0]);
        for(int i=1; i < nums.length;i++){
            add = (add + Character.getNumericValue(nums[i]));
            mul = (mul * Character.getNumericValue(nums[i]));
        }
        if (mul > add){
            return mul;
        }else {
            return add;
        }
    }
}