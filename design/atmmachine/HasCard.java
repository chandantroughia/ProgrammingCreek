package design.atmmachine;

public class HasCard implements AtmState {

    AtmMachine atmMachine;
    public HasCard(AtmMachine atmMachine) {
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
        if(pin == 1234){
            System.out.println("you have entered the correct pin");
            atmMachine.isCorrectPinEntered = true;
            atmMachine.setAtmState(atmMachine.getHasCorrectPin());
        }else{
            System.out.println("you have entered the incorrect pin");
            atmMachine.isCorrectPinEntered = false;
            System.out.println("Your card is removed");
            atmMachine.setAtmState(atmMachine.getNoCard());
        }
    }

    @Override
    public void getCash(int castToWithdraw) {
        System.out.println("Plase enter the pin first.");
    }
}
