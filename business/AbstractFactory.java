package business;

public interface AbstractFactory<T> {
    T create(String type, UserDataStructure uSD, int groceryListIndex) ;
}
