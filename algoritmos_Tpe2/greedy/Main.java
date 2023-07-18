package greedy;
import java.util.ArrayList;

public class Main{
    public static void main(String [] args) {
		String path = "TPE_2/greedy/dataSets/dataset3.txt";
		CSVReader reader = new CSVReader(path);
		ArrayList<String[]> datos = reader.read();
		SolucionGreedy greedy = new SolucionGreedy();
		ArrayList<Arco<Integer>> solucion = greedy.getRuta(datos);
        System.out.println("tuneles entre estaciones : ");
        System.out.println("dataset 3 : ");
        for (Arco<Integer> aux : solucion){
            System.out.println(aux);
        }
        System.out.println("metrica ( cantidad de veces q se entro a greedy ): " + greedy.getMetrica());
        System.out.println("metros a construir : " + greedy.getSuma());
    }
}