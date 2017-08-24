import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application{
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            VBox page = (VBox) FXMLLoader.load(Main.class.getResource("/SearchWindow.fxml"));
            Scene scene = new Scene(page);


            primaryStage.setScene(scene);
            primaryStage.setTitle("Search Window");

            //primaryStage.getIcons().add(new Image(this.getClass().getResource("/logo2.png").toString()));
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
