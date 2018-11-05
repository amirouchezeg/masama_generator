/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.bean;

import java.util.ArrayList;
import db.utils.DataFakerWraper;

/**
 * A object represent a column of SQL table
 *
 * @author Maroine
 */
public class Attribute implements Comparable<Attribute> {

    private String name;
    private String dataType;
    private boolean isPrimary;
    private boolean isRoot;
    private boolean isUnique;
    private boolean isNull;
    private ArrayList<String> instances;
    private DataFakerWraper dataFakerWraper;

    /**
     *
     * @param attributeName
     * @param dataType
     */
    public Attribute(String attributeName, String dataType, String nullable) {
        this.name = attributeName;
        this.dataType = dataType;
        this.isNull = false;
        this.isPrimary = false;
        this.isRoot = true;
        this.isUnique = false;
        dataFakerWraper = new DataFakerWraper(dataType, "3", "10", 20, false, null, "");
        instances = new ArrayList<>();
    }

    /**
     *
     * @return get the name of the attribute
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return get SQL data type string
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Set the name of the attribute
     *
     * @param attributeName
     */
    public void setName(String attributeName) {
        this.name = attributeName;
    }

    /**
     * Set the data type of the attribute
     *
     * @param dataType
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public int compareTo(Attribute o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        return name.equals(((Attribute) o).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return name + " " + dataType;
    }

    public void startToGenerateRootValues() {
        if (this.isRoot) {
            this.instances = dataFakerWraper.values();
        }
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void isPrimary(boolean bool) {
        isPrimary = bool;
    }

    public void isRoot(boolean bool) {
        this.isRoot = bool;
    }

    public ArrayList<String> getInstances() {
        return this.instances;
    }

    public void setInstances(ArrayList<String> instances) {
        this.instances = instances;
    }
}
