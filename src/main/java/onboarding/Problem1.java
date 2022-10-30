package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiPageMax = allPageMax(pobi);
        int crongPageMax = allPageMax(crong);
        if(pobiPageMax == -1 || crongPageMax == -1){
            return -1;
        }
        else if(pobiPageMax > crongPageMax){
            return 1;
        }
        else if(pobiPageMax < crongPageMax){
            return 2;
        }
        else return 0;
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
    }
