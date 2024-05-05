package org.example.SplitWise;

import org.example.SplitWise.Expense.Split.Split;
import org.example.SplitWise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount){
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split: splits){
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if(userOwe.getUserId() == expensePaidBy.getUserId()){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            } else {
                //check from here.
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);
            }

        }
    }

    public void showBalanceSheetOfUser(User user){
        System.out.println("---------------------------------------");
        System.out.println(user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());

        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());

        }
        System.out.println("---------------------------------------");
    }
}
