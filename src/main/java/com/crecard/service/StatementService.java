package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.interfaces.IStatementService;
import com.crecard.model.Statement;
import com.crecard.repository.IStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StatementService implements IStatementService {

    @Autowired
    IStatementRepository statementRepository;
    @Override
    public Statement addStatement(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public Statement removeStatement(long id) {
        Statement statement =getStatement(id);
        statementRepository.deleteStatementByStatementId(id);
        return  statement;
    }

    @Override
    public Statement updateStatement(long id, Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public Statement getStatement(long id) {
        Optional<Statement> statement = statementRepository.findById(id);
        return statement.orElseThrow(()-> new CustomException("Statement Not Exists with id :"+id));
    }

    @Override
    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    @Override
    public List<Statement> getBilledStatement() {
        return statementRepository.getBilledStatements(LocalDate.now());
    }


    @Override
    public List<Statement> getUnBilledStatement(){
        return statementRepository.getUnBilledStatements(LocalDate.now());
    }

    @Override
    public List<Statement> getCustomerStatements(long id) {
        return statementRepository.findAllByCustomerId(id);
    }

}
