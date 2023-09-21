package agenda;

import java.util.Date;
import java.util.Objects;

public class Contato implements Cloneable {
	
	public String nome;
	public Integer numero;
	public String email;
	public String endereco;
	public Contato contatoProximo;
	public Contato contatoAnterior;
	
	public Contato(String nome,int numero,String email, String endereco) {
		this.nome = nome;
		this.numero = numero;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Contato() { 
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Nome:" + nome + 
				"\nNumero:" + numero + 
				"\nEmail=" + email + 
				"\nEndereco=" + endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contatoAnterior, contatoProximo, email, endereco, nome, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(contatoAnterior, other.contatoAnterior)
				&& Objects.equals(contatoProximo, other.contatoProximo) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome)
				&& numero == other.numero;
	}
	

}
