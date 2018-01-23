package design.atmmachine;

public class Demo {

    public static void main(String[] args) {
        AtmMachine machine = new AtmMachine();
        machine.insertCard();
        machine.removeCard();
        machine.insertCard();
        machine.enterPin(1234);
        machine.getCash(10000);
        machine.insertCard();
    }
}
