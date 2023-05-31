package com.example.kodebrikke;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

class KodeGeneretor{

    private int [] kodeArray;
    private Random r =new Random();
    private int NyKodeIndex=0;

    public KodeGeneretor(int antall){
        kodeArray = new int[antall];
        genererKoder();
    }

    private void genererKoder(){
        for (int i=0; i<kodeArray.length; i++){
            kodeArray[i]=100000 +r.nextInt(900000);
        }
    }

    public String nyKode(int maxAntall){
        if (NyKodeIndex<maxAntall){
            return Integer.toString(kodeArray[NyKodeIndex++]);

        }
        return "Max antall! ";
    }

    public String formaterBrukteKoder(){
        String ut=" ";
        for (int i=0; i<NyKodeIndex; i++){
            ut+=kodeArray[i]+"\n";
        }
        return ut;
    }
}

public class HelloController {

public final int MAKS_ANTALL=10;
KodeGeneretor generetor = new KodeGeneretor(MAKS_ANTALL);


    @FXML
    private Label lblGamleKoder;

    @FXML
    private Label lblNyKode;

    @FXML
    void gamleKoder(ActionEvent event) {
        lblGamleKoder.setText(generetor.formaterBrukteKoder());
    }
    @FXML
    void nyKode(ActionEvent event) {
        lblNyKode.setText(generetor.nyKode(MAKS_ANTALL));
    }
}
