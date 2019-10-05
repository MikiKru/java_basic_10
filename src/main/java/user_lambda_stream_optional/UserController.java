package user_lambda_stream_optional;

import java.util.*;

public class UserController {
    private List<User> users = new ArrayList<>();
    // metoda rejestrująca użytkownika w liście users
    public void registerUser(String login, String password){
        users.add(new User(login, password));
    }
    // metoda wypisująca użytkowników
    public void getAllUsers(){
        users.forEach(System.out::println);
//        users.forEach(user -> System.out.println(user));
    }
    // metoda zwracająca boolean determinujący zalogowanie użytkownika
    // -> login -> password jeżeli jest w users to zwróć obiekt User
    public Boolean loginUser(String login, String password){
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findAny();
        // sprawdzamy czy optional zawiera wartość niepustą
        return userOptional.isPresent();
    }
    // metoda zmieniająca role użytkownika na podaną w argumencie
    public void setRoleToUserByLogin(String login, Role role){
        users.stream()
                .filter(user -> user.getLogin().equals(login))  // wyszukaj usera po loginie
                .findAny()                                      // zwróć Optional<User>
                .ifPresent(user -> user.setRole(role));         // jeśli jest niepusty zmień role
                                                                // jeśli jest null -> nic nie rób
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.registerUser("a","a");
        userController.registerUser("b","b");
        userController.registerUser("c","c");
        userController.registerUser("d","d");
        userController.getAllUsers();
        System.out.println("Czy użytkownik został zalogowany: " + userController.loginUser("b","b"));
        System.out.println("Czy użytkownik został zalogowany: " + userController.loginUser("b","c"));
        userController.setRoleToUserByLogin("a",Role.ADMIN);
        userController.setRoleToUserByLogin("abc",Role.ADMIN);
        userController.getAllUsers();
    }
}
