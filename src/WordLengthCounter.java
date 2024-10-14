import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WordLengthCounter {

    public static void main(String[] args) {
        // Ruta del archivo
        String fileName = "C:\\Users\\solch\\Downloads\\cuento 1.txt";

        // HashMap para almacenar la longitud de palabras y las palabras que corresponden a esa longitud
        HashMap<Integer, ArrayList<String>> wordLengthMap = new HashMap<>();

        int totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Lee el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Divide la línea en palabras, usando como delimitador cualquier no letra
                String[] words = line.split("\\P{L}+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        int length = word.length();

                        // Si la longitud no está en el HashMap, agrega una nueva lista
                        wordLengthMap.putIfAbsent(length, new ArrayList<>());

                        // Agrega la palabra a la lista correspondiente a su longitud
                        wordLengthMap.get(length).add(word);

                        totalWords++;
                    }
                }
            }

            // Muestra los resultados
            for (int length : wordLengthMap.keySet()) {
                System.out.println("Palabras de longitud " + length + ": " + wordLengthMap.get(length));
            }
                // Muestra el total de palabras
                System.out.println("\nCantidad total de palabras: " + totalWords);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

