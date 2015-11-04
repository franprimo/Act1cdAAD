package compara_busca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Compara_Busca {


	public static void main(String[] args) throws IOException {
		File fichero1 = new File("texto1.txt");
		File fichero2 = new File("texto2.txt");
		File fichero3 = new File("texto3.txt");
		String palabraClave = "compruebo";
		boolean esUltima = false;
		
		compararContenido(fichero1, fichero2);
		buscarPalabra(fichero3, palabraClave, esUltima);
		
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
		

}


