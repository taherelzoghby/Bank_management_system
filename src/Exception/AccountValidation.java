package Exception;

public class AccountValidation extends Exception {

    public AccountValidation() {

    }

    public void checkEmail(String email) throws InvalidAccount {
        if (!email.contains("@")) {
            throw new InvalidAccount("Email is not valid!");
        }
        if (email.isEmpty()) {
            throw new InvalidAccount("Email is empty!");
        }
    }

    public void checkPassword(String password) throws InvalidAccount {
        if (password.length() < 7) {
            throw new InvalidAccount("password length is short!");
        }
        if (password.isEmpty()) {
            throw new InvalidAccount("password is empty!");
        }
    }

    public void checkCardNum(String cardNum) throws InvalidAccount {
        if (cardNum.length() != 14) {
            throw new InvalidAccount("Card number length is short!");
        }
        if (cardNum.isEmpty()) {
            throw new InvalidAccount("Card number is empty!");
        }
    }

    public void checkPhoneNum(String phoneNum) throws InvalidAccount {
        if (phoneNum.length() != 11) {
            throw new InvalidAccount("PhoneNum  is not valid!");
        }
        if (phoneNum.isEmpty()) {
            throw new InvalidAccount("phoneNumber is empty!");
        }
    }
}
