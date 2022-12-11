package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

/**
 * The FileParser interface defines a set of methods for writing and reading objects.
 *
 * @author AndikhaWisanggeni
 * @see Serializable
 */

public interface FileParser
{
    /**
     * This method writes an object to a file.
     *
     * @return the written object
     */
    public Object write();
    /**
     * This method reads an object from a file.
     *
     * @param string the path to the file to read
     * @return true if the read was successful, false otherwise
     */
    public boolean read(String string);
}
