package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        Duplication duplication = new Duplication();
        while (true){
            List<Integer[]> duplicateIndexList = duplication.DuplicateStringFind(cryptogram);
            if(duplicateIndexList.size() == 0){
                break;
            }
            cryptogram = duplication.removeDuplication(cryptogram,duplicateIndexList);

        }
        return cryptogram;
    }
}


class Duplication{
    public List<Integer[]> DuplicateStringFind(String cryptogram){
        List duplicateIndexList = new ArrayList();
        String[] charList = cryptogram.split("(?<=.)");

        Integer[] duplicateIndex = new Integer[2];
        boolean duplicateCheck = false;

        for (int i = 0; i < charList.length; i++) {
            if( i == charList.length-1){
                if(duplicateCheck){

                    duplicateIndex[1] = i;
                    duplicateIndexList.add(duplicateIndex);
                }
                break;
            }
            if(charList[i].equals(charList[i+1]) && !duplicateCheck){
                duplicateIndex[0] = i;
                duplicateCheck = true;
            }
            else if(!charList[i].equals(charList[i+1]) && duplicateCheck){
                duplicateIndex[1] = i;
                duplicateIndexList.add(duplicateIndex);
                duplicateIndex = new Integer[2];
                duplicateCheck = false;
            }
        }

        return duplicateIndexList;
    }

    public String removeDuplication(String cryptogram, List<Integer[]> duplicateIndexList){
        final String[][] charList = {cryptogram.split("(?<=.)")};

        duplicateIndexList.forEach(index -> {
            int start = index[0], stop = index[1];
            for (int i = start; i < stop+1; i++) {
                charList[0][i] = "";
            }
        });

        return String.join("",charList[0]);
    }


}