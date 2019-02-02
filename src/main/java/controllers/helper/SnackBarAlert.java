/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.helper;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maroine
 */
public class SnackBarAlert {

    private static SnackBarAlert signlotonSnackBarAlert = null;
    BorderPane p;
    VBox box;
    JFXButton closeButton;
    JFXSnackbar bar;
    private String title = "";

    public static SnackBarAlert getInstance() {
        if (signlotonSnackBarAlert == null) {
            signlotonSnackBarAlert = new SnackBarAlert();
        }
        return signlotonSnackBarAlert;
    }

    public SnackBarAlert() {
        p = new BorderPane();
        box = new VBox();
        box.setAlignment(Pos.BASELINE_RIGHT);
        closeButton = new JFXButton("Fermer");
        // closeButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TIMES));
        box.getChildren().add(closeButton);
        p.setTop(box);
        p.setStyle("-fx-background-color: derive(-fx-primary, 20%)");
        closeButton.setOnAction(e -> {
            bar.close();
            title = "";
        });

    }

    public void newSnackBarAlert(Parent center, String title) throws IOException {
        if (title.equals(this.title)) {
            return;
        }
        this.title = title;
        if (bar != null) {
            bar.close();
        }
        bar = new JFXSnackbar((Pane) HelperControllers.root);
        p.setBottom(center);
        bar.getChildren().add(p);
        bar.show(title, title, (event) -> {
        });
    }
}
