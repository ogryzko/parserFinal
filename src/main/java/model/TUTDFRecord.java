package model;

import java.io.Serializable;

/**
 * Created by EGlushchenko on 03/08/2017.
 */
public interface TUTDFRecord extends Serializable {
    /**
     * An interface implemented by all classes that represent TUTDF records.
     *
     */

    /** Returns a TUTDF file like representation of this record.
     *
     * @return a String providing a TUTDF file like representation of the record.
     */
    public String toTUTDF();

    /** Appends a TUTDF file like representation of this record to the provided StringBuffer.
     *
     * @param stringBuffer
     */
    public void toTUTDF(StringBuffer stringBuffer);
}
