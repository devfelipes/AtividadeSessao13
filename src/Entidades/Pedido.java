package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entidades.enums.OrdemStatus;

public class Pedido {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY"); 
	private Date momento = new Date();
	private OrdemStatus status;
	private List<Item> item = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido() {}

	public Pedido(Date momento, OrdemStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionarItem (Item item) {
		this.item.add(item);
	}
	public void removerItem (Item item) {
		this.item.remove(item);
	}
	
	public Double total() {
		double soma = 0;
		for (Item i: item) {
			soma += i.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento: ");
		sb.append(sdf.format(getMomento()) + "\n");
		sb.append("Status: ");
		sb.append(getStatus() + "\n");
		sb.append("Cliente: ");
		sb.append(getCliente());
		for (Item i : item) {
			sb.append(i + "\n");
		}
		sb.append("Total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}


}
