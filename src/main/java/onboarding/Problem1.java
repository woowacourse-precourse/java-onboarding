package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static <e> int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        try{

            int[] pobiArr = pobi.stream().mapToInt(i->i).toArray();
            int[] crongArr = crong.stream().mapToInt(i->i).toArray();

            Exception e = new Exception("[왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있지 않음.");

            Boolean isPobiValid = getIsValid(pobiArr);
            Boolean isCrongValid = getIsValid(crongArr);

            if(!isPobiValid || !isCrongValid){
                throw e;
            }

            int pobiScore = getMax(pobiArr);
            int crongScore = getMax(crongArr);

            if(pobiScore > crongScore){
                answer = 1;
                System.out.println("Pobi win");
            }else if(pobiScore < crongScore){
                answer = 2;
                System.out.println("Crong win");
            }else{
                answer = 0;
                System.out.println("무승부");
            }
        } catch(Exception e) {
            answer = -1;
        }
        return answer;
    }

    private static Boolean getIsValid(int[] arr) {
        Boolean check1 = arr[0] % 2 == 1 && arr[1] % 2 == 0 && arr[1] == arr[0] + 1;
        Boolean check2 = arr[0] != 1 && arr[1] != 400;
        Boolean isValid = check1 && check2;
        return isValid;
    }

    private static int getMax(int[] arr) {
        int[] resArr = new int[2];
        for (int i = 0; i < arr.length; i++){
            int[] numValue = Stream.of(String.valueOf(arr[i]).split("")).mapToInt(Integer::parseInt).toArray();
            int addRes = 0;
            int multRes = 1;
            for (int num: numValue){
                addRes += num;
                multRes *= num;
            }
            if(addRes>multRes){
                resArr[i]=addRes;
            }else{
                resArr[i]=multRes;
            }
        }
        int pobiMax = resArr[0];
        for(int i=1 ; i<resArr.length ; i++) {
            if(resArr[i]>pobiMax) {
                pobiMax = resArr[i];
            }
        }
        return pobiMax;
    }
}