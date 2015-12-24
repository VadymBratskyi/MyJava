/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package active;

import java.util.Comparator;

/**
 *
 * @author Vadym
 */
public class MyComporator implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
     
        Double i1 = Double.valueOf(t.toString()).doubleValue();
        Double i2 = Double.valueOf(t1.toString()).doubleValue();
                
        if(i1<i2) return 1;
        else if(i1>i2)return -1;
        
        return 0;
    }
    
}
