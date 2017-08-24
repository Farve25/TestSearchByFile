import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchWindowController implements Initializable {

    @FXML
    private Label directory;

    @FXML
    private TextField text;

    @FXML
    private TextField fileExtension;

    @FXML
    private Button btnSearch;

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
        sp.start();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        btnSearch.setOnAction(e -> {

            if (directory.getText().isEmpty()) return;
            if ("".equals(text.getText())) return;
            if ("".equals(fileExtension.getText())) return;

            SearchProcess sp = new SearchProcess(new File(directory.getText()), fileExtension.getText(), text.getText());
            sp.start();

            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ResultWindow.fxml"));
                root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Result");

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initOwner(btnSearch.getScene().getWindow());

                stage.showAndWait();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
    }

}
