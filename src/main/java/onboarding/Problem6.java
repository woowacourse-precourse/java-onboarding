package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        String email, name;
        List<String> result = new ArrayList<>();
        List<List<String>> forms;
        size = sc.nextInt();
        forms = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            forms.add(new ArrayList<String>());
        }

        for (int i = 0; i < size; i++) {
            email = sc.next();
            forms.get(i).add(email);
            name = sc.next();
            forms.get(i).add(name);
        }

        result = solution(forms);
        System.out.println(result.toString());
    }
}
