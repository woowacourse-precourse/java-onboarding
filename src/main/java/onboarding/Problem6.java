package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> email = new ArrayList<>(); //이메일을 따로 저장할 리스트 선언 및 생성
        List<String> nickname = new ArrayList<>(); //닉네임을 따로 저장할 리스트 선언 및 생성
        for (int i = 0; i < forms.size(); i++) { //닉네임 따로 저장하기
            nickname.add(forms.get(i).get(1));
        }
        for (int i = 0; i < forms.size(); i++) { //닉네임 리스트에서 중복 확인하고 중복일 경우 email 리스트에 해당 닉네임의 email 추가하기
            for (int j = i + 1; j < forms.size(); j++) {
                if (compare(nickname.get(i), nickname.get(j)) != -1 * (nickname.get(i).length() - 1)) {
                    email.add(forms.get(i).get(0));
                    email.add(forms.get(j).get(0));
                }
            }
        }
        Set<String> set = new HashSet<String>(email); // 중복 제거하기
        List<String> answer = new ArrayList<String>(set); //다시 List로 변환
        Collections.sort(answer); //오름차순 정렬하기
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
        int member = sc.nextInt(); //크루원 수 입력 받기

        String[][] arr = new String[member][2]; //2차원 배열 선언 및 생성하기
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < member; i++) { //이메일, 닉네임으로 2차원 배열 초기화하기
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = splitValue[j];
            }
        }

        List<List<String>> forms = convertToList(arr); //2차원 배열 -> 2차원 리스트 메서드 호출
        System.out.println(solution(forms));
    }

    public static List<List<String>> convertToList(String[][] arr) { //2차원 배열 -> 2차원 리스트
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
