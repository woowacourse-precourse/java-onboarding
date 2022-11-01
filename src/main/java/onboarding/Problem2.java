package onboarding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        return decode(cryptogram);
    }

    private static String decode(String str) {
        String result = "";

        boolean check = true;

        String[] array = str.split("");

        // 배열의 size가 변하면 안되거나 변할 필요가 없을때 Array.asList()를 사용
        List<String> list = Arrays.asList(array);

        while(check) {
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for(int i=0; i < list.size()-1; i++ ) {

                if(list.get(i).equals(list.get(i+1))){
                    System.out.println(cur_string);
                    System.out.println(list.get(i) + " " + list.get(i + 1));
                    cur_string.remove(i + 1);
                    cur_string.remove(i);
                    list = cur_string;
                    check = true;
                    continue;
                }
            }

            list = cur_string;


            System.out.println(list);
        }
        // StringBuilder는 변경 가능한 문자열 만들어 준다

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        result = sb.toString();
        System.out.println(result);
        return result;
    }
}
