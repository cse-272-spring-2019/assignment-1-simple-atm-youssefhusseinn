package sample;

public class LoginAuthentication {

    public boolean validate(String password){
        boolean validationResult=false;
        if (password.equals("1111"))
            validationResult=true;
        return validationResult;
    }
}
