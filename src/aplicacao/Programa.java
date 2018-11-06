package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Programa que l� um conjunto de produtos
 * a partir de um arquivo em formato .csv
 * (suponha que exista pelo menos um produto).
 * Em seguida mostrar o pre�o m�dio dos produtos.
 * Depois, mostrar os nomes, em ordem decrescente,
 * dos produtos que possuem pre�o inferior ao pre�o m�dio.
 */

public class Programa {

	public static void main(String[] args) {
		//Caminho do arquivo
		String path = "C:\\Users\\dsilva\\Documents\\produtos-stream.csv";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String linha = br.readLine();
			while(linha != null) {
				
				System.out.println("ok");
				
				linha = br.readLine();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
