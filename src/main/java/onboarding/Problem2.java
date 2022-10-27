package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.LinkedListList;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 제한사항 길이, 소문자
        // 중복이 없을때 까지 반복해서 중복문자 제거하기

        // 1. cryptogram을 list로 문자열 분리하기
        // 2. 문자열 분리후 길이 확인, 소문자확인
        // 3. list를 하나 더 만들어서 계속해서 저장하기

        List<String> lastList = crypList(cryptogram); // browoanoommnaon
        while (true) {
            List<String> newList = cryp(lastList); //browoannaon -> browoaaon -> browoon -> brown
            if(lastList.size() == newList.size()) break;
            lastList.clear();
            lastList = newList; //browoannaon
        }
        
        String text = String.join((CharSequence) lastList,",");

        return text;

    }

    public static List<String> crypList(String s){
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        for(int i =0; i<arr.length;i++) list.add(arr[i]);
        return list;

    }

    public static List<String> cryp(List<String> list){
        List<String> lastList = list;
        List<String> newList = new ArrayList<>();
        if(lastList.size()== newList.size()) return lastList;
        String last =lastList.get(0);

        for (int i =1; i<lastList.size(); i++){
            if(!last.equals(lastList.get(i))) newList.add(lastList.get(i-1));
            last= lastList.get(i);
        }
        newList.add(lastList.get(-1));


        return  newList;

    }
}
