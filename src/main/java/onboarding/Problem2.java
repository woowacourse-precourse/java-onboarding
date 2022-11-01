package onboarding;

import java.util.ArrayList;

public class Problem2 {
    private static ArrayList<Character> convertStringToLinkedList(String str){
        int                     i;
        ArrayList<Character>   tmp = new ArrayList<>();

        for (i = 0; i < str.length(); i++)
            tmp.add(str.charAt(i));
        return tmp;
    }

    private static ArrayList<Character> removeDupChar(ArrayList<Character> oldTmp){
        int                     i;
        boolean                 flag = false;
        ArrayList<Character>    tmp = new ArrayList<>();

        if (oldTmp.size() < 2)
            return oldTmp;
        for(i = 0; i < oldTmp.size() - 1; i++){
            if (oldTmp.get(i) != oldTmp.get(i + 1)){
                if (!flag)
                    tmp.add(oldTmp.get(i));
                flag = false;
            }
            if (oldTmp.get(i) == oldTmp.get(i + 1))
                flag = true;
        }
        if (!flag)
            tmp.add(oldTmp.get(i));
        return tmp;
    }
    private static String convertLinkedListToString(ArrayList<Character> tmp){
        StringBuilder str = new StringBuilder();
        int     i;

        for (i = 0; i < tmp.size(); i++)
            str.append(tmp.get(i));
        return str.toString();
    }
    public static String solution(String cryptogram) {
        String                  answer;
        ArrayList<Character>    tmp;
        ArrayList<Character>    oldTmp = new ArrayList<>();

        tmp = convertStringToLinkedList(cryptogram);
        while (tmp.size() != oldTmp.size()){
            oldTmp = tmp;
            tmp = removeDupChar(oldTmp);
        }
        answer = convertLinkedListToString(tmp);
        return answer;
    }
}
