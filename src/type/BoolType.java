/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 *
 * @author uno
 */
public class BoolType extends Tipo{

    @Override
    public boolean Equivalente(Tipo t) {
       return t instanceof BoolType;
    }
    
}
