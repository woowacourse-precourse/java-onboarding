package onboarding;

import java.util.List;

// <기능 목록>
// 0. class person (String name, int score)
// 1. 추천 목록 만들기
//  a. 유저 친구 목록
//  b. 추천 점수 목록
//  c. 추천 점수 목록에서 user와 userFreinds 삭제
//  d 추천 점수 목록 PersonArray로 변환
// 2. 추천 목록 정렬하기

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    // 0. class Person (String name, int score)
    public static class Person implements Comparable<Person> {
        String name;
        int score;

        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(Person o) {
            // score는 내림차순, name은 오름차순
            if (this.score < o.score) {
                return 1;
            } else if (this.score == o.score) {
                return this.name.compareTo(o.name);
            } else {
                return -1;
            }

        }
    }
}
