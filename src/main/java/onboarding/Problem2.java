package onboarding;

import java.util.LinkedList;
import java.util.List;
//import java.util.LinkedListList;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 1. 글자 분리하기
        // 2. 중복을 따로 확인할 List 만들기
        // 3. ...
        String[] cry = cryptogram.split("");
        List<String> crylist = new LinkedList<>();

        for (int a =0; a<cry.length; a++)  crylist.add(cry[a]);

        List<Integer> list = new LinkedList<>();

        while (true) {
            String last = "";
            for (int i = 0; i < crylist.size(); i++) {
                if (last.equals(crylist.get(i))) {
                    list.add(i - 1);
                    list.add(i);
                } //browoanoommnaon
                last = crylist.get(i);
            }

            if(list.size() == 0) break;

            for(int j =0; j<list.size(); j++){
                crylist.remove(list.get(j));
            }

            list.clear();


        }

        return crylist.toString();

    }
}
