package by.bsu.zorg.test;

public interface PageApi {
    String openMain();
    String openSearchResults();
    String openProduct();
    void login(String email, String password);
    void emptyLogin();
}
