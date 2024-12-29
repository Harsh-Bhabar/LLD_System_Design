package Problems.Splitwise.Split;

import Problems.Splitwise.ENUMS.ExpenseSplitType;

import static Problems.Splitwise.ENUMS.ExpenseSplitType.*;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        if (splitType == EQUAL) {
            return new EqualExpenseSplit();
        } else if (splitType == UNEQUAL) {
            return new UnequalExpenseSplit();
        } else if (splitType == PERCENTAGE) {
            return new PercentageExpenseSplit();
        }
        return null;
    }
}

