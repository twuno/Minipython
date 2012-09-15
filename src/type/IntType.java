/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

/**
 *
 * @author uno
 */
public class IntType extends Tipo{

    @Override
    public boolean Equivalente(Tipo t) {
       return t instanceof IntType;
    }
    
}
