/*
La funcion para sacar datos de un VIN ya la había realizado en javascript, la traduccion a java ya la hizo GPT

  *******************   Aqui esta en javascript:  **********************

  function obtenerAtributo(vin,atributo){
  var url = 'https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVin/' + vin + '?format=json';
  var response = UrlFetchApp.fetch(url);

  var json = JSON.parse(response.getContentText());
  var valorAtributo =
    json.Results.find(function(item){
      return item.Variable === atributo;
    });

  return valorAtributo ? valorAtributo.Value : atributo+" no entrado";
}

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Vehiculo {
    public String obtenerAtributo(String vin, String atributo) {
        String urlString = "https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVin/" + vin + "?format=xml";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String xmlResponse = content.toString();
            return parseXmlForAtributo(xmlResponse, atributo);
        } catch (Exception e) {
            //e.printStackTrace();
            return "Error al obtener el atributo";
        }
    }

    private String parseXmlForAtributo(String xml, String atributo) {
        String searchKey = "<Variable>" + atributo + "</Variable>";
        int index = xml.indexOf(searchKey);

        if (index == -1) {
            return atributo + " no encontrado";
        }

        int valueStartIndex = xml.indexOf("<Value>", index);
        if (valueStartIndex == -1) {
            return atributo + " no encontrado";
        }

        valueStartIndex += 7; // Move past "<Value>"

        int valueEndIndex = xml.indexOf("</Value>", valueStartIndex);
        if (valueEndIndex == -1) {
            return atributo + " no encontrado";
        }

        return xml.substring(valueStartIndex, valueEndIndex);
    }
}
