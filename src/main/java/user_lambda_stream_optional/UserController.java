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
    // metoda sprawdzająca status użytkownika status zwraca boolean
    public Boolean getUserStatus(String login){
        // szukam użytkownika o określonym w argumentcie loginie i zwracam jego status
        Optional<User> foundUser = users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
        // jeśli znaloziono użytkownika
        if (foundUser.isPresent()){
            // zwróć status znalezieonego użyhtkownika
            return foundUser.get().getStatus();
        }
        // gdy nie znaleziono użytkownika
        return false;
    }
    // metoda zwracająca użytkowanika po loginie
    public Optional<User> getUserByLogin(String login){
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }
    // metoda logująca użytkownika którego status jest true
    public Boolean loginUserCustom(String login, String password){
        // sprawdzenie aktywności
        if(getUserStatus(login)){
            // metoda logująca użytkownika zwraca true lub false
            if(loginUser(login, password)){
                // zwiększam logincounter na 3
                User user = getUserByLogin(login).get();
                user.setLoginCounter(3);
                System.out.println("ZALOGOWANO: "+ user);
                return true;
            } else {
                Optional<User> userOptional = getUserByLogin(login);
                // gdy podałem dobry login i błędne hasło
                if (userOptional.isPresent()){
                    User user = userOptional.get();
                    user.setLoginCounter(user.getLoginCounter() - 1);
                    // gdy pomyliłem się 3 razy dla tego samego loginu
                    if(user.getLoginCounter() <= 0){
                        // zablokowanie konta
                        user.setStatus(false);
                        System.out.println("KONTO ZABLOKOWANE");
                    }
                    System.out.println("BŁĄD LOGOWANIA");
                    return false;
                }
                return false;
            }
        }
        // gdy użytkownik jest nieaktywny
        return false;
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

        userController.loginUserCustom("c","c");
        userController.loginUserCustom("c","e");
        userController.loginUserCustom("c","e");
        userController.loginUserCustom("c","e");
        userController.loginUserCustom("c","e");

    }
}
