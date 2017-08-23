import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class SearchWindowController {

    @FXML
    private Label directory;

    @FXML
    private TextField text;

    @FXML
    private TextField fileExtension;

    @FXML
    private void chooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Directory");
        File file = directoryChooser.showDialog(new Stage());
        if (file != null) {
            directory.setText(file.toString());
        }
    }

    @FXML
    private void startSearch(){
        if (directory.getText().isEmpty()) return;
        if ("".equals(text.getText())) return;
        if ("".equals(fileExtension.getText())) return;

        SearchProcess sp = new SearchProcess(new File(directory.getText()), fileExtension.getText(), text.getText());
        sp.run();


    }

    /*@Override
    public void initialize(URL location, ResourceBundle resources){
        btnOpenSecondWindow.setOnAction(e -> {
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
                root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Second window");

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initOwner(btnOpenSecondWindow.getScene().getWindow());

                stage.showAndWait();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
    }*/

}
