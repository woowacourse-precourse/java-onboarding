package onboarding;


import onboarding.problem6.domain.Crew;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }
}