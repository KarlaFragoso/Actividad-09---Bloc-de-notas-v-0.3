
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import Views.ViewBloc;



public class ModelBloc {
    
        ViewBloc viewbloc;
    
       private String path;
       private String mensaje = "";
       boolean bandera = false;
       String cifrado = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getCaesar(){
        return cifrado;
    }
    
    public void setCaesar(String caesar){
        this.cifrado = cifrado;
    }
    
    public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showOpenDialog(viewbloc);
        File archivo = jfc.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewbloc, "Nombre del archvio incorrecto");
        }
        else
            path = archivo.getAbsolutePath();
    }
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        mensaje = mensaje + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
    
     public void writeFile(){
             try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.print(mensaje);
                        printWriter.close();
                        
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
                }
            }
     
     public void stringCifrado(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) + 1) > 'z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    cifrado= cifrado + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    cifrado = cifrado + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) + 1) > 'Z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    cifrado = cifrado + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    cifrado = cifrado + ((char)ascii);
                }
            }
            
        }
    }
        
    public void Cifrado2String(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) - 1) < 'a'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    cifrado = cifrado + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    cifrado = cifrado + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) - 1) < 'A'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    cifrado = cifrado + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    cifrado = cifrado + ((char)ascii);
                }
            }
            
        }
    }
    
}
