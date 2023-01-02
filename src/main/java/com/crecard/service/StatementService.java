package com.crecard.service;

import com.crecard.interfaces.IStatementService;
import com.crecard.model.Statement;
import com.crecard.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StatementService implements IStatementService {

    @Autowired
    StatementRepository statementRepository;
    @Override
    public Statement addStatement(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public Statement removeStatement(long id) {
        return statementRepository.deleteStatementByStatementId(id);
    }

    @Override
    public Statement updateStatement(long id, Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public Statement getStatement(long id) {
        Optional<Statement> statement = statementRepository.findById(id);
        return statement.orElse(null);
    }

    @Override
    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    @Override
    public List<Statement> getBilledStatement(long customerId) {
        Statement statement = statementRepository.findFirstByCustomerId(customerId);
        return statementRepository.getBilledStatements(statement.getBillingDate());
    }


    @Override
    public List<Statement> getUnBilledStatement(long id){
        Statement statement = statementRepository.findFirstByCustomerId(id);
        return statementRepository.getUnBilledStatements(statement.getBillingDate());
    }

    @Override
    public List<Statement> getCustomerStatements(long id) {
        return statementRepository.findAllByCustomerId(id);
    }

}
