package agenda;
import java.util.Scanner;

public class Agenda {
	
	Contato contatos;
	Scanner scanner = new Scanner(System.in);
	
	public void iniciaAgenda() {
		
	}
	
	public Contato localizaContato() {
		System.out.println("Você deseja localizar o seu contato por qual meio?");
		System.out.println("Nome\nNumero\nEmail\nEndereco\nSe não desejar buscar digite 'sair'");
		String opcaoEscolhida = scanner.next();
		while(!opcaoEscolhida.equals("Nome") && !opcaoEscolhida.equals("Numero")
				&& !opcaoEscolhida.equals("Email") && !opcaoEscolhida.equals("Endereco")
				&& !opcaoEscolhida.equals("Sair")) {
			System.out.println("Opção inválida, por favor digite novamente.");
			System.out.println("Nome\nNumero\nEmail\nEndereco");
			opcaoEscolhida = scanner.next();
			System.out.println(opcaoEscolhida);
		}
		
		switch(opcaoEscolhida) {
		case "Nome":
			System.out.println("Por favor, digite o nome do usuário:");
			String nomeDigitado = scanner.next();
			Contato contatoAuxiliar = this.contatos;
			boolean naoEncontrou = false;
			
			while(contatoAuxiliar != null) {
				if(contatoAuxiliar.nome.equals(nomeDigitado)) {
					System.out.println(contatoAuxiliar + "\nEste é o contato procurado? 'Sim'/'Nao'");
					String opcaoDesejada = scanner.next();
					if(opcaoDesejada.equals("Sim")) {
						naoEncontrou = true;
						return contatoAuxiliar;
					}
				}
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
			
			if(naoEncontrou == false) {
				System.out.println("Usuário não encontrado");
			}
			break;
			
		case "Numero":
			System.out.println("Por favor, digite o número do usuário:");
			int numero = scanner.nextInt();
			Contato contatoAuxiliar2 = this.contatos;
			boolean naoEncontrou2 = false;
			
			while(contatoAuxiliar2 != null) {
				if(contatoAuxiliar2.numero == numero) {
					System.out.println(contatoAuxiliar2 + "\nEste é o contato procurado? 'Sim'/'Nao'");
					String opcaoDesejada = scanner.next();
					if(opcaoDesejada.equals("Sim")) {
						naoEncontrou = true;
						return contatoAuxiliar2;
					}
				}
				contatoAuxiliar = contatoAuxiliar2.contatoProximo;
			}
			
			if(naoEncontrou2 == false) {
				System.out.println("Usuário não encontrado");
			}
			break;
			
		case "Email":
			System.out.println("Por favor, digite o email do usuário:");
			String email = scanner.next();
			Contato contatoAuxiliar3 = this.contatos;
			boolean naoEncontrou3 = false;
			
			while(contatoAuxiliar3 != null) {
				if(contatoAuxiliar3.email.equals(email)) {
					System.out.println(contatoAuxiliar3 + "\nEste é o contato procurado? 'Sim'/'Nao'");
					String opcaoDesejada = scanner.next();
					if(opcaoDesejada.equals("Sim")) {
						naoEncontrou = true;
						return contatoAuxiliar3;
					}
				}
				contatoAuxiliar = contatoAuxiliar3.contatoProximo;
			}
			
			if(naoEncontrou3 == false) {
				System.out.println("Usuário não encontrado");
			}
			break;
		
		case "Endereco":
			System.out.println("Por favor, digite o endereço do usuário:");
			String endereco = scanner.next();
			Contato contatoAuxiliar4 = this.contatos;
			boolean naoEncontrou4 = false;
			
			while(contatoAuxiliar4 != null) {
				if(contatoAuxiliar4.endereco.equals(endereco)) {
					System.out.println(contatoAuxiliar4 + "\nEste é o contato procurado? 'Sim'/'Nao'");
					String opcaoDesejada = scanner.next();
					if(opcaoDesejada.equals("Sim")) {
						naoEncontrou = true;
						return contatoAuxiliar4;
					}
				}
				contatoAuxiliar = contatoAuxiliar4.contatoProximo;
			}
			
			if(naoEncontrou4 == false) {
				System.out.println("Usuário não encontrado");
			}
			break;
			
		}
		
		return null;
		
	}
	
	public Contato criaContato() {
		System.out.println("Vamos começar o preenchimento do contato:");
		System.out.println("Por favor digite o nome dele:");
		String nome = scanner.next();
		System.out.println("Digite o número de telefone dele:");
		int numeroDeTelefone = scanner.nextInt();
		System.out.println("Digite agora o email dele:");
		String email = scanner.next();
		System.out.println("Agora digite o seu endereço:");
		String endereco = scanner.next();
		Contato contato = new Contato(nome,numeroDeTelefone,email,endereco);
		return contato;
	}
	
	public void imprimeContatos() {
		System.out.println("Imprimindo contatos...");
		
		if(contatos == null) {
			System.out.println("Você não tem nenhum contato. Por favor adicione alguns!");
		} else {
			Contato contatoAuxiliar = this.contatos;
			while(contatoAuxiliar != null) {
				System.out.println(contatoAuxiliar);
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
		}
	}
	
	public int retornaNumeroDeElementos() {
		int contador = 1;
		Contato contatoAuxiliar = this.contatos;
		
		while(contatoAuxiliar.contatoProximo != null) {
			contador += 1;
			contatoAuxiliar = contatoAuxiliar.contatoProximo;
		}
		
		return contador;
		
	}
	
	public void organizaContatosPorNome() {
			Contato contatoAuxiliar = this.contatos;
			Contato contatoProximo = this.contatos;
			Agenda agendaDuplicada = new Agenda();
			
			while(contatoAuxiliar != null) {
				int contador = 0;
				while(contatoProximo != null) {
					if(contatoAuxiliar.nome.compareToIgnoreCase(contatoProximo.nome) > 0) {
						contador += 1;
						break;
					} 	else if (contatoAuxiliar.nome.compareToIgnoreCase(contatoProximo.nome) == 0 && !contatoAuxiliar.equals(contatoProximo)) {
						if(contatoAuxiliar.getNumero() > contatoProximo.getNumero()) {
							contador += 1;
							break;
						} 
					}
					contatoProximo = contatoProximo.contatoProximo;
				}
				if(contador == 0) {
					Contato contato = new Contato(contatoAuxiliar.nome,contatoAuxiliar.numero,contatoAuxiliar.email,contatoAuxiliar.endereco);
					agendaDuplicada.adicionaContato(contato);
					this.removeContato(contatoAuxiliar);
					contatoAuxiliar = this.contatos;
					contatoProximo = this.contatos;
				} else {
					contatoAuxiliar = contatoAuxiliar.contatoProximo;
					contatoProximo = this.contatos;
				}
			}
			
			this.contatos = agendaDuplicada.contatos;
			
		}
	
	public void adicionaContato() {
	
		Contato contato = criaContato();
		if (this.contatos == null) {
			this.contatos = contato;
			System.out.println("Contato adicionado com sucesso.");
		} else if(this.contatos == contato) {
			System.out.println("Contato já existente.");
		}
		else {
			Contato contatoAuxiliar = this.contatos;
			while(contatoAuxiliar.contatoProximo != null) {
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
			contatoAuxiliar.contatoProximo = contato;
			contato.contatoAnterior = contatoAuxiliar;
			contato.contatoProximo = null;
			System.out.println("Contato adicionado com sucesso.");
		}
	}
		
	public void adicionaContato(Contato contato) {
		if (this.contatos == null) {
			this.contatos = contato;
			System.out.println("Contato adicionado com sucesso.");
		} else if(this.contatos == contato) {
			System.out.println("Contato já existente.");
		}
		else {
			Contato contatoAuxiliar = this.contatos;
			while(contatoAuxiliar.contatoProximo != null) {
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
			contatoAuxiliar.contatoProximo = contato;
			contato.contatoAnterior = contatoAuxiliar;
			contato.contatoProximo = null;
			System.out.println("Contato adicionado com sucesso.");
		}
	}
	
	public void removeContato() {
		Contato contato = localizaContato();
		
		if(this.contatos == null) {
			System.out.println("Lista vazia, não tem ninguém para remover.");
		} else {
			Contato contatoAuxiliar = this.contatos;
			boolean removido = false;
			while(contatoAuxiliar != null) {
				if(contatoAuxiliar.equals(contato)) {
					if(contatoAuxiliar.contatoAnterior == null && contatoAuxiliar.contatoProximo == null) {
						this.contatos = null;
						removido = true;
						break;
					}
					else if(contatoAuxiliar.contatoProximo == null) {
						contatoAuxiliar.contatoAnterior.contatoProximo = null;
						removido = true;
						break;
					} 
					else if(contatoAuxiliar.contatoAnterior == null) {
						contatoAuxiliar.contatoProximo.contatoAnterior = null;
						this.contatos = this.contatos.contatoProximo;
						removido = true;
						break;
					}
					else {
						contatoAuxiliar.contatoAnterior.contatoProximo = contatoAuxiliar.contatoProximo;
						contatoAuxiliar.contatoProximo.contatoAnterior = contatoAuxiliar.contatoAnterior;
						removido = true;
						break;
					}
				}
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
			if(removido == true) {
				System.out.println("Contato removido com sucesso.");
			} else {
				System.out.println("Não foi possível remover o contato");
			}
		}
	}
	
	public void removeContato(Contato contato) {
		if(this.contatos == null) {
			System.out.println("Lista vazia, não tem ninguém para remover.");
		} else {
			Contato contatoAuxiliar = this.contatos;
			boolean removido = false;
			while(contatoAuxiliar != null) {
				if(contatoAuxiliar.equals(contato)) {
					if(contatoAuxiliar.contatoAnterior == null && contatoAuxiliar.contatoProximo == null) {
						this.contatos = null;
						removido = true;
						break;
					}
					else if(contatoAuxiliar.contatoProximo == null) {
						contatoAuxiliar.contatoAnterior.contatoProximo = null;
						removido = true;
						break;
					} 
					else if(contatoAuxiliar.contatoAnterior == null) {
						System.out.println("Oi");
						contatoAuxiliar.contatoProximo.contatoAnterior = null;
						this.contatos = this.contatos.contatoProximo;
						removido = true;
						break;
					}
					else {
						contatoAuxiliar.contatoAnterior.contatoProximo = contatoAuxiliar.contatoProximo;
						contatoAuxiliar.contatoProximo.contatoAnterior = contatoAuxiliar.contatoAnterior;
						removido = true;
						break;
					}
				}
				contatoAuxiliar = contatoAuxiliar.contatoProximo;
			}
			if(removido == true) {
				System.out.println("Contato removido com sucesso.");
			} else {
				System.out.println("Não foi possível remover o contato");
			}
		}
	}
	
	public void inicializaAgenda() {
		System.out.println("Bem vindo à sua agenda, o que você gostaria de fazer?");
		boolean rodando = true;
		
		while(rodando) {
			System.out.println("1 - Adicionar contato\n2 - Remover contato\n3 - Imprimir contatos\n4 - Ordenar contatos\n5 - Sair");
			int opcaoEscolhida = scanner.nextInt();
			switch(opcaoEscolhida) {
			case 1:
				adicionaContato();
				break;
			case 2:
				removeContato();
				break;
			case 3:
				imprimeContatos();
				break;
			case 4:
				organizaContatosPorNome();
				break;
			case 5:
				rodando = false;
				break;
			default:
				System.out.println("Opção escolhida inválida, por favor digite outra.");
				break;
			}
		}
		
		System.out.println("Saindo do programa");
		
	}

}
