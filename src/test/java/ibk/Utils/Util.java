package ibk.Utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private static HashMap<String, Object> headerMap = new HashMap<>();
    private static HashMap<String, Object> headerMap1 = new HashMap<>();
    private static HashMap<String, Object> headerMap3 = new HashMap<>();
    private static HashMap<String, Object> headerMap4 = new HashMap<>();
    public static String USER="joel.armando.leiva.collazos@everis.com";
    public static String PSSW="JoelLeiva30*";

    public static String getTemplate(String templatePath) {
        try {
            return IOUtils.toString(new ClassPathResource(templatePath).getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> getCommonHeadersIngesta() {
        headerMap.put("Ocp-Apim-Subscription-Key","b18be3bcfa8e41f2ac4ef6d9406ef157");
        headerMap.put("X-Async-process","true");
        headerMap.put("X-Correlation-Id","899a145caf6b4c73d6b1cbe57e45a4f5");
        headerMap.put("X-Application-Id","GIRU");
        headerMap.put("Content-Type","application/json");
        return headerMap;
    }

    public static Map<String, Object> getHeadersWithIngestaPDF() {
        getCommonHeadersIngesta();
        headerMap.put("X-Finger-Key", "c2b126130d55bd442bf83b0eb04d789c854f5171e12d1689fc75befcc773f49b");
        return headerMap;
    }

    public static Map<String, Object> getHeadersWithIngestaEXCEL() {
        getCommonHeadersIngesta();
        headerMap.put("X-Finger-Key", "a05212a4810cc440674642263e3cc7cc07efcc39a2a0e116bccc7aaf8f07b279");
        return headerMap;
    }

    public static Map<String, Object> getHeadersWithIngestaWORD() {
        getCommonHeadersIngesta();
        headerMap.put("X-Finger-Key", "e1cde0acaab496d7eac5c8893ff0929d524105e5b958610866ef8910bca6ac74");
        return headerMap;
    }

    public static Map<String, Object> getHeadersWithIngestaFirmaIncorrecta() {
        getCommonHeadersIngesta();
        headerMap.put("X-Finger-Key", "e1cde0acaab496d7eac5c8893ff0929d524105e5b958610866ef891000000000");
        return headerMap;
    }

    public static Map<String, Object> getHeadersWithIngesta5MB() {
        getCommonHeadersIngesta();
        headerMap.put("X-Finger-Key", "a0789702cd7b14903d8263865cb35a475b6b624f7deee32a43c0b42095eb9545");
        return headerMap;
    }

    public static Map<String, Object> getCommonHeadersConsultaFiltro() {
        headerMap1.put("Ocp-Apim-Subscription-Key","b18be3bcfa8e41f2ac4ef6d9406ef157");
        headerMap1.put("X-Correlation-Id","21313213213213");
        headerMap1.put("X-Application-Id","GIRU");
        headerMap1.put("Content-Type","application/json");
        return headerMap1;
    }

    public static Map<String, Object> getMap2Fields(String campo1,String valor1,String campo2, String valor2) {
        HashMap<String, Object> headerMap2 = new HashMap<>();
        headerMap2.put(campo1,valor1);
        headerMap2.put(campo2,valor2);
        return headerMap2;
    }

    public static Map<String, Object> getMap3Fields(String campo1,String valor1,String campo2,String valor2,String campo3,String valor3) {
        headerMap3.put(campo1,valor1);
        headerMap3.put(campo2,valor2);
        headerMap3.put(campo3,valor3);
        return headerMap3;
    }

    public static Map<String, Object> getCommonHeadersConsultaPuntual() {
        headerMap4.put("Ocp-Apim-Subscription-Key","b18be3bcfa8e41f2ac4ef6d9406ef157");
        headerMap4.put("X-Correlation-Id","1233");
        headerMap4.put("X-Application-Id","GIRU");
        headerMap4.put("Content-Type","application/json");
        return headerMap4;
    }

}
