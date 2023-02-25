package animalfarm;

public class CurrencySingleton {
    private static CurrencySingleton instance = null;
    private static int currency = 0;

    private CurrencySingleton() {
    }

    public static CurrencySingleton getInstance() {
        if (instance == null) {
            instance = new CurrencySingleton();
            currency = 100;
        }
        return instance;
    }
    
    public int getCurrency() {
        return currency;
    }
    
    public void setCurrency(int amount) {
        currency = amount;
    }
}