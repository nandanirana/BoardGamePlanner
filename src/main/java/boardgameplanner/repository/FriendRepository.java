package boardgameplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boardgameplanner.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}