package ua.com.arch.xml_roots;

import javax.xml.bind.annotation.*;
import java.util.Objects;

/**
 * Created by Katya on 28.02.2017.
 */
@XmlRootElement(name = "exchangerate")
@XmlType(propOrder = {"ccy", "base_ccy", "buy", "sale"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Exchangerate {

    @Override
    public String toString() {
        return "Exchangerate{" + "ccy=" + ccy + ", base_ccy=" + base_ccy + ", buy=" + buy + ", sale=" + sale + '}';
    }

    @XmlAttribute
    private String ccy;
    @XmlAttribute(name = "base_ccy")
    private String base_ccy;
    @XmlAttribute
    private double buy;
    @XmlAttribute
    private double sale;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.ccy);
        hash = 41 * hash + Objects.hashCode(this.base_ccy);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.buy) ^ (Double.doubleToLongBits(this.buy) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.sale) ^ (Double.doubleToLongBits(this.sale) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exchangerate other = (Exchangerate) obj;
        if (!Objects.equals(this.ccy, other.ccy)) {
            return false;
        }
        if (!Objects.equals(this.base_ccy, other.base_ccy)) {
            return false;
        }
        return true;
    }

    public Exchangerate() {
    }

    public Exchangerate(String ccy, String base_ccy) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
    }

    public String getCcy() {
        return ccy;
    }


    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

}