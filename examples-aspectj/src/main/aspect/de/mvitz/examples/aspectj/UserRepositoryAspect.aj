package de.mvitz.examples.aspectj;

import java.util.ArrayList;
import java.util.List;

public aspect UserRepositoryAspect {

    private static List<User> User.users = new ArrayList<User>();

    public static List<User> User.findAll() {
        return users;
    }

    public void User.save() {
        users.add(this);
    }

}
