package boardgameplanner.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import boardgameplanner.entity.Friend;
import boardgameplanner.entity.Game;
import boardgameplanner.entity.LoanLog;
import boardgameplanner.repository.FriendRepository;
import boardgameplanner.repository.GameRepository;
import boardgameplanner.repository.LoanLogRepository;

@Configuration
@Profile("demo")
public class DemoDataConfiguration {

    @Bean
    CommandLineRunner seedDemoData(
            GameRepository gameRepository,
            FriendRepository friendRepository,
            LoanLogRepository loanLogRepository) {
        return args -> {
            if (gameRepository.count() > 0 || friendRepository.count() > 0 || loanLogRepository.count() > 0) {
                return;
            }

            Game catan = game("Catan", 3, 4, "Medium");
            Game ticketToRide = game("Ticket to Ride", 2, 5, "Easy");
            Game azul = game("Azul", 2, 4, "Easy");
            gameRepository.saveAll(java.util.List.of(catan, ticketToRide, azul));

            Friend alex = friend("Alex Example", "alex@example.com");
            Friend sam = friend("Sam Example", "sam@example.com");
            Friend jordan = friend("Jordan Example", "jordan@example.com");
            friendRepository.saveAll(java.util.List.of(alex, sam, jordan));

            loanLogRepository.saveAll(java.util.List.of(
                    loan(catan.getId(), alex.getId()),
                    loan(ticketToRide.getId(), sam.getId())));
        };
    }

    private static Game game(String title, int minPlayers, int maxPlayers, String complexity) {
        Game game = new Game();
        game.setTitle(title);
        game.setMinPlayers(minPlayers);
        game.setMaxPlayers(maxPlayers);
        game.setComplexity(complexity);
        return game;
    }

    private static Friend friend(String name, String contact) {
        Friend friend = new Friend();
        friend.setName(name);
        friend.setContact(contact);
        return friend;
    }

    private static LoanLog loan(Long gameId, Long friendId) {
        LoanLog loan = new LoanLog();
        loan.setGameId(gameId);
        loan.setFriendId(friendId);
        loan.setBorrowDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(7));
        return loan;
    }
}
