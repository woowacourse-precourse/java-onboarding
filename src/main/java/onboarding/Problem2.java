package onboarding;

import java.util.List;

public class Problem2 {
    public static List<Integer> duplicatedIndexList;
    public static StringBuilder sb;

    public static String solution(String cryptogram) {
        return cryptogram;
    }

    public static void addDuplicatedIndex(String cryptogram) {
        char first = ' ', second = ' ';
        duplicatedIndexList.clear();

        for (int index = 0; index < cryptogram.length() - 1; index++) {
            first = cryptogram.charAt(index);
            second = cryptogram.charAt(index + 1);
            if (first == second) {
                duplicatedIndexList.add(index);
                duplicatedIndexList.add(index + 1);
            }
        }
    }

    public static String createNewCryptogram(String cryptogram){
        clearStringBuilder();

        for(int index = 0; index < cryptogram.length(); index++){
            if(duplicatedIndexList.contains(index)){
                continue;
            }
            sb.append(cryptogram.charAt(index));
        }
        return sb.toString();
    }

    public static void clearStringBuilder(){
        sb.setLength(0);
    }
}
