package sample;

public class Queue
{
    History lastTransaction = new History();
    static String queue[] = new String[]{" "," "," "," "," "};

    public int getPtr() {
        return ptr-1;
    }

    public void setPtr() {
        this.ptr++;
    }

    int ptr=0;
    int rear=0; // to insert
    int size=0;
    int index=-1;
    public void push(double data)
    {
        if (data>0){
            if(lastTransaction.isWithdraw())
            {
                queue[rear%5] = "  Withdraw: "+data+"$";
                rear = (rear + 1) % 5;
                size++;
                ptr=size;
                ++index;
            }
            else if (lastTransaction.isDeposit())
            {
                queue[rear%5] ="  Deposit: "+data+"$";
                rear++;
                size++;
                ptr=size;
                ++index;
            }
        }

    }
    public int getSize()
    {
        if (size>5)
            size=5;
        return size;
    }

    public String showPrev(){ return queue[(--ptr)%5]; }
    public String showNext(){ return queue[(++ptr)%5]; }

}
