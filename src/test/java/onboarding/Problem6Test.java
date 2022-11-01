package onboarding;


import onboarding.problem6.Main;
import onboarding.problem6.collection.Crews;
import onboarding.problem6.domain.Crew;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class Problem6Test {
    
    @Nested
    @DisplayName("Crew 클래스를 테스트한다")
    class CrewTest {

        private Crew crew;
        private String email;
        private String nickname;

        @Nested
        @DisplayName("validateNicknameLanguage 메소드는")
        class validateNicknameLanguageTest {
            @Nested
            @DisplayName("한글 닉네임이 아니라면")
            class Context_with_not_Korean_nickname {
                @Test
                @DisplayName("IllegalArgumentException 를 발생시킨다")
                void it_throws_IllegalArgumentException() {
                    nickname = "Crong";
                    email = "Crong@email.com";
                    assertThatThrownBy(() -> new Crew(email, nickname)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }

        @Nested
        @DisplayName("validateNicknameLength 메소드는")
        class validateNicknameLengthTest {
            @Nested
            @DisplayName("닉네임 길이가 1자 이상 20자 미만이 아니라면")
            class Context_with_20_Korean_nickname {
                @Test
                @DisplayName("IllegalArgumentException 를 발생시킨다")
                void it_throws_IllegalArgumentException() {
                    nickname = "CrongCrongCrongCrong";
                    email = "Crong@email.com";
                    assertThatThrownBy(() -> new Crew(email, nickname)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }

        @Nested
        @DisplayName("validateEmailForm 메소드는")
        class validateEmailFormTest {
            @Nested
            @DisplayName("이메일 계정이 한글로 되었다면")
            class Context_with_Korean_id_email {
                @Test
                @DisplayName("IllegalArgumentException 를 발생시킨다")
                void it_throws_IllegalArgumentException() {
                    nickname = "크롱";
                    email = "크롱@email.com";
                    assertThatThrownBy(() -> new Crew(email, nickname)).isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("이메일 도메인이 \"email.com\"이 아니라면")
            class Context_with_not_email_com_domain {
                @Test
                @DisplayName("IllegalArgumentException 를 발생시킨다")
                void it_throws_IllegalArgumentException() {
                    nickname = "크롱";
                    email = "crong@naver.com";
                    assertThatThrownBy(() -> new Crew(email, nickname)).isInstanceOf(IllegalArgumentException.class);
                }
            }

        }

        @Nested
        @DisplayName("validateEmailLength 메소드는")
        class validateEmailLengthTest {
            @Nested
            @DisplayName("이메일 길이가 11자 이상 20자 미만이 아니라면")
            class Context_with_more_than_20_length_email {
                @Test
                @DisplayName("IllegalArgumentException 를 발생시킨다")
                void it_throws_IllegalArgumentException() {
                    nickname = "크롱";
                    email = "CrongCrongCrongCrong@email.com";
                    assertThatThrownBy(() -> new Crew(email, nickname)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }

        @Test
        @DisplayName("getTwoLetterListFromNickname 메소드는 닉네임을 두 글자로 분리한 리스트를 반환한다.")
        void getTwoLetterListFromNicknameTest() {
            nickname = "크로롱";
            email = "Crorong@email.com";
            Crew crew = new Crew(email, nickname);
            List<String> twoLetterListFromNickname = List.of("크로", "로롱");
            assertThat(crew.getTwoLetterListFromNickname()).isEqualTo(twoLetterListFromNickname);
        }

        @Nested
        @DisplayName("isOverlappedWith 메소드는")
        class isOverlappedWithTest {
            @Nested
            @DisplayName("중복된 닉네임을 가진 객체를 입력하면")
            class Context_with_overlapping_nicknames {
                @Test
                @DisplayName("true 를 반환한다")
                void it_throws_true() {
                    nickname = "크로롱";
                    email = "Crong@email.com";
                    Crew crew = new Crew(email, nickname);
                    String overlappingNickname = "크로";
                    String emailOfCro = "Cro@email.com";
                    assertThat(crew.isOverlappedWith(new Crew(emailOfCro, overlappingNickname))).isTrue();
                }
            }

            @Nested
            @DisplayName("중복되지 않는 닉네임을 가진 객체를 입력하면")
            class Context_with_not_overlapping_nicknames {
                @Test
                @DisplayName("false 를 반환한다")
                void it_throws_false() {
                    nickname = "크롱";
                    email = "Crong@email.com";
                    Crew crew = new Crew(email, nickname);
                    String notOverlappingNickname = "바바";
                    String emailOfBaba = "Baba@email.com";
                    assertThat(crew.isOverlappedWith(new Crew(emailOfBaba, notOverlappingNickname))).isFalse();
                }
            }
        }
        @Nested
        @DisplayName("equals 메소드와 hashCode 메소드는")
        class equalsAndHashCodeTest {
            @Nested
            @DisplayName("같은 닉네임과 이름의 객체를 비교하면")
            class Context_with_same_nickname_and_email {
                @Test
                @DisplayName("true 를 반환한다")
                void it_returns_true() {
                    Crew crew1 = new Crew("crong@email.com", "크롱");
                    Crew crew2 = new Crew("crong@email.com", "크롱");

                    assertThat(crew1.equals(crew2)).isTrue();
                    assertThat(crew1.hashCode() == crew2.hashCode()).isTrue();
                }
            }
        }

        @Nested
        @DisplayName("다른 닉네임과 이름의 객체를 비교하면")
        class Context_with_different_nickname_and_email {
            @Test
            @DisplayName("false 를 반환한다")
            void it_returns_true() {
                Crew crew1 = new Crew("crongg@email.com", "크롱");
                Crew crew2 = new Crew("crong@email.com", "크롱");

                assertThat(crew1.equals(crew2)).isFalse();
                assertThat(crew1.hashCode() == crew2.hashCode()).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("MainClass 메소드를 테스트한다")
    class MainClassTest {

        private Main main;

        @Test
        @DisplayName("makeCrewByNicknameAndEmail 메소드가 Crew 객체를 반환하는지 확인한다")
        void makeCrewByNicknameAndEmailTest() {
            main = new Main();
            String nickname = "크롱";
            String email = "crong@email.com";
            assertThat(main.makeCrewByEmailAndNickname(email, nickname)).isEqualTo(new Crew(email, nickname));
        }

        @Test
        @DisplayName("makeCollectionCrews 메소드가 Crews 객체를 반환하는지 확인한다")
        void makeCollectionCrewsTest() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            main = new Main();
            assertThat(main.makeCollectionCrews(forms)).isInstanceOf(Crews.class);
        }

        @Test
        @DisplayName("getAscendingEmailListFrom 메소드가 Crew 리스트에서 오름차순 정렬한 이메일 리스트를 반환하는지 확인한다")
        void getAscendingEmailListFromTest() {
            List<Crew> crewList = new ArrayList<>();
            crewList.add(new Crew("jm@email.com", "제이엠"));
            crewList.add(new Crew("jason@email.com", "제이슨"));
            crewList.add(new Crew("mj@email.com", "엠제이"));

            List<String> sortedEmailList = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            main = new Main();
            assertThat(main.getAscendingEmailListFrom(crewList)).isEqualTo(sortedEmailList);
        }
    }

    @Nested
    @DisplayName("Crews 클래스의 메소드를 테스트한다")
    class CrewsClassTest {

        private Main main = new Main();
        @Test
        @DisplayName("getCrewSetOverlappingWith 메소드가 crew 인스턴스를 전달했을 때 nickname이 중복되는 크루원들의 set을 반환하는지 확인한다")
        void getCrewSetOverlappingWithTest() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            Crews crews = main.makeCollectionCrews(forms);
            Crew crew = new Crew("jay@email.com", "제이");
            Set<Crew> crewSet = Set.of(new Crew("jm@email.com", "제이엠"),
                    new Crew("jason@email.com", "제이슨"),
                    new Crew("mj@email.com", "엠제이"));

            assertThat(crews.getCrewSetOverlappingWith(crew)).isEqualTo(crewSet);
        }

        @Test
        @DisplayName("getCrewListWithOverlappingNickname 메소드가 리스트 전체에서 nickname이 중복되는 크루원들의 List를 반환하는지 확인한다")
        void getCrewListWithOverlappingNicknameTest() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            Crews crews = main.makeCollectionCrews(forms);
            List<Crew> crewList = List.of(new Crew("jm@email.com", "제이엠"),
                    new Crew("jason@email.com", "제이슨"),
                    new Crew("mj@email.com", "엠제이"));

            assertThat(crews.getCrewListWithOverlappingNickname()).isEqualTo(crewList);
        }
    }
}