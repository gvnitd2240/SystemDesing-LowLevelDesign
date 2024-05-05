package org.example.SplitWise;

import org.example.SplitWise.Expense.ExpenseSplitType;
import org.example.SplitWise.Expense.Split.Split;
import org.example.SplitWise.Group.Group;
import org.example.SplitWise.Group.GroupController;
import org.example.SplitWise.User.User;
import org.example.SplitWise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    Splitwise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() throws Exception {
        setupUserAndGroup();
        Group group = groupController.getGroup("G1001");

        group.addMember(userController.getUser("2"));
        group.addMember(userController.getUser("3"));

        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("1"), 300);
        Split split2 = new Split(userController.getUser("2"), 300);
        Split split3 = new Split(userController.getUser("3"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        group.createExpense("Exp1001", "Breakfast", 900, splits, ExpenseSplitType.EQUAL, userController.getUser("1"));

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new Split(userController.getUser("1"), 400);
        Split splits2_2 = new Split(userController.getUser("2"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);
        group.createExpense("Exp1002", "Lunch", 500, splits2, ExpenseSplitType.UNEQUAL, userController.getUser("U2001"));

        for(User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }

    }

    public void setupUserAndGroup() throws Exception {
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing with Friends", user1);
    }

    public void addUsers(){
        userController.add("1", "vivek");
        userController.add("2", "keshav");
        userController.add("3", "nagi");
    }


}
