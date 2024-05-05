package org.example.SplitWise.Group;

import org.example.SplitWise.Expense.Expense;
import org.example.SplitWise.Expense.ExpenseController;
import org.example.SplitWise.Expense.ExpenseSplitType;
import org.example.SplitWise.Expense.Split.Split;
import org.example.SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;
    Group(){
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }
    public void addMember(User member){
        groupMembers.add(member);
    }
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId,expenseAmount,  description, paidByUser,splitType, splitDetails);
        expenseList.add(expense);
        return expense;
    }
}
