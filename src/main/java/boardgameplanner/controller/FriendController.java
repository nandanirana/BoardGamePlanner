package boardgameplanner.controller;

import org.springframework.web.bind.annotation.*;

import boardgameplanner.entity.Friend;
import boardgameplanner.repository.FriendRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/friends")
public class FriendController {

    private final FriendRepository friendRepository;

    public FriendController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @GetMapping
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    @PostMapping
    public Friend addFriend(@RequestBody Friend friend) {
        return friendRepository.save(friend);
    }
}