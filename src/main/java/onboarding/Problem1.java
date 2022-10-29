package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static <e> int solution(List<Integer> pobi, List<Integer> crong) {
        
        int answer = 0;

        try{

            // validation test
            Exception e = new Exception("[왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있지 않음.");
            Boolean isPobiValid = getIsValid(pobi);
            Boolean isCrongValid = getIsValid(crong);
            if(!isPobiValid || !isCrongValid){
                throw e;
            }

            // get score
            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);

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

    private static Boolean getIsValid(List<Integer> pageList) {
        Boolean check1 = pageList.get(0) % 2 == 1 && pageList.get(1) % 2 == 0 && pageList.get(1) == pageList.get(0) + 1;
        Boolean check2 = pageList.get(0) != 1 && pageList.get(1) != 400;
        Boolean isValid = check1 && check2;
        return isValid;
    }

    private static int getScore(List<Integer> pageList) {
        int[] resArr = new int[4];
        for (int i = 0; i < pageList.size(); i++){
            int[] numValue = Stream.of(String.valueOf(pageList.get(i)).split("")).mapToInt(Integer::parseInt).toArray();
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