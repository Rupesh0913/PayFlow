package com.airtribe.payFlow.service;

import com.airtribe.payFlow.entity.Transaction;
import com.airtribe.payFlow.entity.User;
import com.airtribe.payFlow.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Transactional
    public Transaction sendMoney(Transaction transaction) {
        User sender = userService.findByUpiId(transaction.getSenderUpiId());
        User reciver = userService.findByUpiId(transaction.getReceiverUpiId());

        if(null == sender) {
            throw new RuntimeException("Sender's upi Id is not valid");
        }
        if(null == reciver) {
            throw new RuntimeException("Receiver's upi Id is not valid");
        }

        if(sender.getBalance() < transaction.getAmount()) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        reciver.setBalance(reciver.getBalance() + transaction.getAmount());

        userService.saveUser(sender);
        userService.saveUser(reciver);
        return transactionRepository.save(transaction);
    }
}
