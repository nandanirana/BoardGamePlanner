package boardgameplanner.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import boardgameplanner.entity.Game;
import boardgameplanner.repository.GameRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/games")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/filter")
    public List<Game> filterGamesByPlayerCount(@RequestParam int players) {
        return gameRepository.findByMinPlayersLessThanEqualAndMaxPlayersGreaterThanEqual(players, players);
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        if (!gameRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        gameRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}