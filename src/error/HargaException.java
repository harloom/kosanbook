/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author Hx-loom
 */
public class HargaException extends Exception {

    /**
     * Creates a new instance of <code>HargaException</code> without detail
     * message.
     */
    public HargaException() {
    }

    /**
     * Constructs an instance of <code>HargaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public HargaException(String msg) {
        super(msg);
    }
}
