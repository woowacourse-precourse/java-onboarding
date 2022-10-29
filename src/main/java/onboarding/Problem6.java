package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
}
