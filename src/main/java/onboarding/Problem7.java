package onboarding;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        int friendsRelation = sc.nextInt();

        String[][] arr = new String[friendsRelation][2];
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<friendsRelation; i++) {
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = splitValue[j];
            }
        }
        List<List<String>> friends = convertToList(arr);
        List<String> visitors = new ArrayList<>();
        int visitorNumber = sc.nextInt();
        for(int i=0; i<visitorNumber; i++) {
            visitors.add(scanner.nextLine());
        }
        System.out.println(solution(user, friends, visitors));
    }


}
