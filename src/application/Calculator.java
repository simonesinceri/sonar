package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;




public class Calculator extends Application {
	
	
	
	private TextField display;
	
	private double  operandoCorrente  = 0.0;
	private char    operatoreCorrente = '?';
	private boolean resetDisplay = true;
	
	
	
	
	public void inseritoOperatore( char c ) {
        if (c == '=') {
            if (operatoreCorrente != '?') {
                double operando = Double.parseDouble(display.getText());
                double risultato = calcolaRisultato(operandoCorrente, operando, operatoreCorrente);
                display.setText(String.valueOf(risultato));
                operatoreCorrente = '?';
                resetDisplay = true;
            }
        } else {
            // Gestire l'operatore
            if (operatoreCorrente == '?') {
                operandoCorrente = Double.parseDouble(display.getText());
            } else {
                double operando = Double.parseDouble(display.getText());
                operandoCorrente = calcolaRisultato(operandoCorrente, operando, operatoreCorrente);
                display.setText(String.valueOf(operandoCorrente));

            }
            operatoreCorrente = c;
            resetDisplay = true;
        }
    }
	
	
	
	
	public void inseritaCifra( char c ) {
        if (resetDisplay) {
            display.setText("");
            resetDisplay = false;
        }
        display.setText(display.getText() + c);
    }

	public void inseritoPunto() {
        if (resetDisplay) {
            display.setText("");
            resetDisplay = false;
        }
        display.setText(display.getText() + ".");
    }
	
	private double calcolaRisultato(double op1, double op2, char oper) {
        switch (oper) {
        case '+' : return (op1 + op2);
        case '-' : return (op1 - op2);
        case '*' : return (op1 * op2);
        case '/' : return (op1 / op2);
        default : return 0.0;
        }
    }
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			display = new TextField();
			display.setMinHeight(100);
			display.setStyle("-fx-font: 24 arial;");
			display.setAlignment(Pos.CENTER_RIGHT);
			display.setEditable(false);
			
			GridPane tastiera = new GridPane();
			
			
			
			
			Button btn9 = new Button("9");
			btn9.setMinSize(100, 75);
			tastiera.add(btn9, 2, 0);
			btn9.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('9');
					
					
				}
		});
			
		
			Button btn8 = new Button("8");
			btn8.setMinSize(100, 75);
			tastiera.add(btn8, 1, 0);
			btn8.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('8');
					
					
				}
		});
			
			
			Button btn7 = new Button("7");
			btn7.setMinSize(100, 75);
			tastiera.add(btn7, 0, 0);
			btn7.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('7');
					
				}
		});
			
			
			Button btn6 = new Button("6");
			btn6.setMinSize(100, 75);
			tastiera.add(btn6, 2, 1);
			btn6.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('6');
					
					
				}
		});
			
			
			Button btn5 = new Button("5");
			btn5.setMinSize(100, 75);
			tastiera.add(btn5, 1, 1);
			btn5.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('5');
					
					
				}
		});
			
			
			Button btn4 = new Button("4");
			btn4.setMinSize(100, 75);
			tastiera.add(btn4, 0, 1);
			btn4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('4');
					
				}
		});
			
			
			Button btn3 = new Button("3");
			btn3.setMinSize(100, 75);
			tastiera.add(btn3, 2, 2);
			btn3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('3');
					
				}
		});
			
			
			Button btn2 = new Button("2");
			btn2.setMinSize(100, 75);
			tastiera.add(btn2, 1, 2);
			btn2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('2');
				}
		});
			
			
			Button btn1 = new Button("1");
			btn1.setMinSize(100, 75);
			tastiera.add(btn1, 0, 2);
			btn1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('1');
				}
		});
			
			
			Button btn0 = new Button("0");
			btn0.setMinSize(100, 75);
			tastiera.add(btn0, 1, 3);
			btn0.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					inseritaCifra('0');
				}
		});
			
			
			Button btnUg = new Button("=");
			btnUg.setMinSize(100, 75);
			tastiera.add(btnUg, 2, 3);
			btnUg.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
					
					inseritoOperatore('=');
					
					
				}
		});
			
			
			Button btnPt = new Button(".");
			btnPt.setMinSize(100, 75);
			tastiera.add(btnPt, 0, 3);
			btnPt.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
	        		inseritoPunto();
					
					
				}
		});
			
			
			
			Button btnAdd = new Button("+");
			btnAdd.setMinSize(100, 75);
			tastiera.add(btnAdd, 3, 3);
			btnAdd.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
	        		inseritoOperatore('+');
					
					
				}
		});
			
			
			Button btnSottr = new Button("-");
			btnSottr.setMinSize(100, 75);
			tastiera.add(btnSottr, 3, 2);
			btnSottr.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
	        		inseritoOperatore('-');
					
					
				}
		});
			
			Button btnMolt = new Button("*");
			btnMolt.setMinSize(100, 75);
			tastiera.add(btnMolt, 3, 1);
			btnMolt.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
	        		inseritoOperatore('*');
					
					
				}
		});

			Button btnDiv = new Button("/");
			btnDiv.setMinSize(100, 75);
			tastiera.add(btnDiv, 3, 0);
			btnDiv.setOnAction(new EventHandler<ActionEvent>() {

	        	@Override
				public void handle(ActionEvent event) {
	        		inseritoOperatore('/');
					
					
				}
		});
			
			
			root.setTop(display);
			root.setBottom(tastiera);
			Scene scene = new Scene(root,400,400);
			
			
			
			
		
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
