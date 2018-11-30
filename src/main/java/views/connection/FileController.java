/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.connection;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import static views.main.LuncherApp.primaryStage;

/**
 *
 * @author acer
 */
public class FileController implements Initializable {

    @FXML
    private HBox file;
    @FXML
    private JFXTextField path;
    private String fileString;
    private static Path filePath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onChose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File fileUrl = fileChooser.showOpenDialog(primaryStage);
        this.fileString = fileUrl.getAbsolutePath();
        filePath = fileUrl.toPath();

    }

    public String getFileString() {
        return fileString;
    }

    public Path getFilePath() {
        return filePath;
    }

}