import service.SessionManager;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addPersons("pavel");
        sessionManager.addPersons("Kolya");
        sessionManager.addPersons("Vasiliy");
        sessionManager.addExpence("bar", "pavel", BigDecimal.valueOf(900));
        sessionManager.printExpence();
    }
}

