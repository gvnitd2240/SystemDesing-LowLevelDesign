package org.example.SplitWise.Expense;

import org.example.SplitWise.Expense.Split.ExpenseSplit;
import org.example.SplitWise.Expense.Split.Split;
import org.example.SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
//    BalanceSheetController balanceSheetController;
//    public ExpenseController(){
//        balanceSheetController = new BalanceSheetController();
//    }



    public Expense createExpense(String expenseId, double expenseAmount, String description,
                                 User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails){
        ExpenseSplit expenseSplit = SplitFactory.getSplitType(splitType);

        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

//        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;

    }
}
