package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    /* checkOddEven: 왼쪽 페이지인 경우 홀수인지, 오른쪽 페이지인 경우 짝수인지 확인하는 함수 */
    //맞으면 1, 틀리면 0 리턴
    public static int checkOddEven(int index, int num){
        if(index==0) {
            if (num % 2 == 1) return 1;
        } else if (index==1) {
            if (num%2==0) return 1;
        }
        return 0;
    }
    /* getDigit: 각 자리수 추출하는 함수 */
    public static int[] getDigit(int num){
        String str = Integer.toString(num);
        int[] nums = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            nums[i] = str.charAt(i) - '0';
        }
        return nums;
    }
    /* compare: 페이지 번호의 각 자리 숫자를 더하기, 곱하기해서 그 중 큰 수를 리턴하는 함수 */
    public static int compare(int num){
        int[] nums = getDigit(num);
        int plus = 0;
        int multi = 1;
        for(int i=0; i<nums.length; i++){
            plus += nums[i];
            multi *= nums[i];
        }
        return Math.max(plus,multi);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobi_re  = new ArrayList<Integer>();
        List<Integer> crong_re  = new ArrayList<Integer>();

        //왼쪽 페이지가 오른쪽 페이지보다 1작은지 확인
        if(pobi.get(0)+1 != pobi.get((1))) return -1;
        if(crong.get(0)+1 != crong.get((1))) return -1;

        for(int i=0; i<2; i++){
            // 각 페이지가 시작면과 마지막 면인지, 왼쪽 페이지인 경우 홀수인지, 오른쪽 페이지인 경우 오른쪽인지 확인. 조건 하나라도 아니라면 예외사항으로 간주
            if((pobi.get(i) == 1) | (pobi.get(i) == 400) | (crong.get(i) == 1) | (crong.get(i) == 400) | (checkOddEven(i, pobi.get(i))!=1)| (checkOddEven(i, crong.get(i))!=1)){
                return -1;
            }
            pobi_re.add(compare(pobi.get(i)));
            crong_re.add(compare(crong.get(i)));
        }

        // 왼쪽 페이지와 오른쪽 페이지 중 큰 수 구하기
        int pobi_max = Math.max(pobi_re.get(0), pobi_re.get(1));
        int crong_max = Math.max(crong_re.get(0), crong_re.get(1));

        //포비와 크롱의 페이지를 비교했을때 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0
        if(Integer.compare(pobi_max, crong_max)==1){
            answer = 1;
        } else if (Integer.compare(pobi_max, crong_max)==-1) {
            answer = 2;
        } else{
            answer = 0;
        }

        return answer;
    }
}
