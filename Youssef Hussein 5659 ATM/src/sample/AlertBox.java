package sample;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;



public class AlertBox {

    public static void displayLoginError(){
        Stage window1 = new Stage();

        window1.setTitle("Error!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);

        Label label = new Label();
        label.setText("Incorrect entry!\nRetry.");
        label.setFont(new Font("Verdana",15));
        label.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window1.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.showAndWait();
    }

    public static void displayNextPrevError(){
        Stage window1 = new Stage();

        window1.setTitle("Error!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);

        Label label = new Label();
        label.setText("No further records!");
        label.setFont(new Font("Verdana",15));
        label.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window1.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.showAndWait();
    }

    public static double displayNumbers() {
        Stage window = new Stage();
        GridPane grid = new GridPane();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinHeight(200);
        window.setMinWidth(300);

        window.setTitle("Transactions");

        Label labelNum = new Label();

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero = new Button("0");
        Button enterButton = new Button("Enter");
        Button clearButton = new Button("Clear");
        Label label = new Label("Enter value: ");

        grid.add(one, 0, 2);
        grid.add(two, 1, 2);
        grid.add(three, 2, 2);
        grid.add(four, 0, 1);
        grid.add(five, 1, 1);
        grid.add(six, 2, 1);
        grid.add(seven, 0, 0);
        grid.add(eight, 1, 0);
        grid.add(nine, 2, 0);
        grid.add(zero, 1, 3);
        grid.add(labelNum,3,2);
        grid.add(enterButton, 3, 3);
        grid.add(clearButton,4,3);
        grid.add(label,3,1);
        grid.setVgap(10);
        grid.setHgap(10);

        one.setOnAction(e-> labelNum.setText(labelNum.getText()+"1"));
        two.setOnAction(e-> labelNum.setText(labelNum.getText()+"2"));
        three.setOnAction(e-> labelNum.setText(labelNum.getText()+"3"));
        four.setOnAction(e-> labelNum.setText(labelNum.getText()+"4"));
        five.setOnAction(e-> labelNum.setText(labelNum.getText()+"5"));
        six.setOnAction(e-> labelNum.setText(labelNum.getText()+"6"));
        seven.setOnAction(e-> labelNum.setText(labelNum.getText()+"7"));
        eight.setOnAction(e-> labelNum.setText(labelNum.getText()+"8"));
        nine.setOnAction(e-> labelNum.setText(labelNum.getText()+"9"));
        zero.setOnAction(e-> labelNum.setText(labelNum.getText()+"0"));
        enterButton.setOnAction(e -> window.close());
        clearButton.setOnAction((e -> labelNum.setText("")));

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        String value = labelNum.getText();
        if(value == null || value.isEmpty()) { value = "0"; }
        return Double.valueOf(value);
    }

    public static void displayExit(){
        Stage window1 = new Stage();

        window1.setTitle("Thank you!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);

        Label label = new Label();
        label.setText("Thank you for using our services.\n Please do not forget your card!");
        label.setFont(new Font("Verdana",15));
        label.setTextFill(Color.web("#0000ff"));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window1.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.showAndWait();
    }

    public static void displayTransactions(){
        Queue lastTransactions = new Queue();

        Button closeButton = new Button("Close");
        Label label0 = new Label(lastTransactions.queue[0]);
        Label label1 = new Label(lastTransactions.queue[1]);
        Label label2 = new Label(lastTransactions.queue[2]);
        Label label3 = new Label(lastTransactions.queue[3]);
        Label label4 = new Label(lastTransactions.queue[4]);

        label0.setVisible(true);
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);

        Stage stage = new Stage();

        stage.setTitle("Last Five Transaction");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(320);
        stage.setMinHeight(250);

        GridPane grid = new GridPane();

        grid.add(label0,0,0);
        grid.add(label1,0,1);
        grid.add(label2,0,2);
        grid.add(label3,0,3);
        grid.add(label4,0,4);
        grid.add(closeButton,1,5);
        grid.setHgap(15);
        grid.setVgap(15);

        closeButton.setOnAction(e -> stage.close());



        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void displayNegativeBalanceChecker(){
        Stage window1 = new Stage();

        window1.setTitle("Error!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);

        Label label = new Label();
        label.setText("Insufficient amount!\nCurrent balance: "+ String.valueOf(Transactions.getBalance()));
        label.setFont(new Font("Verdana",15));
        label.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window1.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.showAndWait();
    }
}
