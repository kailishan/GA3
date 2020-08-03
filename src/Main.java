import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MULT = 2;
    static final int DIV = 3;

    private boolean calculate = false;
    private double val1 = 0;
    private double val2 = 0;
    private int operator = -1;
    private Label solution = new Label("");
    private String numString = "";


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();

        GridPane grid = createGrid();
        createButtons(grid);

        VBox calc = new VBox();
        calc.setAlignment(Pos.CENTER);
        calc.getChildren().add(solution);
        calc.getChildren().add(grid);

        Button btnEql = new Button("=");
        btnEql.setMinWidth(100);
        HBox hbBtnEql = new HBox(10);
        hbBtnEql.getChildren().add(btnEql);
        btnEql.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (calculate) {
                    val2 = Double.parseDouble(numString);
                    doCalculation();
                    numString = Double.toString(val1);
                    solution.setText(numString);
                }
                calculate = false;
            }
        });
        calc.getChildren().add(btnEql);

        Scene scene = new Scene(calc, 175, 275);
        primaryStage.setScene(scene);
    }

    public void createButtons(GridPane grid) {
        Button btn1 = new Button("1");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 0, 3);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "1";
                solution.setText(numString);
            }
        });

        Button btn2 = new Button("2");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 1, 3);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "2";
                solution.setText(numString);
            }
        });

        Button btn3 = new Button("3");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 2, 3);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "3";
                solution.setText(numString);
            }
        });

        Button btn4 = new Button("4");
        HBox hbBtn4 = new HBox(10);
        hbBtn4.getChildren().add(btn4);
        grid.add(hbBtn4, 0, 2);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "4";
                solution.setText(numString);
            }
        });

        Button btn5 = new Button("5");
        HBox hbBtn5 = new HBox(10);
        hbBtn5.getChildren().add(btn5);
        grid.add(hbBtn5, 1, 2);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "5";
                solution.setText(numString);
            }
        });

        Button btn6 = new Button("6");
        HBox hbBtn6 = new HBox(10);
        hbBtn6.getChildren().add(btn6);
        grid.add(hbBtn6, 2, 2);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "6";
                solution.setText(numString);
            }
        });

        Button btn7 = new Button("7");
        HBox hbBtn7 = new HBox(10);
        hbBtn7.getChildren().add(btn7);
        grid.add(hbBtn7, 0, 1);
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "7";
                solution.setText(numString);
            }
        });

        Button btn8 = new Button("8");
        HBox hbBtn8 = new HBox(10);
        hbBtn8.getChildren().add(btn8);
        grid.add(hbBtn8, 1, 1);
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "8";
                solution.setText(numString);
            }
        });

        Button btn9 = new Button("9");
        HBox hbBtn9 = new HBox(10);
        hbBtn9.getChildren().add(btn9);
        grid.add(hbBtn9, 2, 1);
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "9";
                solution.setText(numString);
            }
        });

        Button btn0 = new Button("0");
        HBox hbBtn0 = new HBox(10);
        hbBtn0.getChildren().add(btn0);
        grid.add(hbBtn0, 0, 4);
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += "0";
                solution.setText(numString);
            }
        });

        Button btnDot = new Button(".");
        HBox hbBtnDot = new HBox(10);
        hbBtnDot.getChildren().add(btnDot);
        grid.add(hbBtnDot, 1, 4);
        btnDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString += ".";
                solution.setText(numString);
            }
        });

        Button btnDiv = new Button("/");
        HBox hbBtnDiv = new HBox(10);
        hbBtnDiv.getChildren().add(btnDiv);
        grid.add(hbBtnDiv, 3, 1);
        btnDiv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (calculate) {
                    val2 = Double.parseDouble(numString);
                    numString = "";
                    doCalculation();
                    solution.setText(Double.toString(val1));
                }
                else {
                    val1 = Double.parseDouble(numString);
                    numString = "";
                    operator = DIV;
                    calculate = true;
                }
            }
        });

        Button btnMul = new Button("x");
        HBox hbBtnMul = new HBox(10);
        hbBtnMul.getChildren().add(btnMul);
        grid.add(hbBtnMul, 3, 2);
        btnMul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (calculate) {
                    val2 = Double.parseDouble(numString);
                    numString = "";
                    doCalculation();
                    solution.setText(Double.toString(val1));
                }
                else {
                    val1 = Double.parseDouble(numString);
                    numString = "";
                    operator = MULT;
                    calculate = true;
                }
            }
        });

        Button btnMin = new Button("-");
        HBox hbBtnMin = new HBox(10);
        hbBtnMin.getChildren().add(btnMin);
        grid.add(hbBtnMin, 3, 3);
        btnMin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (calculate) {
                    val2 = Double.parseDouble(numString);
                    numString = "";
                    doCalculation();
                    solution.setText(Double.toString(val1));
                }
                else {
                    val1 = Double.parseDouble(numString);
                    numString = "";
                    operator = MINUS;
                    calculate = true;
                }
            }
        });

        Button btnAdd = new Button("+");
        HBox hbBtnAdd = new HBox(10);
        hbBtnAdd.getChildren().add(btnAdd);
        grid.add(hbBtnAdd, 3, 4);
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (calculate) {
                    val2 = Double.parseDouble(numString);
                    numString = "";
                    doCalculation();
                    solution.setText(Double.toString(val1));
                }
                else {
                    val1 = Double.parseDouble(numString);
                    numString = "";
                    operator = PLUS;
                    calculate = true;
                }
            }
        });

        Button btnClr = new Button("c");
        HBox hbBtnClr = new HBox(10);
        hbBtnClr.getChildren().add(btnClr);
        grid.add(hbBtnClr, 2, 4);
        btnClr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numString = "";
                solution.setText(numString);
            }
        });
    }

    public void doCalculation() {
        switch (operator) {
            case PLUS:
                val1 = val1 + val2;
                break;
            case MINUS:
                val1 = val1 -  val2;
                break;
            case MULT:
                val1 = val1 * val2;
                break;
            case DIV:
                val1 = val1 / val2;
                break;
            default:
                return;
        }
    }

    public GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
