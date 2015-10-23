package TP_AOC.TP_AOC;
import TP_AOC.TP_AOC.v1.Controller.Controller;
import TP_AOC.TP_AOC.v1.Controller.IController;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	IController Controller = new Controller();
    	
    	/**
        System.out.println( "Hello World!" );
        Application.launch(Test.class, args);
        
        **/
    }
    /**
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);        
        primaryStage.setScene(scene);
        primaryStage.setVisible(true);
    }**/
}
