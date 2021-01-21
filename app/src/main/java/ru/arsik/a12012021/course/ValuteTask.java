package ru.arsik.a12012021.course;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ValuteTask extends AsyncTask<Void, Void, List<Valute>> {

    private RunnableValute<List<Valute>> runnable;
    @Override
    protected List<Valute> doInBackground(Void... voids) {
        List<Valute> valutes = new ArrayList<>();
        HttpsURLConnection connection = null;
        try {
            URL url = new URL("https://cbr.ru/scripts/XML_daily.asp");
            connection = (HttpsURLConnection) url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = connection.getInputStream();
            InputSource is = new InputSource(inputStream);
            Document document = builder.parse(is);
            Node root = document.getChildNodes().item(0);
            for (int i = 0; i < root.getChildNodes().getLength(); i++){
                Node node = root.getChildNodes().item(i);
                valutes.add(new Valute(
                        node.getChildNodes().item(0).getTextContent(),
                        node.getChildNodes().item(1).getTextContent(),
                        Integer.parseInt(node.getChildNodes().item(2).getTextContent()),
                        node.getChildNodes().item(3).getTextContent(),
                        Float.parseFloat(node.getChildNodes().item(4).getTextContent().replace(",", "."))
                ));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return valutes;
    }

    public interface RunnableValute<T>{
        void run(T valutes);
    }

    @Override
    protected void onPostExecute(List<Valute> valutes){

        this.runnable.run(valutes);
    }

    public ValuteTask(RunnableValute<List<Valute>> runnable){
        this.runnable = runnable;
    }
}
