/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.report;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import connection.SQLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.cell.TextFieldListCell;

/**
 * A class reprensent a bloc of SQL queries that can be executed in same time
 * this class extends RecursiveTreeObject to have to ability to show it in a
 * table view
 *
 * @author Maroine
 */
public class QueriesBloc extends RecursiveTreeObject<QueriesBloc> {

    private JFXSlider rate;
    private long time = 0;
    private JFXListView<String> list;
    private final JFXCheckBox updateCheckBox;
    private ArrayList<Long> allTimes = new ArrayList<>();

    public ArrayList<Long> getAllTime() {
        return allTimes;
    }

    public QueriesBloc(JFXListView<String> list, JFXSlider rate) {
        this.list = new JFXListView<>();
        this.list.setEditable(true);
        this.list.setCellFactory(TextFieldListCell.forListView());
        this.list.getItems().addAll(list.getItems());
        this.rate = new JFXSlider();
        this.rate.setMin(0);
        this.rate.setMax(100);
        this.rate.setValue(rate.getValue());
        this.updateCheckBox = new JFXCheckBox();

    }

    /**
     * Execute all the bloc and calcute its time duration
     *
     * @throws SQLException
     */
    public void execute() throws SQLException {
        long t1 = System.currentTimeMillis();
        for (String query : list.getItems()) {
            SQLConnection.getInstance().execute(query);
        }
        long t2 = System.currentTimeMillis();
        time += t2 - t1;
        //allTimes.add(t2 - t1);
        allTimes.add(time);

    }

    /**
     *
     * @return the queries as a list view
     */
    public JFXListView getQueriesListColumn() {
        return list;
    }

    /**
     *
     * @return jfx silder object that represent the current rate
     */
    public JFXSlider getRateColumn() {
        return rate;
    }

    /**
     *
     * @return the total time of its execution
     */
    public double getTimeColumn() {
        return time;
    }

    /**
     *
     * @return the rate
     */
    public double getRate() {
        return rate.getValue();
    }

    /**
     *
     * @return the total time
     */
    public long getTime() {
        return time;
    }

    /**
     * reset this bloc
     */
    public void reset() {
        list.getItems().clear();
    }

    /**
     *
     * @param i
     */
    public void setTime(int i) {
        time = i;
    }

    /**
     *
     * @return
     */
    public JFXCheckBox getUpdate() {
        return updateCheckBox;
    }
}
