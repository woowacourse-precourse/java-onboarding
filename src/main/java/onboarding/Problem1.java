package onboarding;

import java.util.List;

class Problem1 {
    private static int numSum(char[] num){
        int sum = 0;
        for(int i =0;i<num.length;i++){
            sum+=Character.getNumericValue(num[i]);
        }
        return sum;
    }
    private static int numMult(char[] num){ // sum, mult따로 호출시 자릿수 계산을 따로따로 두번해줘야 하므로 자릿수 만 구해서 MAx값을 리턴해주는 메서드 구현

    }
    private static int numAdmin(List<Integer> arr){
        try {
            if (arr.get(1)-arr.get(0)!=1){
                return -1;
            }
            char[] arr1=arr.get(0).toString().toCharArray(); //char 배열로 변환
            char[] arr2=arr.get(1).toString().toCharArray();
            return Math.max(Math.max(numSum(arr2),numMult(arr2)),Math.max(numSum(arr1),numMult(arr1)));
        }catch (IndexOutOfBoundsException e){ //리스트 가져오는 과정에서 예외처리
            return -1;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int answer1 = numAdmin(pobi);
        int answer2 = numAdmin(crong);
    }
}