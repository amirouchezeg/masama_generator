/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.bean;

import db.utils.DataFaker;
import db.utils.DateDataFaker;
import db.utils.IntegerDataFaker;
import db.utils.TextDataFaker;
import java.io.Serializable;
import java.util.List;

/**
 * A object represent a column of SQL table
 *
 * @author Maroine
 */
public class Attribute implements Comparable<Attribute>, Serializable {

    private boolean isRoot;
    private String name;
    private String dataType;
    private boolean isPrimary;
    private boolean isUnique;
    private boolean isNullable;
    private List<String> instances;
    private DataFaker dataFaker;
    private Attribute ref = null;

    /**
     *
     * @param attributeName
     * @param dataType
     * @param nullable
     */
    public Attribute(String attributeName, String dataType, String nullable) {
        this.name = attributeName;
        this.dataType = dataType;
        this.isPrimary = false;
        this.isRoot = true;
        this.isUnique = false;
        this.isNullable = !nullable.equals("0");

        switch (dataType) {
            case "TEXT":
                dataFaker = new TextDataFaker(this);
                break;
            case "DATE":
                dataFaker = new DateDataFaker(this);
                break;
            case "INT":
            case "INTEGER":
            case "DOUBLE":
            case "FLOAT":
                dataFaker = new IntegerDataFaker(this);
                break;
        }

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

<<<<<<< HEAD
    public void startToGenerateRootValues(int howMuch) {
=======
    @Override
    public String toString() {
        return name + " " + dataType;
    }

    public void startToGenerateRootValues(int howMuch, int nullsRate) {

>>>>>>> d80bbb19f093d86244872549be149483653513c2
        dataFaker.setHowMuch(howMuch);
        this.instances = dataFaker.values();
    }

    public Attribute getRef() {
        return ref;
    }

    public void setRef(Attribute ref) {
        this.ref = ref;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void isPrimary(boolean bool) {
        isPrimary = bool;
    }

    public List<String> getInstances() {
        return this.instances;
    }

    public DataFaker getDataFaker() {
        return dataFaker;
    }

    public void setInstances(List<String> instances) {
        this.instances = instances;
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

}
