package org.example.SplitWise.Expense;

import org.example.SplitWise.Expense.Split.EqualExpenseSplit;
import org.example.SplitWise.Expense.Split.ExpenseSplit;
import org.example.SplitWise.Expense.Split.PercentageExpenseSplit;
import org.example.SplitWise.Expense.Split.UnEqualExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitType(ExpenseSplitType type){
        if (type == ExpenseSplitType.EQUAL){
            return new EqualExpenseSplit();
        } else if (type == ExpenseSplitType.UNEQUAL){
            return new UnEqualExpenseSplit();
        } else if (type == ExpenseSplitType.PERCENTAGE){
            return new PercentageExpenseSplit();
        } else return null;
    }
}
