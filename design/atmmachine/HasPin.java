package design.atmmachine;

public class HasPin implements AtmState {

    AtmMachine atmMachine;
    public HasPin(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Only one card at a time.");
    }

    @Override
    public void removeCard() {
        System.out.println("Please take your card.");
        atmMachine.setAtmState(atmMachine.getNoCard());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("You have already entered the pin");
    }

    @Override
    public void getCash(int castToWithdraw) {
        System.out.println("Please take your cash amount: " + castToWithdraw);
        atmMachine.setCashInMachine(atmMachine.cashInMachine - castToWithdraw);
        System.out.println("Your card is removed.");
        atmMachine.setAtmState(atmMachine.noCard);

        if(atmMachine.cashInMachine <= 0){
            atmMachine.setAtmState(atmMachine.getNoCash());
            System.out.println("Not enough cash.");
        }
    }
}
