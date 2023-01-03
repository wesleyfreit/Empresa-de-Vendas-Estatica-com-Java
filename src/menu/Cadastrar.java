package menu;

import app.Empresa;
import registration.type.Roupa;
import storage.Dados;

public class Cadastrar {


    public static void cadastro(int id) {

        String nomeProduto;
        int quantidade;
        double valor;
        String tipoProduto;
        String tamanhoTipo;
        Character publico;

        System.out.println("\n---------------------\n| CADASTRAR PRODUTO |\n---------------------");

        tipoProduto = setTipoProduto();

        Empresa.scanner.nextLine();
        System.out.print("\nNome: ");
        nomeProduto = Empresa.dados.setTittleCaseString(Empresa.scanner.nextLine());

        System.out.print("Valor de venda: ");
        valor = Empresa.scanner.nextDouble();

        System.out.print("Quantidade para estocar: ");
        quantidade = Empresa.scanner.nextInt();

        if(tipoProduto == Roupa.nome){
            tamanhoTipo = setTamanhoRoupa();

            System.out.print("\nA peça é feminina(F) ou masculina(M)? "); 
        } else {
            tamanhoTipo = setTipoPerfume();

            Empresa.scanner.nextLine();
            System.out.print("\nO perfume é feminino(F) ou masculino(M)? ");
        }

        publico = setTipoPublico();

        Dados produto = new Dados(id, nomeProduto, quantidade, valor, tipoProduto, publico, tamanhoTipo);
        Empresa.dados.cadastroProduto(produto);
        
        System.out.println("\nProduto Cadastrado.");
    }

    public static String setTipoProduto() {
        String tipo;
        boolean run = true;

        do{
            System.out.println("Insira o tipo de produto a ser cadastrado");
            System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
            tipo = Empresa.dados.setTipoProduto(Empresa.scanner.nextInt());

            if(tipo != null){
                run = false;
            } else {
                System.out.println("\nValor inválido, tente novamente.");
            }

        } while(run);
        return tipo;
    }

    public static String setTamanhoRoupa() {
        String numeracao;
        String tamanhoRoupa = null;
        boolean run = true;
        do {
            System.out.println("\nQual a numeração ou tamanho da peça?");
            System.out.print("\n1 - Ver Numerações e Tamanhos\n2 - Inserir Numeração ou Tamanho\n\nDigite: ");
            
            switch(Empresa.scanner.nextInt()){
                case 1:
                System.out.println("\n");
                Empresa.dados.getTamanhosRoupa();
                    break;
                case 2:
                Empresa.scanner.nextLine();
                    System.out.print("\nNumeração ou tamanho da peça: ");
                    numeracao = Empresa.scanner.next();
                    tamanhoRoupa = Empresa.dados.setTamanhoRoupa(numeracao);

                    if(tamanhoRoupa != null) {
                        run = false;
                    } else {
                        System.out.println("\nValor inválido, tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Número inválido, tente novamente.");
                    break;
            }
        } while(run);

        return tamanhoRoupa;
    }

    public static String setTipoPerfume() {
        Character tipo;
        String tipoFull = null;
        boolean run = true;
        do {
            System.out.println("\nQual é o tipo de perfume?");
            System.out.print("\n1 - Ver Tipos\n2 - Inserir Tipo\n\nDigite: ");
            
            switch(Empresa.scanner.nextInt()){
                case 1:
                System.out.println("\n");
                Empresa.dados.getTiposPerfume();
                    break;
                case 2:
                Empresa.scanner.nextLine();
                    System.out.print("\nTipo de perfume: ");
                    tipo = Empresa.scanner.next().charAt(0);
                    tipoFull = Empresa.dados.setTipoPerfume(tipo);

                    if(tipoFull != null) {
                        run = false;
                    } else {
                        System.out.println("\nValor inválido, tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Número inválido, tente novamente.");
                    break;
            }
        } while(run);

        return tipoFull;
    }

    public static Character setTipoPublico(){
        Character tipoPublico;
        boolean run = true;
        do {
            tipoPublico = Empresa.dados.setPublico(Empresa.scanner.next().charAt(0));

            if(tipoPublico == null){
                System.out.println("\nValor inválido, tente novamente.");
                Empresa.scanner.nextLine();
                System.out.print("\nO público é feminino(F) ou masculino(M)? ");
            } else {
                run = false;
            }
        } while(run);

        return tipoPublico;
    }
}