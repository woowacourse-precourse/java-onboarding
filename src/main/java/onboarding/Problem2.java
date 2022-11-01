package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String str = cryptogram;

        boolean count = true;
        while(count){

            str = changeLetter(str);
            count = false;

            // todo : 연속해서 중복되는 부분이 있는 지 확인하는 반복문
            for(int i = 0; i<str.length(); i++){
                for(int j = i+1; j<str.length(); j++){
                    if(str.charAt(i) != str.charAt(j)){
                        break;
                    }
                    count = true;
                }
            }
        }

        return str;
    }

    /* 중복되는 문자를 제거하는 함수*/
    public static String changeLetter(String name){


        List<String> list = new ArrayList<>();

        for(int i = 0; i<name.length(); i++){
            list.add(name.substring(i,i+1));
        }


        for(int i = 0; i<list.size()-1; i++){
            int removeOfNum = 0;
            for(int j = i+1; j<list.size(); j++){
                if(!list.get(i).equals(list.get(j))){
                    break;
                }
                removeOfNum++;
            }
            for(int z = 0; z<=removeOfNum && removeOfNum >0; z++){
                list.remove(i);
                if(z== removeOfNum && i ==0){
                    i=-1;
                }
            }
        }
        return String.join("",list);
    }

    public static void main(String[] args) {
        String str = new String("oooommmcccmcbbbbbab");
        System.out.println(solution(str));

    }
}
