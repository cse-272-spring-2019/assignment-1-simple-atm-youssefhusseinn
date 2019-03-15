package sample;

public class Transactions
{
    private static double deposit,withdraw,balance=0;

    public void setDeposit(double deposit) { balance = balance + deposit; }

    public void setWithdraw(double withdraw)
    {
        balance = balance - withdraw;
    }

    public static double getBalance()
    {
        return balance;
    }
}
