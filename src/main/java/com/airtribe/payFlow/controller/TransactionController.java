package com.airtribe.payFlow.controller;

import com.airtribe.payFlow.entity.Transaction;
import com.airtribe.payFlow.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // POST /transactions
    @PostMapping
    public Transaction sendMoney(@RequestBody Transaction transaction) {
        return transactionService.sendMoney(transaction);
    }
}
