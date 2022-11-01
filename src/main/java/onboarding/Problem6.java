package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms){
        // 2d Matrix로 변환하여 푼다.

        Set<Character> nickNameCharSet = new HashSet<>();

        // arr의 길이를 정의하기 위한 for문 (디버깅 ok)
        for(List<String> e : forms) {
            String temp =  e.get(1);
            for(int i = 0; i < temp.length(); i++) {
                nickNameCharSet.add(temp.charAt(i));
            }
        }

        System.out.println();

        // matrix정의
        Character[] nickNameCharArr = nickNameCharSet.toArray(new Character[0]);
        Character[][] matrix = new Character[nickNameCharSet.size()][nickNameCharSet.size()];
        for(int i = 0; i < nickNameCharArr.length; i++) {
            matrix[i][i] = nickNameCharArr[i];
        }

        System.out.println(matrix[0][0] + "-" + matrix[0][1]+ "-" + matrix[0][2]+ "-" + matrix[0][3]+ "-" + matrix[0][4]+ "-" + matrix[0][5]);

        return null;
    }
}

/*
*   해당 문제를 userNickname의 각각의 글자를 2차원 Matrix로 바꾸어
*   row -> column의 방향성 그래프로 만들어 각각의 요소가 1보다 큰 경우
*   중복된다고 가정하고 푸는 아이디어로 접근중 (미구현)
* */