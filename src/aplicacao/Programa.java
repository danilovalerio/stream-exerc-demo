package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.Produto;

/*
 * Programa que lê um conjunto de produtos
 * a partir de um arquivo em formato .csv
 * (suponha que exista pelo menos um produto).
 * Em seguida mostrar o preço médio dos produtos.
 * Depois, mostrar os nomes, em ordem decrescente,
 * dos produtos que possuem preço inferior ao preço médio.
 */

public class Programa {

	public static void main(String[] args) {
		//Caminho do arquivo
		String path = "C:\\Users\\dsilva\\Documents\\produtos-stream.csv";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Produto> lista = new ArrayList<>();			
			String linha = br.readLine();
			
			while(linha != null) {
				String[] campos = linha.split(",");
				lista.add(new Produto(campos[0],Double.parseDouble(campos[1])));
				linha = br.readLine();
			}
			
			double precoMedio = lista.stream()
					.map(p -> p.getPreco())
					.reduce(0.0, (x,y) -> x + y) / lista.size();
			
			System.out.println("Preco médio: R$ "+ String.format("%.2f",precoMedio));
			System.out.println();
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> nomes = lista.stream()
					.filter(p -> p.getPreco() < precoMedio)
					.map(p -> p.getNome())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			nomes.forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}

}
