package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static boolean isCharEqual(String firstString, int firstIndex, String secondString, int secondIndex) {
        if (firstString.charAt(firstIndex) == secondString.charAt(secondIndex)) return true;
        else return false;
    }
    public static boolean commonSubstring(String firstString, String secondString) {
        int[][] commonSubString = new int[20][20];
        for (int i=0; i < 20; i++) {
            for (int j=0; j < 20; j++) {
                commonSubString[i][j] = 0;
            }
        }

        for (int i=1; i < firstString.length()+1; i++) {
            for (int j=1; j < secondString.length()+1; j++) {
                if (isCharEqual(firstString, i-1, secondString, j-1)) {
                    commonSubString[i][j] = commonSubString[i-1][j-1] + 1;
                }
                else {
                    commonSubString[i][j] = 0;
                }

                if (commonSubString[i][j] == 2) {
                    return true;
                }
            }
        }

        return false;
    }
    public static String getEmail(List<List<String>> forms, int index) {
        return forms.get(index).get(0);
    }

    public static String getNickname(List<List<String>> forms, int index) {
        return forms.get(index).get(1);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        int crewNumber = forms.size();

        for (int target=0; target<crewNumber-1; target++) {
            for (int comparison=target+1; comparison< crewNumber; comparison++) {
                if (commonSubstring(getNickname(forms, target), getNickname(forms, comparison))) {
                    answer.add(getEmail(forms, target));
                    answer.add(getEmail(forms, comparison));
                }
            }
        }
        return answer;
    }
}
