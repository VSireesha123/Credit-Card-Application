package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Statement;
import com.crecard.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@RestController
@RequestMapping("/statements")
public class StatementsController {
    @Autowired
    StatementService statementService;

    @GetMapping("/getAllStatements")
    @ResponseStatus(HttpStatus.OK)
    public List<Statement> index(){
        return statementService.getAllStatements();
    }

    @PutMapping("/updateStatement/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Statement  update(@RequestBody Statement Statement, @PathVariable("id") long id){
        return statementService.updateStatement(id,Statement);
    }

    @PostMapping("/addStatement")
    @ResponseStatus(HttpStatus.CREATED)
    public Statement addStatement(@RequestBody Statement Statement){
        return statementService.addStatement(Statement);
    }

    @DeleteMapping("/removeStatement/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Statement removeStatement(@PathVariable("id") long id){
        return statementService.removeStatement(id);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Statement show(@PathVariable("id") long id){return  statementService.getStatement(id);}

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Statement> getCustomerStatements(@PathVariable("id") long id){
        return statementService.getCustomerStatements(id);
    }

    @GetMapping("/getBilledStatements")
    @ResponseStatus(HttpStatus.OK)
    public List<Statement> getBilledStatements(){
        return statementService.getBilledStatement();
    }

    @GetMapping("/getUnBilledStatements")
    @ResponseStatus(HttpStatus.OK)
    public List<Statement> getUnBilledStatements(){
        return statementService.getUnBilledStatement();
    }

}

