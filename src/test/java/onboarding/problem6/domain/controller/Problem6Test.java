package onboarding.problem6.domain.controller;

import onboarding.problem6.domain.Manager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {
    @Test
    void case1() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
        
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이제이")
        );
        List<String> result = List.of();
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이제이"),
                List.of("eya@email.com", "이야")
        );
        List<String> result = List.of();
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        List<List<String>> forms = List.of(
                List.of("g@email.com", "제이제이"),
                List.of("d@email.com", "이제이제"),
                List.of("e@email.com", "제이"),
                List.of("a@email.com", "이제"),
                List.of("c@email.com", "제이야"),
                List.of("b@email.com", "아제이"),
                List.of("f@email.com", "이야")
        );
        List<String> result = List.of("a@email.com", "b@email.com", "c@email.com", "d@email.com", "e@email.com", "f@email.com", "g@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        List<List<String>> forms = List.of(
                List.of("ga@email.com", "제이제이"),
                List.of("dbb@email.com", "이제이제"),
                List.of("ec@email.com", "제이"),
                List.of("ad@email.com", "이제"),
                List.of("cee@email.com", "제이야"),
                List.of("bfff@email.com", "아제이"),
                List.of("fg@email.com", "이야")
        );
        List<String> result = List.of("ad@email.com", "bfff@email.com", "cee@email.com", "dbb@email.com", "ec@email.com", "fg@email.com", "ga@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        List<List<String>> forms = List.of(
                List.of("ga@email.com", "제이제이"),
                List.of("dbb@email.com", "이제이제"),
                List.of("ec@email.com", "제이"),
                List.of("ad@email.com", "이제"),
                List.of("cee@email.com", "제이야"),
                List.of("bfff@email.com", "아제이"),
                List.of("fg@email.com", "이야"),
                List.of("adg@email.com", "이")
        );
        List<String> result = List.of("ad@email.com", "bfff@email.com", "cee@email.com", "dbb@email.com", "ec@email.com", "fg@email.com", "ga@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        List<List<String>> forms = List.of(
                List.of("jm1@email.com", "제이제이"),
                List.of("jm2@email.com", "제"),
                List.of("jm3@email.com", "이")
        );
        List<String> result = List.of();
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        List<List<String>> forms = List.of(
                List.of("jm3@email.com", "제이제이"),
                List.of("jm1@email.com", "제이"),
                List.of("jm2@email.com", "이제")
        );
        List<String> result = List.of("jm1@email.com", "jm2@email.com", "jm3@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        List<List<String>> forms = List.of(
                List.of("onepiece@email.com", "원피수"),
                List.of("jason@email.com", "제이슨"),
                List.of("onepisu@email.com", "원피수"),
                List.of("mj@email.com", "엠제이"),
                List.of("suonepi@email.com", "수원피")
        );
        List<String> result = List.of("jason@email.com",  "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        List<List<String>> forms = List.of(
                List.of("onepiece@email.com", "ㅡ피수"),
                List.of("jason@email.com", "제이슨"),
                List.of("onepisu@email.com", "ㅡ피수"),
                List.of("mj@email.com", "엠제이"),
                List.of("suonepi@email.com", "수ㅡ피")
        );
        List<String> result = List.of("jason@email.com",  "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        List<List<String>> forms = List.of(
                List.of("사a@email.com", "제이제이"),
                List.of("라b@email.com", "이제이제"),
                List.of("마c@email.com", "제이"),
                List.of("가d@email.com", "이제"),
                List.of("다e@email.com", "제이야"),
                List.of("나f@email.com", "아제이"),
                List.of("바g@email.com", "이")
        );
        List<String> result = List.of("가d@email.com", "나f@email.com", "다e@email.com", "라b@email.com", "마c@email.com", "사a@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        List<List<String>> forms = List.of(
                List.of("사a@email.com", "제이제이"),
                List.of("ㄱb@email.com", "이제이제"),
                List.of("마c@email.com", "제이"),
                List.of("가나다라마바사아자@email.com", "이제"),
                List.of("ㄴe@email.com", "제이야"),
                List.of("나f@email.com", "아제이"),
                List.of("바g@email.com", "이"),
                List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                List.of("abcdefghi@email.com", "기리기리기리기리기리기리기리기리기이제")
        );
        List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        List<List<String>> forms = List.of(
                List.of("사a@email.com", "제이제이"),
                List.of("ㄱb@email.com", "이제이제"),
                List.of("마c@email.com", "제이"),
                List.of("가나다라마바사아자@email.com", "이제"),
                List.of("ㄴe@email.com", "제이야"),
                List.of("나f@email.com", "아제이"),
                List.of("바g@email.com", "이"),
                List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                List.of("abcdefghi@email.com", "기리기리기리이제기리기리기리기리기리기")
        );
        List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        List<List<String>> forms = List.of(
                List.of("사a@email.com", "제이제이"),
                List.of("ㄱb@email.com", "이제이제"),
                List.of("마c@email.com", "제이"),
                List.of("가나다라마바사아자@email.com", "이제"),
                List.of("ㄴe@email.com", "제이야"),
                List.of("나f@email.com", "아제이"),
                List.of("바g@email.com", "이"),
                List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                List.of("abcdefghi@email.com", "이제기리기리기리기리기리기리기리기리기")
        );
        List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        List<List<String>> forms = List.of(
                List.of("kim@email.com", "김ㅡ이"),
                List.of("nam@email.com", "ㅡ이야"),
                List.of("choi@email.com", "최강"),
                List.of("lee@email.com", "강합니다"),
                List.of("jun@email.com", "왜ㅇㅡ이야")
        );
        List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
    
    @Test
    void case16() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"),
                List.of("jasp@email.com", "박이김"),
                List.of("jp@email.com", "김이박"),
                List.of("qpw@email.com", "김이순"),
                List.of("teemo@email.com", "티모"),
                List.of("banana@email.com", "대위티모"),
                List.of("secondJm@email.com", "제이엠"),
                List.of("apple@email.com", "땷횱봵"),
                List.of("stran@email.com", "횱봵으"),
                List.of("zebra@email.com", "두글자이상의문자가연속적으로이제맞티모")
        );
        List<String> result = List.of("apple@email.com",
                "banana@email.com",
                "jason@email.com",
                "jm@email.com",
                "jp@email.com",
                "mj@email.com",
                "nowm@email.com",
                "qpw@email.com",
                "secondJm@email.com",
                "stran@email.com",
                "teemo@email.com",
                "zebra@email.com");
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
    
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
}
