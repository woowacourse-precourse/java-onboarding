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

            // get winner
            if(pobiScore > crongScore){
                answer = 1;
            }else if(pobiScore < crongScore){
                answer = 2;
            }else{
                answer = 0;
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

        ArrayList<Integer> resArr = new ArrayList<>();  // arraylist to get four numbers => [16,17,63,72]

        for (int page: pageList){
            pareAndAdd(resArr, page);
            parseAndMult(resArr, page);
        }
        Collections.sort(resArr); // get Max by sorting
        return resArr.get(3);
    }

    private static void parseAndMult(ArrayList<Integer> resArr, int page) {
        String[] parsedPage = parseInt(page);
        int multRes = 1;
        for (String StrParsed: parsedPage){ // 97 => 9 * 7 = 63
            multRes *= Integer.parseInt(StrParsed);
        }
        resArr.add(multRes);
    }

    private static void pareAndAdd(ArrayList<Integer> resArr, int page) {
        String[] parsedPage = parseInt(page);
        int addRes = 0;
        for (String StrParsed: parsedPage){ // 97 => 9 + 7 = 16
            addRes += Integer.parseInt(StrParsed);
        }
        resArr.add(addRes);
    }

    private static String[] parseInt(int page) {
        // parse ints 97 => 9 & 7
        String pageStr = Integer.toString(page);
        String[] parsedPage = pageStr.split("");
        return parsedPage;
    }
}