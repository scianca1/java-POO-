package Lista_ordenada;

import java.util.Comparator;

public class Main {
	
		 public static void main(String[]args) {
     //Punto 4)
         //A
		Comparator<Integer> oint= new comparadorINT<>();	
		 ListaOrdenada<Integer> listap1= new ListaOrdenada<>(oint);
		 listap1.add(10);
		 listap1.add(21);
		 listap1.add(1);
		 listap1.add(5);
		 listap1.add(11);
		 //B
		
		for(Integer n:listap1) {
			System.out.print("|"+n+"|");
		}
		System.out.println("\n");
		//C	
		
		
		listap1.eliminarNodo(0);
		listap1.eliminarocurrencias(5);
		listap1.eliminarocurrencias(11);
		
		for(Integer n:listap1) {
			System.out.print("|"+n+"|");
		}
		System.out.println("\n");
		//D
		
		
		Comparator<String> oString= new comparadorSTRING<>();
		ListaOrdenada<String> listaString= new ListaOrdenada<>(oString);
		
		listaString.add("facil");
      	listaString.add("es");
		listaString.add("parcial");
		listaString.add("prog 2");
		//E
		for(String n:listaString) {
			System.out.print("|"+n+"|");
		}
		System.out.println("\n");
		//F
		System.out.println(listaString.getposocurrencia("parcial"));
		//G
		System.out.println(listaString.getposocurrencia("recuperatorio"));
		//H
		comparadorINV<String> comStringINV= new comparadorINV(oString);
		listaString.setOrden(comStringINV);
		for(String n:listaString) {
			System.out.print("|"+n+"|");
		}
		System.out.println("\n");
		//I primer estructura
		 Alumno alumno1= new Alumno("John","Doe",12000000,21);
		 alumno1.setInteres("intercambio");
         Alumno alumno2= new Alumno("Mora","Diaz",37124425,21);
         alumno2.setInteres("psicologia");
         alumno2.setInteres("Freud");
         Alumno alumno3= new Alumno("Roman","Bazan",32555111,21);
         alumno3.setInteres("argentina");
         Alumno alumno4= new Alumno("Martin","Gomez",3411122,21);
         alumno4.setInteres("romanos");
         alumno4.setInteres("egipcios");
         alumno4.setInteres("Griegod");
         Alumno alumno5= new Alumno("Flora","Rivas",34555111,21);
         alumno5.setInteres("Historia");
         alumno5.setInteres("Antigua");
         Alumno alumno6= new Alumno("Juana","Garcia",27123466,21);
         alumno6.setInteres("Programacion");
         alumno6.setInteres("Php");
         alumno6.setInteres("Java");
         Alumno alumno7= new Alumno("Federico","Lopez",359999888,21);
         alumno7.setInteres("Redes");
         alumno7.setInteres("Php");
         alumno7.setInteres("Java");
         alumno7.setInteres("Python");
         
         comparadorCantidad<ElementoComp> comCant= new comparadorCantidad<>();
         comparadorINV<ElementoUni> comintINV= new comparadorINV(comCant); 
         ElementoComp historia= new ElementoComp(comintINV,"historia");
         historia.addElemento(alumno5);
         historia.addElemento(alumno4);
         historia.addElemento(alumno3);
         
         ElementoComp humanas= new ElementoComp(comintINV,"humanas");
         humanas.addElemento(alumno2);
         humanas.addElemento(historia);
         
         ElementoComp exactas= new ElementoComp(comintINV,"exactas");
         exactas.addElemento(alumno6);
         exactas.addElemento(alumno7);
		
         ElementoComp unicen= new ElementoComp(comintINV,"unicen");
         unicen.addElemento(alumno1);
         unicen.addElemento(exactas);
         unicen.addElemento(humanas);
           
		 ListaOrdenada<ElementoUni>	 estructura1= new ListaOrdenada<>(comintINV);
		 estructura1.add(unicen);
		 for(ElementoUni n:estructura1) {
				System.out.print("|"+n+"|");
			}
			System.out.println("\n");
		 
		 //Estructura2
		 
		 Alumno alumno8= new Alumno("bernardino","Rivas",30987654,21);
		 alumno8.setInteres("matematicas");
         Alumno alumno9= new Alumno("Jose","Paso",33322112,21);
		 alumno9.setInteres("Problemas");
		 Alumno alumno10= new Alumno("Isaac","Newton",12343565,21);
		 alumno10.setInteres("sucesiones");
		 Alumno alumno11= new Alumno("Juan","Juarez",3322244,21);
		 alumno11.setInteres("sucesiones");
		 alumno11.setInteres("algebras");
		 Alumno alumno12= new Alumno("Julio","Cesar",33222111,21);
		 alumno12.setInteres("sucesiones");
		 alumno1.setInteres("algebras");
		 
		 comparadorCantidad<ElementoComp> comCant2= new comparadorCantidad<>();
         comparadorINV<ElementoUni> comintINV2= new comparadorINV(comCant2); 
		  ElementoComp LosFibos= new ElementoComp(comintINV2,"LosFibos");
		  LosFibos.addElemento(alumno10);
	      LosFibos.addElemento(alumno8);
	      LosFibos.addElemento(alumno9);
	      
	      
	      ElementoComp Matea2= new ElementoComp(comintINV2,"Mateas");
	      Matea2.addElemento(alumno11);
	      Matea2.addElemento(alumno12);
	      
	      ElementoComp OlimpiadasMatematica= new ElementoComp(comintINV2,"Olimpiadas Matematicas");
	      OlimpiadasMatematica.addElemento(Matea2);
	      OlimpiadasMatematica .addElemento(LosFibos);
	      
	      ListaOrdenada<ElementoUni> estructura2= new ListaOrdenada<>(comintINV2);
			 estructura2.add(OlimpiadasMatematica);
			 for(ElementoUni n:estructura2) {
					System.out.print("|"+n+"|");
				}
	        }
		 
}
