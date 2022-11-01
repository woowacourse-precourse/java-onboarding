package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    static int ERROR = -1;
    static int DRAW = 0;
    static int POBI_WIN = 1;
    static int CRONG_WIN = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkValidation(pobi) || !checkValidation(crong))
            return ERROR;

        Integer pobiMaxNum = calculateMaxPage(pobi);
        Integer crongMaxNum = calculateMaxPage(crong);


        if(pobiMaxNum > crongMaxNum){
            return POBI_WIN;
        }else if(pobiMaxNum < crongMaxNum){
            return CRONG_WIN;
        }else{
            return DRAW;
        }
    }

    static Integer calculateMaxPage(List<Integer> numList) {
        Integer maxPage = 0;

        for(Integer num : numList){
            List<Integer> stringNumList = Arrays.stream(num.toString().split("")).
                    map(n -> Integer.parseInt(n)).
                    collect(Collectors.toList());

            int plusPage = plusPage(stringNumList);
            int multipleMax = multiplePage(stringNumList);

            if(plusPage > maxPage){
                maxPage = plusPage;
            }

            if(multipleMax > maxPage){
                maxPage = multipleMax;
            }
        }

        return maxPage;
    }

    private static int multiplePage(List<Integer> page) {
        int result = 1;
        for(int i = 0; i < page.size(); i++){
            result *= page.get(i);
        }
        return result;
    }

    static int plusPage(List<Integer> page){
        int result = 0;
        for(int i = 0; i < page.size(); i++){
            result += page.get(i);
        }
        return result;
    }

    static boolean checkValidation(List<Integer> pages){
        if(pages.get(0) < 2 || pages.get(1) > 398)  //책 범위 검사
            return false;

        if(pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0)    //페이지 홀짝 검사
            return false;

        if(pages.get(1) - pages.get(0) != 1)    //1페이지 차이 검사
            return false;

        return true;
    }


}