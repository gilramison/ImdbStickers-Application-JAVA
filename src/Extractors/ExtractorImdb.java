package Extractors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Helpers.Content;
import Helpers.ContentAssistidos;
import Helpers.JsonParser;

public class ExtractorImdb implements ExtractorContent {
    
    public List<Content> extraiConteudos(String jsonTemp){
        

        //extrair os dados: (titulo, imagem, nota de rating)
    var parser = new JsonParser();
    List<Map<String,String>> ListaDeAtributos = parser.parse(jsonTemp);

    List<Content> conteudosfinais = new ArrayList<>(); //lista vazia


    for (Map<String,String> atributos : ListaDeAtributos) {

        String urlImagem = atributos.get("image");//.replaceAll("(@+)(.*).jpg$", "$1.jpg"); //refatora a url para pegar a imagem poster
        String titulo = atributos.get("title");
        String notaOficialTemp = atributos.get("imDbRating");
        Double notaOficial = Double.valueOf(notaOficialTemp);
        var content = new Content(titulo, urlImagem,notaOficial,null);

        conteudosfinais.add(content);
       
    }


    return conteudosfinais;
    }

    @Override
    public List<ContentAssistidos> extraiConteudosAssistidos(String jsonTemp) {        
        return null;
    }

}
