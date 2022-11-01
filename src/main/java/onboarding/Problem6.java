package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = similarNameFinder(forms);

        return answer;

    }
    public static List<String> similarNameFinder(List<List<String>> value) {
        Set<String> dupNames = new HashSet<String>();
        int inputLength = value.size();

        for (int i = 0; i < inputLength-1; i++) {
            String nickname = value.get(i).get(1);
            for (int j = i+1; j < inputLength; j++) {
                String compNickname = value.get(j).get(1);
                if (GCL(nickname, compNickname) >= 2) {
                    dupNames.add(value.get(i).get(0));
                    dupNames.add(value.get(j).get(0));
                }
            }

        }
        List<String> dupNameList = new ArrayList<>(dupNames);
        Collections.sort(dupNameList);
        return dupNameList;
    }

    public static int GCL(String  org, String comp) {
        int orgLenght = org.length();
        int compLength = comp.length();

        ArrayList<ArrayList<Integer>> matrix =new ArrayList<>(orgLenght);
        for (int i = 0; i < orgLenght; i++) {
            matrix.add(new ArrayList<Integer>());

        }

        int prevValue;
        int currentValue;
        int maxValue=0;

        for (int i = 0; i < orgLenght; i++) {
            String orgLetter = String.valueOf(org.charAt(i));

            for (int j = 0; j < compLength; j++) {
                String compLetter = String.valueOf(comp.charAt(j));
                int count = 0;

                prevValue = (i - 1 < 0 || j - 1 < 0) ? 0 : matrix.get(i-1).get(j-1);
                currentValue = (orgLetter.equals(compLetter) ) ? prevValue + 1 : 0;
                matrix.get(i).add(j, currentValue);

            }
        }

        for (int i = 0; i < orgLenght; i++) {
            Integer localMax = Collections.max(matrix.get(i));
            maxValue = (localMax >= maxValue) ? localMax : maxValue;
        }
        return maxValue;
    }

}
