

package de.uniluebeck.gruppe4.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;

public class FXMLBspController implements Initializable {

    @FXML
    private GridPane grid;
	
    @FXML
    private Label label1;

    @FXML
    private Label label2;
    
    @FXML
    private Label label3;
    
    @FXML
    private Label label4;
    
    @FXML
    private Label label5;
    
    private FXMLBspModel model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new FXMLBspModel();
        
        label1.setText(model.getHello());
        label2.setText("Label 2");
        label3.setText("Label 3");
        label4.setText("Spiegelbild");
        label5.setText("Label 5");
        
        setzeSpaltenBreiteFuerMittlereSpalte();
    }
    
    /**
     * Berechnet und setzt die Breite fuer die mittlere Spalte.
     * Die rechte und die linke Spalte haben jeweils eine fixe breite.
     * Die mittlere Spalte soll den restlichen Platz auffuellen.
     */
    private void setzeSpaltenBreiteFuerMittlereSpalte(){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        
        ObservableList<ColumnConstraints> constraints = grid.getColumnConstraints();
        ColumnConstraints column1 = constraints.get(0);
        ColumnConstraints column2 = constraints.get(1);
        ColumnConstraints column3 = constraints.get(2);
        
        double width2 = screenWidth - column1.getPrefWidth() - column3.getPrefWidth();
        column2.setPrefWidth(width2);
    }

}

