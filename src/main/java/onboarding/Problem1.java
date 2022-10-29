package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        // !!! Try New Method for Cleaning the code
        // if pageList => [97,98]
        // get four numbers => [16,17,63,72]
        // parse ints 97 => 9 & 7
        // add or multiply ints => 16, 63
        // add to resList => get Max by sorting

        ArrayList<Integer> resArr = new ArrayList<>();

        for (int page: pageList){
            String pageStr = Integer.toString(page);
            String[] parsedPage = pageStr.split(""); // [9,7]
            int addRes = 0;
            int multRes = 1;
            for (String StrParsed: parsedPage){
                addRes += Integer.parseInt(StrParsed);
                multRes *= Integer.parseInt(StrParsed);
            }
            resArr.add(addRes);
            resArr.add(multRes);
        }
        Collections.sort(resArr);
        System.out.println(resArr);

        return resArr.get(3);
    }
}