package daicent.main;

import daicent.dao.UserReflection;
import daicent.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user5 = new User();
        user5.setId(1);
        UserReflection.getInstance().selectById(user5.getId());

        System.out.println("--------------------------------------------------");
        List<User> list = UserReflection.getInstance().sellectAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
