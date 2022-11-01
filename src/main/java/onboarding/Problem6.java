package onboarding;

import java.util.*;

public class Problem6 {

    public static List<Integer> removeDuplicateEmail(List<List<String>> forms) {
        HashMap<String,Integer> duplicateMap = new HashMap<>();
        int indexCount = 0;
        List<Integer> nameDuplicateResult = new ArrayList<>();

        while(indexCount < forms.size())
        {
            int duplicateFlag = 0;
            String nickname = forms.get(indexCount).get(1);
            for(int i = 0; i < nickname.length() - 1; i++)
            {
                for(int j = i + 2; j <= nickname.length(); j++)
                {
                    String nicknamePart = nickname.substring(i,j);
                    if(duplicateMap.containsKey(nicknamePart))
                    {
                        nameDuplicateResult.set(duplicateMap.get(nicknamePart),1);
                        duplicateFlag = 1;
                    }
                    else
                    {
                        duplicateMap.put(nicknamePart,indexCount);
                    }
                }
            }
            nameDuplicateResult.add(duplicateFlag);
            indexCount++;
        }
        return nameDuplicateResult;
    }

    public static List<String> removeDuplicateEmail(List<List<String>> forms,List<Integer> nameDuplicateResult){

        HashSet<String> emailStorageSet = new HashSet<>();

        for(int i = 0; i < nameDuplicateResult.size(); i++)
        {
            if(nameDuplicateResult.get(i) == 1) {
                emailStorageSet.add(forms.get(i).get(0));
            }
        }

        List<String> resultStorage = new ArrayList<>(emailStorageSet);
        Collections.sort(resultStorage);
        return resultStorage;
    }

    public static List<String> getDuplicate(List<List<String>> forms ) {
        List<Integer> nameDuplicateResult = removeDuplicateEmail(forms);
        List<String> result = removeDuplicateEmail(forms, nameDuplicateResult);
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicate(forms);
        return answer;
    }
}
