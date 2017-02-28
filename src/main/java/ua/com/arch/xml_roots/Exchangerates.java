package ua.com.arch.xml_roots;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Katya on 28.02.2017.
 */

@XmlRootElement(name = "exchangerates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Exchangerates {

    @Override
    public String toString() {
        return "Exchangerates{" + "rows=" + rows.toString() + '}';
    }

    @XmlElement(name = "row")
    private Row[] rows;

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

}
