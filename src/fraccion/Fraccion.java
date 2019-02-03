/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccion;

/**
 *
 * @author PC Nuevo
 */
public class Fraccion {

    private int numerador;
    private int denominador;
    private int resultado;

    public  Fraccion(int numerador, int denominador) {
       
        this.numerador = numerador;
        this.denominador = denominador;
        
    }
    public Fraccion() {
         
    }
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    private void invierte() {
    int auxiliar = 0;
    auxiliar = this.numerador;
    this.numerador = this.denominador;
    this.denominador = auxiliar;    
    }
    /**
     * <h3><u>METODO MULTIPLICAR</u></h3>
     * <br>
     * Este metodo multiplica la fraccion que lo ejecuta por la que se pasa por parametros al metodo multiplicar para luego retornar una nueva Fraccion con el resultado de la multiplicacion de las anteriores
     * @param f Fraccion que se pasara por parametros al metodo multiplicar
     */
    private Fraccion multiplica(Fraccion f) {
    Fraccion fraccion;
    fraccion = new Fraccion(this.numerador*f.numerador, this.denominador*f.denominador);
    return fraccion;
    }

    /**
     * Esta funcion simplifica la fraccion que la llama
     *
     */
    private Fraccion simplificada(){
 
      return  simplificada(this);

    }
 
    private Fraccion simplificada(Fraccion f){
   
    int[] arrayPrimos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; 

    int numeradorEntre = 0;
    int denominadorEntre = 0;
         for (int i = 0; i < arrayPrimos.length; i++) {
             int numeroPrimo = arrayPrimos[i];
          
             if (f.numerador %numeroPrimo == 0 && f.numerador != numeroPrimo && f.numerador !=1) {
             numeradorEntre = numeroPrimo;
             
             }
             if (f.denominador %numeroPrimo == 0 && f.denominador != numeroPrimo && f.denominador !=1) {
             denominadorEntre = numeroPrimo;
             
             }
             if((numeradorEntre != 0 && denominadorEntre != 0)){
                 break;
             }
         }
        if((numeradorEntre == 0 || denominadorEntre == 0)){
            //Si no podemos dividir entre nuestros numeros primos del array, tenemos un resultado valido
            return f;
        }
        
        Fraccion fraccion1 = new Fraccion(f.numerador/numeradorEntre, f.denominador/denominadorEntre);
        return this.simplificada(fraccion1);

        
    }
    private Fraccion divide(Fraccion f) {
    
        
        
    Fraccion fraccion;
    fraccion = new Fraccion(this.numerador*f.denominador, this.denominador*f.numerador);
    return fraccion;
    
    }
     private Fraccion divide(int numero) {
    Fraccion fraccion;
    fraccion = new Fraccion(this.numerador, this.denominador*numero);
    return fraccion;
    }
     
    @Override
    public String toString() {
        return  numerador + "/" + denominador ;
    } 
    
    
    public static void main(String[] args){
    
    Fraccion f = new Fraccion(2,2);
    Fraccion f1 = new Fraccion(240,120);
    
    
    Fraccion fraccionResultado = f.multiplica(f1);
    f.invierte();
    System.out.println(f1.simplificada());
    Fraccion fraccionResultado2;
    fraccionResultado2 = f.divide(f1);
    
    System.out.println("El resultado de la multiplicacion es:"+ fraccionResultado.toString());
    System.out.println("El resultado de la división es:"+ fraccionResultado2.toString());
    }
    
    
}
