package com.airtribe.payFlow.service;

import com.airtribe.payFlow.entity.Transaction;
import com.airtribe.payFlow.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /*
     * Spring creates the TransactionRepository object automatically
     * at startup and injects it here using @Autowired.
     */

    public Transaction sendMoney(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
