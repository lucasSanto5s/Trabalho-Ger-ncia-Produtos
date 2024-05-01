package br.com.company.main;


import br.com.company.janelas.FrameInicial;
import java.io.IOException;
/**
 * Main Class, Inicia o JFrame principal
 * @author Kauan
 */
public class Main {

    public static void main(String[] args) throws IOException {
        FrameInicial janelaP = new FrameInicial();
        janelaP.setLocationRelativeTo(null);
        janelaP.setVisible(true);  
  }
   
}
