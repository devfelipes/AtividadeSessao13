package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Cliente;
import Entidades.Item;
import Entidades.Pedido;
import Entidades.Produto;
import Entidades.enums.OrdemStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.nextLine());
		Cliente cliente = new Cliente(nome, email, data);
		System.out.print("Status: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.nextLine());
		System.out.print("Quantos itens: ");
		Integer n = sc.nextInt();	
		Pedido pedido = new Pedido(data, status, cliente);
		for (int i=0 ; i<n; i++) {
			System.out.println("Entre com os dados do protudo "+(i +1));
			System.out.print("Nome do Produto: ");
			String produtoNome = sc.next();
			System.out.print("Preço do Produto: ");
			double produtoPreco = sc.nextDouble();
			System.out.print("Quantidade do Produto: ");
			int produtoQuantidade = sc.nextInt();
			Produto produto = new Produto(produtoNome, produtoPreco);
			Item item = new Item(produtoQuantidade, produtoPreco, produto);
			
			pedido.adicionarItem(item);
		}
				
		System.out.println();
		System.out.println("Pedidos:" );
		System.out.println(pedido);
				
				
				
		sc.close();
	}

}
