package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> email = new ArrayList<>();
        List<String> nickname = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            nickname.add(forms.get(i).get(1));
        }
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (compare(nickname.get(i), nickname.get(j)) != -1 * (nickname.get(i).length() - 1)) {
                    email.add(forms.get(i).get(0));
                    email.add(forms.get(j).get(0));
                }
            }
        }
        Set<String> set = new HashSet<String>(email);
        List<String> answer = new ArrayList<String>(set);
        Collections.sort(answer);
        return answer;
    }
    public static int compare(String nickname1, String nickname2) {
        int check = 0;
        for (int i = 0; i < nickname1.length() - 1; i++) {
            check += nickname2.indexOf(nickname1.substring(i, i + 2));
        }
        return check;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int member = sc.nextInt();

        String[][] arr = new String[member][2];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < member; i++) {
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = splitValue[j];
            }
        }

        List<List<String>> forms = convertToList(arr);
        System.out.println(solution(forms));
    }

    public static List<List<String>> convertToList(String[][] arr) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
