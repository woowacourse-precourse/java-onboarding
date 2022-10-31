package onboarding;

import java.util.ArrayList;
import java.util.List;


public class Problem2 {
    public static String solution(String cryptogram) {

        String text = "";
        List<String> lastList = cryptoSplit(cryptogram); // browoanoommnaon
        while (true) {
            List<String> newList = cryptoDedupli(lastList); //browoannaon -> browoaaon -> browoon -> brown
            if(lastList.size() == newList.size()) break; // 중복이 제거되면 멈춰
            lastList.clear();
            lastList = newList; //browoannaon
        }

        for(String txt : lastList) text +=txt+"";
        return text;

    }

    public static List<String> cryptoSplit(String s){ //문자열 분리 메소드
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        for(String s1 : arr) list.add(s1);
        return list;

    }

    public static List<String> cryptoDedupli(List<String> list){ // 중복된 글자를 없애는 매소드
        List<String> lastList = list;

        List<String> newList = new ArrayList<>();
        if(lastList.size()== newList.size()) return lastList;
        String last =lastList.get(0);

        for (int i =1; i<lastList.size(); i++){ // zyelleyz -> zyeeyz -> zyyz -> zz
            if(!last.equals(lastList.get(i))) {
                newList.add(lastList.get(i-1));
            }else {
                i++;
            }
            if(!lastList.isEmpty()) last= lastList.get(i);
            else newList.add("");

        }
        if(lastList.size()==2 && last.equals(lastList.get(lastList.size()-1))) {

        }else newList.add(lastList.get(lastList.size()-1));
        System.out.println(newList);


        return  newList;

    }
}
