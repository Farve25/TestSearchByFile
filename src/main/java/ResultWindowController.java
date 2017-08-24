import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class ResultWindowController {

    @FXML
    private ListView<String> resultView;

    @FXML
    private TextArea textArea;

    @FXML
    private TabPane textTabPane;

    @FXML
    public void chooseResult(MouseEvent arg0) {
        //System.out.println("clicked on " + resultView.getSelectionModel().getSelectedItem());
    }

    public void addResult(String file){
        resultView.getItems().add(file);
    }

    public void createTab(String fileName, String text){
        VBox vb = new VBox();
        TextArea area = new TextArea(text);
        vb.getChildren().add(area);

        Tab tab = new Tab();
        tab.setText(fileName);
        tab.setContent(vb);

        textTabPane.getTabs().add(tab);

    }}
