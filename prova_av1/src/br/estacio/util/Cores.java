package br.estacio.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cores {

    public static void main(String[] args) {

        List<String> cores = new ArrayList<>();

        cores.add( "Azul" );
        cores.add( "Vermelho" );
        cores.add( "Amarelo" );
        cores.add( "Preto" );
        cores.add( "Laranja" );
        cores.add( "Roxo" );

        for ( String cor : cores) {
            System.out.println( cor );
        }

        cores.add( "Branco" );
        cores.add( "verde" );
        cores.add( "Rosa" );
        Collections.sort( cores );

        System.out.println( "\n" );

        for ( String cor : cores ) {
            System.out.println( cor );
        }



    }

}
