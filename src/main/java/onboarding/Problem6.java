package onboarding;

import java.util.*;

// <기능 목록>
// 0. class TwoLetter(string letter, boolean overlap)
//  : letter가 중복이면 overlap은 true
// 1. 닉네임 두글자씩 잘라서 Treeset<TwoLetter> twoLetterTreeSet에 저장
//  a. 닉네임 두글자씩 자름 HashSet<String> cutNickname
//  b. cutNickname이 각각 twoLetterTreeSet에 저장되어 있는지 확인
//  c. 저장되어 있다면 TwoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
// 2. 중복 닉네임을 가진 이메일 찾기
//  a. 닉네임 두글자씩 자름 String[] cutNickname
//  b. cutNickname의 overlap이 true인지 확인
// 3. 오름차순으로 이메일 정렬 & 중복 제거

public class Problem6 {
    static TreeSet<TwoLetter> twoLetterTreeSet = new TreeSet<TwoLetter>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 1. 닉네임 두글자씩 잘라서 Treeset<TwoLetter> twoLetterTreeSet에 저장
        addAllTwoLettersInTreeSet(forms);

        // 2. 중복 닉네임을 가진 이메일 찾기
        answer = findOverlapNickname(forms);

        // 3. 오름차순으로 이메일 정렬 & 중복 제거
        answer = emailSortAndDeduplication(answer);

        return answer;
    }

    // 1. 닉네임 두글자씩 잘라서 Treeset<TwoLetter> twoLetterTreeSet에 저장
    public static void addAllTwoLettersInTreeSet(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            // 1-a. 닉네임 두글자씩 자름 HashSet<String> cutNickname
            HashSet<String> cutNickname = cutNicknameByTwoLetters(forms.get(i).get(1)); // nickname

            // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
            // 1-c. 저장되어 있는게 맞다면 TwoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
            addTwoLettersInTreeSet(cutNickname);
        }
    }

    // 1-a. 닉네임 두글자씩 자름 HashSet<String> cutNickname
    // 2-a. 닉네임 두글자씩 자름 HashSet<String> cutNickname
    public static HashSet<String> cutNicknameByTwoLetters(String nickname) {
        HashSet<String> cutNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            cutNickname.add(nickname.substring(i, i + 2));
        }
        return cutNickname;
    }

    // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
    // 1-c. 저장되어 있는게 맞다면 TwoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
    public static void addTwoLettersInTreeSet(HashSet<String> cutNickname) {
        // 1-b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
        Iterator<String> iter = cutNickname.iterator();
        while (iter.hasNext()) {
            String iterCutNickname = iter.next();
            if (twoLetterTreeSet.isEmpty()) {
                twoLetterTreeSet.add(new TwoLetter(iterCutNickname, false));
                continue;
            }

            // 1-c. 저장되어 있는게 맞다면 TwoLetter.overlap=true로 설정
            TwoLetter ceilingLetter = twoLetterTreeSet.ceiling(new TwoLetter(iterCutNickname, false));
            if (ceilingLetter == null) {
                twoLetterTreeSet.add(new TwoLetter(iterCutNickname, false));
            } else if (iterCutNickname.equals(ceilingLetter.letter)) {
                // overlap==true일때는 다시 저장할 필요 없음
                if (!ceilingLetter.overlap) {
                    twoLetterTreeSet.remove(new TwoLetter(iterCutNickname, false));
                    twoLetterTreeSet.add(new TwoLetter(iterCutNickname, true));
                }
            } else {
                twoLetterTreeSet.add(new TwoLetter(iterCutNickname, false));
            }
        }
    }

    // 2. 중복 닉네임을 가진 이메일 찾기
    public static List<String> findOverlapNickname(List<List<String>> forms) {
        List<String> email = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            // 닉네임 두글자씩 자름 HashSet<String> cutNickname
            HashSet<String> cutNickname = cutNicknameByTwoLetters(forms.get(i).get(1)); // nickname

            // 2-b. cutNickname의 overlap이 true인지 확인
            if (isOverlapNickname(cutNickname)) {
                email.add(forms.get(i).get(0)); // email
            }
        }
        return email;
    }

    // 2-b. cutNickname의 overlap이 true인지 확인
    public static boolean isOverlapNickname(HashSet<String> cutNickname) {
        Iterator<String> iter = cutNickname.iterator();
        while (iter.hasNext()) {
            TwoLetter ceilingLetter = twoLetterTreeSet.ceiling(new TwoLetter(iter.next(), true));
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

    // 0. class twoLetter(string letter, boolean overlap)
    // : letter가 중복이면 overlap은 true
    public static class TwoLetter implements Comparable<TwoLetter> {
        String letter;
        boolean overlap;

        TwoLetter(String letter, boolean overlap) {
            this.letter = letter;
            this.overlap = overlap;
        }

        public int compareTo(TwoLetter o) {
            return (this.letter).compareTo(o.letter);
        }
    }

}
