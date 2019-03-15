package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main<Textfield> extends Application  {

    //Logic Code Objects
    Transactions trans = new Transactions();
    History setTrue = new History();
    Queue list = new Queue();

    Stage stage1,stage2;
    Scene scene1,scene2;

    //scene 1 objects
    Button loginButton= new Button();
    Label cardNumberLabel;
    PasswordField cardNumberField;

    //scene 2 objects
    Button depositButton = new Button("Deposit");
    Button withdrawButton = new Button("Withdraw");
    Button balanceButton = new Button("Balance Inquiry");
    Button nextButton = new Button("Next Transaction");
    Button prevButton = new Button("Previous Transaction");
    Button transactionsButton = new Button("Last 5 Transactions");
    Button logoutButton = new Button("Logout");
    Label label = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Automated Teller Machine");

        LoginAuthentication authentication = new LoginAuthentication();
        //AlertBox alertBox = new AlertBox();

        cardNumberLabel = new Label("Card Number: ");
        cardNumberField = new PasswordField();
        loginButton.setText("Login");
        Label validationLabel = new Label();

        GridPane grid1,grid2;
        grid2 = new GridPane();

        //scene 1 appearance
        grid1 = new GridPane();
        grid1.add(cardNumberLabel,0,0);
        grid1.add(cardNumberField,1,0);
        grid1.add(loginButton,1,1);
        grid1.add(validationLabel,1,2);
        grid1.setAlignment(Pos.CENTER);

        //scene 2 appearance
        grid2.add(depositButton,0,0);
        grid2.add(withdrawButton,0,1);
        grid2.add(balanceButton,0,2);
        grid2.add(logoutButton,2,3);
        grid2.add(nextButton,1,0);
        grid2.add(prevButton,1,1);
        grid2.add(transactionsButton,2,0);
        grid2.add(label,1,2);
        grid2.setVgap(35);
        grid2.setHgap(35);

        scene1 = new Scene(grid1,450,250);
        scene2 = new Scene(grid2,450,250);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String cardNumber = cardNumberField.getText();
                boolean valid = authentication.validate(cardNumber);
                if (valid)
                    primaryStage.setScene(scene2);
                else
                    AlertBox.displayLoginError();
            }
        });

        logoutButton.setOnAction(e->{
            primaryStage.setScene(scene1);
            AlertBox.displayExit();
        });

        depositButton.setOnAction(e->{
            double value = AlertBox.displayNumbers();
            trans.setDeposit(value);
            setTrue.setDeposit(true);
            list.push(value);
            if (value> 0){label.setText("Successful operation.");}
            setTrue.setDeposit(false);
        });

        withdrawButton.setOnAction(e->{
            double value = Validation.checkValidity();
            trans.setWithdraw(value);
            setTrue.setWithdraw(true);
            list.push(value);
            if (value> 0){label.setText("Successful operation.");}
            setTrue.setWithdraw(false);
        });

        balanceButton.setOnAction(e-> label.setText("Current Balance: "+trans.getBalance()+"$"));

        nextButton.setOnAction(e->{
            if(((list.getPtr()%5)+1)!=4){
                if(list.queue[(list.getPtr()+2)%5].equals(" ") || list.queue[(list.getPtr()+2)%5].isEmpty()){
                    label.setText("Current Balance: "+Transactions.getBalance()+"$");
                    nextButton.setDisable(true);
                    list.setPtr();
                }

                else
                    label.setText(list.showNext());
            }
            else
                AlertBox.displayNextPrevError();
        });

        prevButton.setOnAction(e->{
            if(((list.getPtr()%5)+1) ==0)
                AlertBox.displayNextPrevError();
            else{
                label.setText(list.showPrev());
                nextButton.setDisable(false);
            }

        });

        transactionsButton.setOnAction(e-> AlertBox.displayTransactions());

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
