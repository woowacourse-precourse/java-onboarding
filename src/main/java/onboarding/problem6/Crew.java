package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crew {

    private final List<Member> members;

    public Crew(List<List<String>> forms) {
        this.members = new ArrayList<>();

        int no = 0;
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            if (!Validator.isValidEmail(email)) {
                continue;
            }

            if (!Validator.isValidName(name)) {
                continue;
            }

            Member member = new Member(no++, email, name);
            this.members.add(member);
        }
    }

    public int size() {
        return members.size();
    }

    public Member get(int index) {
        return members.get(index);
    }

    public List<Member> getAfter(Member member) {
        int no = member.getNo();
        int toIndex = members.size();
        return members.subList(no + 1, toIndex);
    }

}
