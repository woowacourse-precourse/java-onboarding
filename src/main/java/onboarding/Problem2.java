package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> list = Arrays.asList(cryptogram.split(""));
        List<String> Del = new ArrayList<>();
        Del.add("");
        char[] list2;
        int start = -1;
        int end = -1;
        String temp = "";
        String overcase = "0";
        while (IsOverlapped(list)) {  // 중복이 있으면 계속 반복

            for (int i = 0; i < list.size() - 1; i++) {
                if (OverlapHere(list, i)) {       // i, i+1 번째에 중복이 있는 경우
                    start = i;
                    end = i + 1;
                    overcase = list.get(i);
                    i += 1;
                    while (i<list.size()-1) {
                        if (OverlapHere(list, i)) {
                            end += 1;
                            i += 1;
                        } else {
                            break;
                        }
                    }
                    for (int j = start; j <= end; j++) {
                        list.set(j, "");
                    }
                }
            }
//            System.out.println(list);
            temp = "";
            for (String item : list) {
                temp += item;
            }
            answer = temp;
//            System.out.println(answer);
            list = Arrays.asList(answer.split(""));
        }
        temp = "";
        for (String item : list) {
            temp += item;
        }
        answer = temp;
        return answer;
//        System.out.println(answer);
    }

    //String으로 변환


    public static boolean OverlapHere(List<String> list, int i) {
        boolean flag = false;
        if ((list.get(i)).equals(list.get(i + 1))) {
            flag = true;
        }
        return flag;
    }

    public static boolean IsOverlapped(List<String> list) {
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i)).equals(list.get(i + 1))) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}