package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// <기능 목록>
// <기능 목록>
// 0. class twoLetter(string letter, boolean overlap)
//  : letter가 중복이면 overlap은 true
// 1. 닉네임 두글자씩 잘라서 Treeset에 저장
//  a. 닉네임 두글자씩 자름 String[] cutNickname
//  b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
//  c. 저장되어 있다면 twoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
// 2. 중복 닉네임을 가진 이메일 찾기
//  a. 닉네임 두글자씩 자름 String[] cutNickname
//  b. cutNickname의 overlap이 true인지 확인
// 3. 오름차순으로 이메일 정렬 & 중복 제거

public class Problem6 {
    static TreeSet<twoLetter> twoLetterTreeSet = new TreeSet<twoLetter>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 1. 닉네임 두글자씩 잘라서 Treeset에 저장
        addAllTwoLettersInTreeSet(forms);

        // 2. 중복 닉네임을 가진 이메일 찾기
        answer = findOverlapNickname(forms);

        // 3. 오름차순으로 이메일 정렬 & 중복 제거
        answer = emailSortAndDeduplication(answer);

        return answer;
    }

    // 1. 닉네임 두글자씩 잘라서 Treeset에 저장
    public static void addAllTwoLettersInTreeSet(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            // 1-a. 닉네임 두글자씩 자름 String[] cutNickname
            String[] cutNickname = cutNicknameByTwoLetters(forms.get(i).get(1)); // nickname

            // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
            // 1-c. 저장되어 있는게 맞다면 twoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
            addTwoLettersInTreeSet(cutNickname);
        }
    }

    // 1-a. 닉네임 두글자씩 자름 String[] cutNickname
    // 2-a. 닉네임 두글자씩 자름 String[] cutNickname
    public static String[] cutNicknameByTwoLetters(String nickname) {
        String[] cutNickname = new String[nickname.length() - 1];
        for (int i = 0; i < nickname.length() - 1; i++) {
            cutNickname[i] = nickname.substring(i, i + 2);
        }
        return cutNickname;
    }

    // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
    // 1-c. 저장되어 있는게 맞다면 twoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
    public static void addTwoLettersInTreeSet(String[] cutNickname) {
        // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
        for (int i = 0; i < cutNickname.length; i++) {
            if (twoLetterTreeSet.isEmpty()) {
                twoLetterTreeSet.add(new twoLetter(cutNickname[i], false));
                continue;
            }

            // 1-c. 저장되어 있는게 맞다면 twoLetter.overlap=true로 설정
            twoLetter ceilingLetter = twoLetterTreeSet.ceiling(new twoLetter(cutNickname[i], false));
            if (ceilingLetter == null) {
                twoLetterTreeSet.add(new twoLetter(cutNickname[i], false));
            } else if (cutNickname[i].equals(ceilingLetter.letter)) {
                // overlap==true일때는 다시 저장할 필요 없음
                if (!ceilingLetter.overlap) {
                    twoLetterTreeSet.remove(new twoLetter(cutNickname[i], false));
                    twoLetterTreeSet.add(new twoLetter(cutNickname[i], true));
                }
            } else {
                twoLetterTreeSet.add(new twoLetter(cutNickname[i], false));
            }
        }
    }

    // 2. 중복 닉네임을 가진 이메일 찾기
    public static List<String> findOverlapNickname(List<List<String>> forms) {
        List<String> email = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            // 2-a. 닉네임 두글자씩 자름 String[] cutNickname
            String[] cutNickname = cutNicknameByTwoLetters(forms.get(i).get(1)); // nickname

            // 2-b. cutNickname의 overlap이 true인지 확인
            if (isOverlapNickname(cutNickname)) {
                email.add(forms.get(i).get(0)); // email
            }
        }
        return email;
    }

    // 2-b. cutNickname의 overlap이 true인지 확인
    public static boolean isOverlapNickname(String[] cutNickname) {
        for (int i = 0; i < cutNickname.length; i++) {
            twoLetter ceilingLetter = twoLetterTreeSet.ceiling(new twoLetter(cutNickname[i], true));
            if (ceilingLetter.overlap) {
                return true;
            }
        }
        return false;
    }

    // 3. 오름차순으로 이메일 정렬 & 중복 제거
    public static List<String> emailSortAndDeduplication(List<String> email) {
        TreeSet<String> emailTreeSet = new TreeSet<String>(email);
        List<String> resultEmail = new ArrayList<String>(emailTreeSet);
        return resultEmail;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "차이차이차이문"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"));
        List<String> answer = solution(forms);

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    // 0. class twoLetter(string letter, boolean overlap)
    // : letter가 중복이면 overlap은 true
    public static class twoLetter implements Comparable<twoLetter> {
        String letter;
        boolean overlap;

        twoLetter(String letter, boolean overlap) {
            this.letter = letter;
            this.overlap = overlap;
        }

        public int compareTo(twoLetter o) {
            return (this.letter).compareTo(o.letter);
        }
    }

}
