package boardgameplanner.controller;

import org.springframework.web.bind.annotation.*;

import boardgameplanner.entity.LoanLog;
import boardgameplanner.repository.LoanLogRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/loans")
public class LoanLogController {

    private final LoanLogRepository loanLogRepository;

    public LoanLogController(LoanLogRepository loanLogRepository) {
        this.loanLogRepository = loanLogRepository;
    }

    @GetMapping
    public List<LoanLog> getAllLoans() {
        return loanLogRepository.findAll();
    }

    @PostMapping
    public LoanLog addLoan(@RequestBody LoanLog loanLog) {
        return loanLogRepository.save(loanLog);
    }
}