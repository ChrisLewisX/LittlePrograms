import java.awt.Font;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ReverseString extends Application {
	FlowPane root;
	Scene scene;
	Pane pane;
	Stack<Object> s = new Stack<Object>();
	//Viewable Items
	Label l1;
	Label l2;
	//Items to interact with
	Button bRun;		//Will run program
	TextField tInput;	//What the user enters
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		root=new FlowPane();
  		scene = new Scene(root, 400, 200);
  		stage.setScene(scene);
  		stage.show();
  		pane = new Pane();
  		pane.setPrefSize(700, 500);
  		root.getChildren().add(pane);
  		
  		//Labels
  		l1 = new Label();
  		l1.setText("Enter A World Below");
  		l1.setLayoutX(100);
  		l1.setLayoutY(20);
  		
  		l2 = new Label();
  		l2.setText("");
  		l2.setLayoutX(100);
  		l2.setLayoutY(150);

  		//TextField
  		tInput = new TextField();
  		tInput.setText("");
  		tInput.setLayoutX(100);
  		tInput.setLayoutY(50);
  		
  		//Button
  		bRun = new Button();
  		bRun.setText("Click to run");
  		bRun.resize(100, 100);
  		bRun.setLayoutX(100);
  		bRun.setLayoutY(100);
  		pane.getChildren().addAll(bRun, tInput, l1, l2);
  		bRun.setOnAction(bHandler);
	}
	
	EventHandler bHandler = new EventHandler() {

		@Override
		public void handle(Event event) {
			//Clear stack and reset label for re-usability 
			s.clear();
			l2.setText("");
			//Store each character as a char in a Stack
			String k = tInput.getText();
			for(int i=0; i<k.length(); i++)
				s.push(k.charAt(i));
			//Pop all items in stack
			while(!s.isEmpty())
				l2.setText(l2.getText() + s.pop());				
		}
	};


}
