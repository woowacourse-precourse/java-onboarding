package problem6;

import java.util.ArrayList;
import java.util.List;

public class ExtractNickName {

    public List<String> extractNickName (List<List<String>> forms){
        List<String> nickNameList = new ArrayList<>();

        for(List<String> info : forms) {
            nickNameList.add(info.get(1));
        }

        return nickNameList;
    }
}
