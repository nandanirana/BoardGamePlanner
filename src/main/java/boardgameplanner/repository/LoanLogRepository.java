package boardgameplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boardgameplanner.entity.LoanLog;

public interface LoanLogRepository extends JpaRepository<LoanLog, Long> {
}