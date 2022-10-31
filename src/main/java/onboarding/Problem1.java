package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(errorPage(pobi,crong)){
            return -1;
        }
        return whoIsTheWinner(findPobiAndCrongPageMax(pobi,crong)).indexOf(true);
    }
    private static int pageMax(String[] pageList){
        Map<String,Integer> pageMap = putPageMap(pageList);
        if(pageMap.get("plusPage")>pageMap.get("multiPage")){
            return pageMap.get("plusPage");
        }
        return pageMap.get("multiPage");
    }
    private static HashMap<String,Integer> pageObject(){
        Map<String,Integer> pageMap = new HashMap<>();
        pageMap.put("plusPage",0);
        pageMap.put("multiPage",1);
        return (HashMap<String, Integer>) pageMap;
    }
    private static Map<String, Integer> putPageMap(String[] pageList) {
        Map<String,Integer> pageMap = pageObject();
        for (String number : pageList) {
            int num = Integer.parseInt(number);
            pageMap.put("plusPage",pageMap.get("plusPage")+num);
            pageMap.put("multiPage",pageMap.get("multiPage")*num);
        }
        return pageMap;
    }
    private static int allPageMax(List<Integer> playerPages){
        int leftPageMax = pageMax(leftPageList(playerPages));
        int rightPageMax = pageMax(rightPageList(playerPages));
        if(leftPageMax>rightPageMax){
            return leftPageMax;
        }
        return rightPageMax;
    }
    private static String[] leftPageList(List<Integer> playerPages){
        return String.valueOf(playerPages.get(0)).split("(?<=.)");
    }
    private static String[] rightPageList(List<Integer> playerPages){
        return String.valueOf(playerPages.get(1)).split("(?<=.)");
    }
    private static List<Integer> findPobiAndCrongPageMax(List<Integer> pobi, List<Integer> crong){
        return List.of(allPageMax(pobi),allPageMax(crong));
    }
    private static List<Boolean> whoIsTheWinner(List<Integer> pobiAndCrongPageMax){
        int pobiMaxPage = pobiAndCrongPageMax.get(0);
        int crongMaxPage = pobiAndCrongPageMax.get(1);
        return List.of(pobiMaxPage == crongMaxPage,pobiMaxPage>crongMaxPage,pobiMaxPage<crongMaxPage);
    }
    private static boolean errorPage(List<Integer> pobi, List<Integer> crong) {
        if(errorPageGap(pobi,crong) || errorPageFirstOrLast(pobi,crong)){
            return true;
        }
        return false;
    }
    private static boolean errorPageGap(List<Integer> pobi,List<Integer> crong){
        return List.of(pobi.get(0)%2 == 0,pobi.get(0)+1 != pobi.get(1),pobi.get(1)%2 != 0
                        ,crong.get(0)%2 == 0,crong.get(0)+1 != crong.get(1),crong.get(1)%2 != 0)
                .contains(true);
    }
    private static boolean errorPageFirstOrLast(List<Integer> pobi,List<Integer> crong){
        List<Integer> firstAndlastPageList = List.of(1,2,399,400);
        return List.of(firstAndlastPageList.contains(pobi.get(0)),firstAndlastPageList.contains(pobi.get(1))
                        ,firstAndlastPageList.contains(crong.get(0)),firstAndlastPageList.contains(crong.get(1)))
                .contains(true);
    }
}
