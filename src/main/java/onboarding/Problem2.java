package onboarding;

import java.util.ArrayList;
import java.util.List;
// 1. 문자열 분리하는 메소드
// 2. 중복된 글자를 없애주는 메소드
// 3. 중복 없어진 메소드를 출력함 -> solution

public class Problem2 {
    public static String solution(String cryptogram) {
        // 3. 중복 없어진 리스트를 String으로 변경해서 출력한다.
        String text = "";
        List<String> cryptoList = cryptoSplit(cryptogram); // browoanoommnaon
        while (true) {
            List<String> newList = cryptoDedupli(cryptoList); //browoannaon -> browoaaon -> browoon -> brown
            if(cryptoList.size() == newList.size()) break; // 중복이 제거되면 멈춰
            cryptoList.clear();
            cryptoList = newList;
        }
        for(String txt : cryptoList) text +=txt+"";
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
                last= lastList.get(i);
            }else {
                last= lastList.get(i);
                i++;
            }
        }
        if(!(lastList.size()==2 && last.equals(lastList.get(lastList.size()-1)))) {
            newList.add(lastList.get(lastList.size()-1));
        }
        return  newList;

    }

}
