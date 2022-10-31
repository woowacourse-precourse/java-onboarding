package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            list.add(cryptogram.charAt(i));
        }

        List<Character> tmp = new ArrayList<>();

        tmp.add(list.get(0));
        int listIndex = 1;
        int tmpIndex = 0;
        while (listIndex < list.size()) {
            if(tmp.size()==0){
                tmp.add(list.get(listIndex));
                listIndex++;
            }
            else{
                if (list.get(listIndex) == tmp.get(tmpIndex)) {
                    if (listIndex == list.size() - 1) {
                        tmp.remove(tmpIndex);
                        break;
                    } else {
                        if (list.get(listIndex) != list.get(listIndex + 1)) {
                            tmp.remove(tmpIndex);
                            if(tmpIndex!=0)
                                tmpIndex--;
                        }
                        listIndex++;
                    }
                } else {
                    tmp.add(list.get(listIndex));
                    tmpIndex++;
                    listIndex++;
                }
            }
        }

        for (int i = 0; i < tmp.size(); i++) answer.append(tmp.get(i));

        return answer.toString();
    }
}