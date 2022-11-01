package onboarding;

import java.util.*;

public class Problem2 {


    public static String solution(String cryptogram) {

        StringBuilder ctyptogram_sb = new StringBuilder(cryptogram);
        int multi = 1;
        int treeple;
        char before_spell = ' '; // 전 문자를 담는 char 데이터
        while (multi != 0){ // 똑같은 문자가 나타나지 않을 때까지 돌림
            multi = 0;
            treeple = 0; // 똑같은 문자가 연속해서 3번 이상 나타날 경우 처음 나타난 문자를 다시 지우는 작업을 하지 않도록 함
            before_spell = ' ';
            ArrayList<Integer> index_of_remove = new ArrayList<>();
            for (int i=0; i < ctyptogram_sb.length(); i++){
                char spell = ctyptogram_sb.charAt(i);
                if (before_spell == spell && treeple == 1){
                    index_of_remove.add(i);
                    multi += 1;
                } else if (before_spell == spell && treeple == 0){
                    index_of_remove.add(i-1);
                    index_of_remove.add(i);
                    treeple = 1;
                    multi += 1;
                } else {
                    treeple = 0;
                }
                before_spell = spell;
            }

            Collections.sort(index_of_remove, Collections.reverseOrder());

            for (int j : index_of_remove){
                ctyptogram_sb.deleteCharAt(j);
            }
        }


        String answer = ctyptogram_sb.toString();


        return answer;
    }
}
