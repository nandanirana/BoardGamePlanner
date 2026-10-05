package boardgameplanner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import boardgameplanner.repository.FriendRepository;
import boardgameplanner.repository.GameRepository;
import boardgameplanner.repository.LoanLogRepository;

@SpringBootTest
@ActiveProfiles("demo")
class DemoDataConfigurationTests {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private LoanLogRepository loanLogRepository;

    @Test
    void seedsFictionalDemoRecords() {
        assertThat(gameRepository.count()).isEqualTo(3);
        assertThat(friendRepository.count()).isEqualTo(3);
        assertThat(loanLogRepository.count()).isEqualTo(2);
        assertThat(friendRepository.findAll())
                .extracting("contact")
                .allMatch(contact -> ((String) contact).endsWith("@example.com"));
    }
}
