package onboarding;

import java.util.List;

class Problem1 {
    private static int numSum(String[] num){


    }
    private static int numMult(String[] num){ // sum, mult따로 호출시 자릿수 계산을 따로따로 두번해줘야 하므로 자릿수 만 구해서 MAx값을 리턴해주는 메서드 구현

    }
    private int numAdmin(List<Integer> arr){
        try { //자릿수 가져오기
            if (arr.get(1)-arr.get(0)!=1){
                return -1;
            }
            String arr2=arr.get(0).toString();

        }catch (IndexOutOfBoundsException e){ //리스트 가져오는 과정에서 예외처리
            return -1;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}