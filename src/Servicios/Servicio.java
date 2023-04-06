/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Ahorcado.ahorcado;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author LizzW
 */
public class Servicio {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    ahorcado p = new ahorcado();
 
    
    public void crearJuego(){
        
        System.out.println("Ingrese palabra");
        String aux = sc.nextLine();
        String[] vaux = new String [longitud(aux)];
        int res=0;
        String letra;
     
        String[] ver = new String[longitud(aux)]; 
        Arrays.fill(ver,"_");
        
        System.out.println(aux.substring(0,1));
        for (int i = 0; i < longitud(aux); i++) {
            vaux[i] = aux.substring(i, i+1);
        }
        
        p.setPalabra(vaux);
        
        System.out.println("Ingrese número maximo de intentos");
        p.setIntentos(sc.nextInt());
        
        String[] filtro = new String[p.getIntentos()];
        Arrays.fill(filtro,"");
        for (int i = 0; i < 10; i++) {
            
        }
        do{
            System.out.println("Ingrese una letra");
            letra = sc.next();
            
            System.out.println("La longitud de la palabra es:"+longitud(aux));
            res = buscar(letra, aux, ver, filtro);
            if(res>0){
                System.out.println("La letra "+letra+ " pertenece a la palabra.");
            }else{
                System.out.println("La letra "+letra+ " No pertenece a la palabra.");
            }
            
            System.out.println("Intentos disponibles:"+p.getIntentos());
          
            System.out.println("Letras encontradas:"+p.getEncontradas());
            
            if(longitud(aux) == p.getEncontradas()){
                System.out.println("Ganaste =)");
            }else if(p.getIntentos()==0){
                System.out.println("¡Perdiste! =( Te has quedado sin intentos");
            }
            
        }while(p.getIntentos()>0 &&  !(p.getEncontradas()>=longitud(aux)));
    }
    
    public int longitud(String palabra){
        return palabra.length();
    }
    
    public int buscar(String letra, String aux, String[] ver, String[] filtro){
        int cnt = 0;
        boolean respuesta = true;
        
        for (int i = 0; i < p.getIntentos(); i++) {
            if(filtro[i].equals(letra)){
                respuesta=false;
            }
        }
        
        if(respuesta){
            for (int i = 0; i < longitud(aux); i++) {
                if(p.getPalabra(i).equals(letra)){
                    p.setEncontradas(p.getEncontradas()+1);
                    cnt++;

                    ver[i]=letra;
                    for (int x = 0; x < p.getIntentos(); x++) {
                        if(respuesta && filtro[x]==""){
                            filtro[x]=letra;
                            respuesta = false;
                        }
                    }
                }
                if(ver[i]!=null){
                    System.out.print("["+ver[i]+"]");
                }else{
                    System.out.print("[_]");
                }
            }
                System.out.println("");
                
                if(cnt==0){
                    p.setIntentos(p.getIntentos()-1);
                }
        }else{
            System.out.println("La letra ya ha sido usada");
            cnt++;
        }
        
        return cnt;
    }
}
