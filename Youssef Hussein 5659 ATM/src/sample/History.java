package sample;

public class History
{
    private static boolean deposit = false;
    private static boolean withdraw = false;
    public static boolean isDeposit()
    {
        return deposit;
    }

    public static void setDeposit(boolean d)
    { deposit = d; }

    public static boolean isWithdraw()
    { return withdraw; }

    public static void setWithdraw(boolean w)
    { withdraw = w; }
}
