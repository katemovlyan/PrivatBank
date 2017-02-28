package ua.com.arch.xml_roots;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Katya on 28.02.2017.
 */

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Row {

    @XmlElement(name = "exchangerate")
    private Exchangerate exchangerate;

    @Override
    public String toString() {
        return "Row{" + "exchangerate=" + exchangerate.toString() + '}';
    }

    public Exchangerate getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Exchangerate exchangerate) {
        this.exchangerate = exchangerate;
    }
}
