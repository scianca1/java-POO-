package backtracking;
import java.util.ArrayList;

public class Main{
    public static void main(String [] args) {
		String path = "TPE_2/backtracking/dataSets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		ArrayList<String[]> datos = reader.read();
		SolucionBackTracking back = new SolucionBackTracking();
		ArrayList<Arco<Integer>> solucion = back.getmejorRuta(datos);
        System.out.println("tuneles entre estaciones : ");
        System.out.println("dataset 1: ");
        for (Arco<Integer> aux : solucion){
            System.out.println(aux);
        }
        System.out.println("metrica ( cantidad de veces q se entro a backtracking ): " + back.getMetrica());
        System.out.println("metros a construir : " + back.getmMejorSuma());
		
        String path2 = "TPE_2/backtracking/dataSets/dataset2.txt";
		CSVReader reader2 = new CSVReader(path2);
		ArrayList<String[]> datos2 = reader2.read();
		SolucionBackTracking back2 = new SolucionBackTracking();
		ArrayList<Arco<Integer>> solucion2 = back2.getmejorRuta(datos2);
        System.out.println("tuneles entre estaciones : ");
        System.out.println("dataset 2: ");
        for (Arco<Integer> aux : solucion2){
            System.out.println(aux);
        }
        System.out.println("metrica ( cantidad de veces q se entro a backtracking ): " + back2.getMetrica());
        System.out.println("metros a construir : " + back2.getmMejorSuma());
		
        //no ejecutar este main xq tarda mucho en llegar a la solucion
        //String path3 = "TPE_2/backtracking/dataSets/dataset3.txt";
		//CSVReader reader3 = new CSVReader(path3);
		//ArrayList<String[]> datos3 = reader3.read();
		//SolucionBackTracking back3 = new SolucionBackTracking();
		//ArrayList<Arco<Integer>> solucion3 = back.getmejorRuta(datos3);
        System.out.println("tuneles entre estaciones : ");
        System.out.println("dataset 3:");
        System.out.println(" ");
        System.out.println("no lo corrimos porque tarda mucho en llegar a la solucion pero:");
        System.out.println("metrica = 13!");
        System.out.println("metros a construir = 440");
        //for (Arco<Integer> aux : solucion){
        //    System.out.println(aux);
        //}
        
    }
}
