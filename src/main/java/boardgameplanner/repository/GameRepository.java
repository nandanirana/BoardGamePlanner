package boardgameplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boardgameplanner.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByMinPlayersLessThanEqualAndMaxPlayersGreaterThanEqual(int minPlayers, int maxPlayers);
}