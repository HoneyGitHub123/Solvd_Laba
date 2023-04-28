package airport;

public interface Payment {
    //Abstract method
    void getPayment(String cardNum, String currency, double price);
}
