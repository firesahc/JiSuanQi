package org;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;

public class CaculatorDemo extends Application {
    StringBuilder formulaBuilder = new StringBuilder();
    StringBuilder resultBuilder = new StringBuilder();
    Label formulaLabel = new Label();
    Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane1 = new GridPane();
        pane1.setAlignment(Pos.CENTER);
        //添加节点
        Button button0 = new Button("mc");
        button0.setPrefSize(120, 80);button0.setFont(Font.font(30));
        Button button1 = new Button("mr");
        button1.setPrefSize(120, 80);button1.setFont(Font.font(30));
        Button button2 = new Button("(");
        button2.setPrefSize(120, 80);button2.setFont(Font.font(30));
        Button button3 = new Button(")");
        button3.setPrefSize(120, 80);button3.setFont(Font.font(30));

        Button button4 = new Button("C");
        button4.setPrefSize(120, 80);button4.setFont(Font.font(30));
        Button button5 = new Button("/");
        button5.setPrefSize(120, 80);button5.setFont(Font.font(30));
        Button button6 = new Button("*");
        button6.setPrefSize(120, 80);button6.setFont(Font.font(30));
        Button button7 = new Button("D");
        button7.setPrefSize(120, 80);button7.setFont(Font.font(30));

        Button button8 = new Button("7");
        button8.setPrefSize(120, 80);button8.setFont(Font.font(30));
        Button button9 = new Button("8");
        button9.setPrefSize(120, 80);button9.setFont(Font.font(30));
        Button button10 = new Button("9");
        button10.setPrefSize(120, 80);button10.setFont(Font.font(30));
        Button button11 = new Button("-");
        button11.setPrefSize(120, 80);button11.setFont(Font.font(30));

        Button button12 = new Button("4");
        button12.setPrefSize(120, 80);button12.setFont(Font.font(30));
        Button button13 = new Button("5");
        button13.setPrefSize(120, 80);button13.setFont(Font.font(30));
        Button button14 = new Button("6");
        button14.setPrefSize(120, 80);button14.setFont(Font.font(30));
        Button button15 = new Button("+");
        button15.setPrefSize(120, 80);button15.setFont(Font.font(30));

        Button button16 = new Button("1");
        button16.setPrefSize(120, 80);button16.setFont(Font.font(30));
        Button button17 = new Button("2");
        button17.setPrefSize(120, 80);button17.setFont(Font.font(30));
        Button button18 = new Button("3");
        button18.setPrefSize(120, 80);button18.setFont(Font.font(30));
        Button button19 = new Button("^");
        button19.setPrefSize(120, 80);button19.setFont(Font.font(30));

        Button button20 = new Button("%");
        button20.setPrefSize(120, 80);button20.setFont(Font.font(30));
        Button button21 = new Button("0");
        button21.setPrefSize(120, 80);button21.setFont(Font.font(30));
        Button button22 = new Button(".");
        button22.setPrefSize(120, 80);button22.setFont(Font.font(30));
        Button button23 = new Button("=");
        button23.setPrefSize(120, 80);button23.setFont(Font.font(30));

        //设置位置
        pane1.add(button0, 0, 0);
        pane1.add(button1, 1, 0);
        pane1.add(button2, 2, 0);
        pane1.add(button3, 3, 0);

        pane1.add(button4, 0, 1);
        pane1.add(button5, 1, 1);
        pane1.add(button6, 2, 1);
        pane1.add(button7, 3, 1);

        pane1.add(button8, 0, 2);
        pane1.add(button9, 1, 2);
        pane1.add(button10, 2, 2);
        pane1.add(button11, 3, 2);

        pane1.add(button12, 0, 3);
        pane1.add(button13, 1, 3);
        pane1.add(button14, 2, 3);
        pane1.add(button15, 3, 3);

        pane1.add(button16, 0, 4);
        pane1.add(button17, 1, 4);
        pane1.add(button18, 2, 4);
        pane1.add(button19, 3, 4);

        pane1.add(button20, 0, 5);
        pane1.add(button21, 1, 5);
        pane1.add(button22, 2, 5);
        pane1.add(button23, 3, 5);

        //添加Action
        button0.setOnAction(new action());
        button1.setOnAction(new action());
        button2.setOnAction(new action());
        button3.setOnAction(new action());

        button4.setOnAction(new action());
        button5.setOnAction(new action());
        button6.setOnAction(new action());
        button7.setOnAction(new action());

        button8.setOnAction(new action());
        button9.setOnAction(new action());
        button10.setOnAction(new action());
        button11.setOnAction(new action());

        button12.setOnAction(new action());
        button13.setOnAction(new action());
        button14.setOnAction(new action());
        button15.setOnAction(new action());

        button16.setOnAction(new action());
        button17.setOnAction(new action());
        button18.setOnAction(new action());
        button19.setOnAction(new action());

        button20.setOnAction(new action());
        button21.setOnAction(new action());
        button22.setOnAction(new action());
        button23.setOnAction(new action());

        //设置格式
        formulaLabel.setPrefSize(480, 50);
        formulaLabel.setFont(Font.font(40));
        formulaLabel.setTextAlignment(TextAlignment.LEFT);

        resultLabel.setPrefSize(480, 50);
        resultLabel.setFont(Font.font(40));
        resultLabel.setTextAlignment(TextAlignment.LEFT);

        VBox pane = new VBox(5, formulaLabel,resultLabel, pane1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("计算器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class action implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String a = event.toString();
            String e = a.substring(a.length() - 3, a.length() - 2);

            switch (e) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/", "^", "%", "(", ")" -> {
                    formulaBuilder.append(e);//将字符进行记录
                    formulaLabel.setText(formulaBuilder.toString());
                    System.out.println(e);
                }
                case "D" -> {
                    formulaBuilder.deleteCharAt(formulaBuilder.length() - 1);
                    formulaLabel.setText(formulaBuilder.toString());
                    System.out.println("D");
                }
                case "C" -> {
                    formulaBuilder = new StringBuilder();
                    resultBuilder = new StringBuilder();
                    formulaLabel.setText(formulaBuilder.toString());
                    resultLabel.setText(resultBuilder.toString());
                }
                case "=" -> {
                    String expression = formulaBuilder.toString();
                    double result = Calculator.conversion(expression);
                    System.out.println(expression + " = " + result);
                    resultLabel.setText("=" + result);
                }
            }
        }
    }
}