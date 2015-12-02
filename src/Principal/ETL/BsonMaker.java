/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.ETL;

import Modelo.Imagen;
import Modelo.Metadata;
import com.mongodb.util.JSON;
import java.io.*;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

import org.bson.Document;
import org.bson.codecs.Codec;

/**
 *
 * @author aitorpagan
 */
public class BsonMaker {

    /**
     * @param args the command line arguments
     */
    public static Document getBSONobject(Imagen img) {
        // TODO code application logic here
        FileWriter fw = null;
        JsonObject json = null;
         Document doc = new Document();
         ArrayList<Document> Adoc = new ArrayList<>();
        for(Metadata m : img.getMetadatos()){
            doc.append("directory", m.getDirectorio()).append("tag",m.getEtiqueta()).append("value", m.getValor());
            Adoc.add(doc);
        }
        Document model = new Document()
                .append("_id", img.getId())
                .append("name", img.getNombre())
                .append("size", img.getTamanno())
                .append("ext", img.getExtension())
                .append("path", img.getRuta())
                .append("meta",Adoc);
       
        //model.append("meta",asList(doc));
        
        
        try {
            fw = new FileWriter("pruebajson.json");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(model.toJson());
        } catch (IOException ex) {
            Logger.getLogger(BsonMaker.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(BsonMaker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
     
        
        
        return model;
        
    }
    
}

