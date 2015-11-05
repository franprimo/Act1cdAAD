package compara_busca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Compara_Busca {


	public static void main(String[] args) throws IOException {
		File fichero1 = new File("texto1.txt");
		File fichero2 = new File("texto2.txt");
		File fichero3 = new File("texto3.txt");
		File fichero4 = new File("texto4.txt");
		String palabraClave = "compruebo";
		boolean esUltima = false;
		
		//compararContenido(fichero1, fichero2);
		//buscarPalabra(fichero3, palabraClave, esUltima);
		ordenarFichero(fichero3, fichero4, 1);
		
	}
	
	public static void compararContenido(File fichero1, File fichero2) throws IOException{
		
		boolean sonIguales = true;
		FileReader fr = new FileReader(fichero1);
		FileReader fr2 = new FileReader(fichero2);
		BufferedReader br = new BufferedReader(fr);
		BufferedReader br2 = new BufferedReader(fr2);
		int cont1 = 0, cont2 = 0;
		String str = "", str2 = "";
		
		while(str != null || str2 != null){
			str = br.readLine();
			str2 = br2.readLine();
			//System.out.println(str); //Compruebo que hace bien la lectura del fichero.
			
			//Compruebo si tienen mas lineas. Si es asi, incremento el contador.
			if(str != null){
				cont1++;
			}
			if(str2 != null){
				cont2++;
			}
		}

		//System.out.println("el fichero 1 tiene "+ cont1 + " lineas.");
		//System.out.println("el fichero 2 tiene "+ cont2 + " lineas.");
					
		br.close();
		br2.close();
		
		if(cont1 == cont2){
			sonIguales = true;
			System.out.println("Los ficheros son iguales.");
		}else{
			sonIguales = false;
			System.out.println("Los ficheros NO son iguales.");
		}

	}
	
	public static void buscarPalabra(File fichero1, String palabra, boolean primera_aparicion) throws FileNotFoundException{
		FileReader fr = new FileReader(fichero1);
		BufferedReader br = new BufferedReader(fr);
		String palabraMagica = palabra, str = "";
		int cont = 0;
		boolean siAparece = primera_aparicion;
		
		int d = palabraMagica.length();
		//System.out.println("La longitud de la palabra es "+d);
		
		try {
			while(str != null){
				cont++;
				str = br.readLine();				
				if(str.length() == palabraMagica.length()){					
					for(int i=0; i<palabraMagica.length();i++){											
						if(str.charAt(i) == palabraMagica.charAt(i)){
							siAparece = true;
							System.out.println("Palabra encontrada en la linea "+cont);
							break;
						}											
					}								
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ordenarFichero(File origen, File destino, int tipo_orden){
		FileReader fr = null; //Declaro el FileReader e inicializo a null
		FileWriter fw = null; //Declaro el FileWriter e inicializo a null
		BufferedReader br = null; //Declaro el BufferedReader e inicializo a null
		BufferedWriter bw = null; //Declaro el BufferedWriter e inicializo a null
		ArrayList<String> lista = new ArrayList<String>(); //Declaro un ArrayList de tipo String
		
		//Declaro variables.
		String str = "";
		int orden = tipo_orden;
		
		//Compruebo el parametro que se nos pasa este en el rango que se acepta.
		if(orden == 0 || orden == 1){
			try {
				//Inicializo
				fr = new FileReader(origen);
				fw = new FileWriter(destino);
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			//Inicializo
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			try {
				//Hasta que llegue al final del fichero, voy guardandolo en el array.
				while(str != null){
					lista.add(str);
					str = br.readLine();
				}
				
				if(orden == 1){
					//Si quiero el fichero ascendentemente, lo escribe en el fichero de salida desde la posicion 0.
					for(int x = 0; x <= lista.size()-1; x++){
						bw.write(lista.get(x)+"\n");
					}
				}else{
					//Si quiero el fichero al contrario, lo escribo desde el final del tamaño del arraylist hasta 0.
					for(int x = lista.size()-1; x>=0; x--){
						bw.write(lista.get(x)+"\n");
					}
				}
				
				//Cierro los flujos de datos.
				br.close();
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else{
			//Si la variable orden esta fuera del rango, muestro un mensaje de error.
			System.out.println("El orden tiene que ser 0(descendente) o 1(ascendente)");
		}
		
	
	}
		

}


