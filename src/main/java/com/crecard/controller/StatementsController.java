package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Statement;
import com.crecard.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@RestController
@RequestMapping("/statements")
public class StatementsController {
    @Autowired
    StatementService statementService;

    @GetMapping
    public List<Statement> index(){
        return statementService.getAllStatements();
    }

    @PutMapping("/{id}")
    public Statement  update(@RequestBody Statement Statement, @PathVariable("id") long id){
        return statementService.updateStatement(id,Statement);
    }

    @PostMapping
    public Statement create(@RequestBody Statement Statement){
        return statementService.addStatement(Statement);
    }

    @DeleteMapping("/{id}")
    public Statement delete(@PathVariable("id") long id){
        return statementService.removeStatement(id);
    }
    @GetMapping("/{id}")
    public Statement show(@PathVariable("id") long id){return  statementService.getStatement(id);}

    @GetMapping("/customer/{id}")
    public List<Statement> getCustomerStatements(@PathVariable("id") long id){
        return statementService.getCustomerStatements(id);
    }

    @GetMapping("/billed/customer/{id}")
    public List<Statement> getBilledStatements(@PathVariable("id") long id){
        return statementService.getBilledStatement(id);
    }

    @GetMapping("/un_billed/customer/{id}")
    public List<Statement> getUnBilledStatements(@PathVariable("id") long id){
        return statementService.getUnBilledStatement(id);
    }

}

