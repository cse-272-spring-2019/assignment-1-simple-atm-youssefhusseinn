package sample;

import javafx.scene.control.Alert;

public class Validation {
    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Validation.flag = flag;
    }

    private static boolean flag = false;
    private static boolean disableFlag = false;

    static double value;

    public static double checkValidity(){
        do{
            value = AlertBox.displayNumbers();
            if(value<Transactions.getBalance()||value==0)
                setFlag(true);
            else
                AlertBox.displayNegativeBalanceChecker();
        }while(!isFlag());
        setFlag(false);
        return value;
    }

}
