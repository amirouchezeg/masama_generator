/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faker;

import beans.Attribute;

/**
 *
 * @author Amirouche
 */
public class BooleanDataFaker extends DataFaker {

    public BooleanDataFaker(Attribute att) {
        super(att);
    }

    @Override
    protected String generateNewValue() {
        return between(0, 1) + "";
    }

}
