package design.atmmachine;

public class NoCash implements AtmState {

    AtmMachine atmMachine;
    public NoCash(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("We don't have any cash.");
    }

    @Override
    public void removeCard() {
        System.out.println("We don't have any cash.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("We don't have any cash.");
    }

    @Override
    public void getCash(int castToWithdraw) {
        System.out.println("We don't have any cash.");
    }
}
