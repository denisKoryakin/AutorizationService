package ru.koryakin.springboot2autorizationservice.repository;

import ru.koryakin.springboot2autorizationservice.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Ivan", "Dorn1988"));
        users.get(0).setAuthorities(new Authorities[]{Authorities.READ, Authorities.DELETE, Authorities.WRITE});
        users.add(new User("Jason", "Born1979"));
        users.get(1).setAuthorities(new Authorities[]{Authorities.READ});
        users.add(new User("Brus", "Li1940"));
        users.get(2).setAuthorities(new Authorities[]{Authorities.READ, Authorities.WRITE});
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> returnedUsers = new ArrayList<>();
        Optional<List<Authorities>> authorities = users.stream()
                .filter(x -> x.getUser().equals(user))
                .filter(x -> x.getPassword().equals(password))
                .map(User::getAuthorities)
                .findFirst();
        if (authorities.isPresent()) {
            returnedUsers = authorities.get();
        }
        return returnedUsers;
    }
}
