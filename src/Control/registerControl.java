package Control;

import Bank.User;

public class registerControl {
        public boolean ageControl(User user) {
            return user.getAge() > 18 && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty() && !user.getPhoneNumber().isEmpty() && !user.getPassword().isEmpty();
        }
}
