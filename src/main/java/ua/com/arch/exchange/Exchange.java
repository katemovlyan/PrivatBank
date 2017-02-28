package ua.com.arch.exchange;

/**
 * Created by Katya on 28.02.2017.
 */

import ua.com.arch.xml_roots.Exchangerate;
import ua.com.arch.xml_roots.Exchangerates;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exchange {

    public static Exchangerates readXMLString() throws Exception {

        Exchangerates exchangerates;
        String xmlPath = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        URL url = new URL(xmlPath);
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String xml = reader.readLine();
        connect.disconnect();

        StringReader stringReader = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(Exchangerates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        exchangerates = (Exchangerates) jaxbUnmarshaller.unmarshal(stringReader);
        return exchangerates;
    }

    public static double countRate(String from, String to, Exchangerates exchangerates, boolean toBuy) {

        double currRate = 1;
        int counter = 0;
        if (from.equals(to)) {
            return currRate;
        }
        Exchangerate exch;
        for (int j = 0; j < exchangerates.getRows().length; j++) {

            exch = exchangerates.getRows()[j].getExchangerate();
            if (from.equals(exch.getCcy()) || from.equals(exch.getBase_ccy())) {
                counter++;
            }
            if (counter > 2) {
                return 1 / countRate(to, from, exchangerates, toBuy);
            }
        }
        for (int i = 0; i < exchangerates.getRows().length; i++) {

            exch = exchangerates.getRows()[i].getExchangerate();
            double rateValue;
            if (toBuy) {
                rateValue = exch.getBuy();
            } else {
                rateValue = exch.getSale();
            }
            if (from.equals(to)) {
                return currRate;
            }
            if (from.equals(exch.getCcy()) && to.equals(exch.getBase_ccy())) {
                return currRate * rateValue;
            }
            if (from.equals(exch.getCcy())) {
                return countRate(from, exch.getBase_ccy(), exchangerates, toBuy) * countRate(exch.getBase_ccy(), to, exchangerates, toBuy);
            } else if (from.equals(exch.getBase_ccy())) {
                return countRate(from, exch.getCcy(), exchangerates, toBuy) * countRate(exch.getCcy(), to, exchangerates, toBuy);
            }
        }
        return 0;
    }
}
