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
            answer = (pobiScore > crongScore) ? 1 : ((pobiScore < crongScore) ? 2 : 0);

        } catch(Exception e) {
            answer = -1;
        }
        return answer;
    }

    private static Boolean getIsValid(List<Integer> pageList) {
        Boolean leftPageValidity = pageList.get(0) % 2 == 1; // 왼쪽 페이지는 홀수
        Boolean rightPageValidity = pageList.get(1) % 2 == 0; // 오른쪽 페이지는 짝수
        Boolean bothPageValidity = pageList.get(1) == pageList.get(0) + 1; // 왼쪽, 오른쪽은 1페이지 차이
        Boolean notFrontOrEnd = pageList.get(0) != 1 && pageList.get(1) != 400; // 시작 면이나 마지막 면이 나오도록 책을 펼치지 않음
        return notFrontOrEnd && leftPageValidity && rightPageValidity && bothPageValidity;
    }

    private static int getScore(List<Integer> pageList) {

        ArrayList<Integer> resArr = new ArrayList<>();  // arraylist to get four numbers => [16,17,63,72]

        for (int page: pageList){
            parseAndAdd(resArr, page);
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

    private static void parseAndAdd(ArrayList<Integer> resArr, int page) {
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