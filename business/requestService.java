package business;

public interface requestService {
    boolean requestLogIn(String userId, String password);
    void requestSignUp(userDataStructure data);
}
