package design.atmmachine;

public class NoCard implements AtmState {
    AtmMachine atmMachine;
    public NoCard(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card is inserted.");
        atmMachine.setAtmState(atmMachine.getHasCard());
    }

    @Override
    public void removeCard() {
        System.out.println("Please insert the card first.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Please insert the card first.");
    }

    @Override
    public void getCash(int castToWithdraw) {
        System.out.println("Please insert the card first.");
    }
}
