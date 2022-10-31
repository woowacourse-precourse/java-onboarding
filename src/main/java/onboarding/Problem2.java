package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    /**
     *
     * @param cryptogram : 검사할 문자열
     * @return Set<Integer> 지워야 할 인덱스들 집합
     */
    public static Set<Integer> getDeleteIndexSet(String cryptogram) {
        Set<Integer> deleteIndexSet = new HashSet<>();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                deleteIndexSet.add(i);
                deleteIndexSet.add(i + 1);
            }
        }
        return deleteIndexSet;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        Set<Integer> deleteIndexSet = new HashSet<>();
        boolean alive[] = new boolean[cryptogram.length()];
        do {
            for(int i=0;i<cryptogram.length();i++){
                alive[i] = true;
            }
            for(Integer l : deleteIndexSet){
                alive[l] = false;
            }
            String save = answer;
            answer = "";
            for(int i=0;i<save.length();i++){
                if(alive[i])
                    answer += save.charAt(i);
            }
        }while (!(deleteIndexSet = getDeleteIndexSet(answer)).isEmpty());
        return answer;
    }
}
