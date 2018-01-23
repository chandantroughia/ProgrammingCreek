package design.atmmachine;

public interface AtmState {
    //NoCard, HasCard, NoCash, HasPin
    void insertCard();
    void removeCard();
    void enterPin(int pin);
    void getCash(int castToWithdraw);
}
