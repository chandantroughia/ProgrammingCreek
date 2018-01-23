package design.atmmachine;

public class AtmMachine {
    AtmState noCash;
    AtmState hasCorrectPin;
    AtmState noCard;
    AtmState hasCard;

    AtmState atmState;
    boolean isCorrectPinEntered = false;

    int cashInMachine = 10000;

    public AtmMachine(){
        noCash = new NoCash(this);
        hasCorrectPin = new HasPin(this);
        noCard = new NoCard(this);
        hasCard = new HasCard(this);

        atmState = noCard;
        if(cashInMachine == 0){
            atmState = noCash;
        }
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }
    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    void insertCard(){
        atmState.insertCard();
    }
    void removeCard(){
        atmState.removeCard();
    }
    void enterPin(int pin){
        atmState.enterPin(pin);
    }
    void getCash(int castToWithdraw){
        atmState.getCash(castToWithdraw);
    }
    public AtmState getNoCash() {
        return noCash;
    }

    public AtmState getHasCorrectPin() {
        return hasCorrectPin;
    }

    public AtmState getNoCard() {
        return noCard;
    }

    public AtmState getHasCard() {
        return hasCard;
    }

}
