package Problems.ATM.ATMStates;


import Problems.ATM.*;
import Problems.ATM.AmountWithdrawl.*;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
