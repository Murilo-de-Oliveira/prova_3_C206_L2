package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true; //flag para controlar continuidade do programa
        Scanner sc = new Scanner(System.in); //declaração do scanner
        Arquivo arquivo = new Arquivo(); //declaração do arquivo
        Aluno aluno = new Aluno(); //aluno para inserção no arquivo
        ArrayList<Aluno> alunos = new ArrayList<>(); //declaração do arraylist de alunos
        System.out.println("Bem-vindo ao menu de Alunos");
        while(continuar){
            //Menu de opções
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Ordenar alunos (crescente por média)");
            System.out.println("4 - Mostrar quantidade de alunos (por curso)");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            //input da opção
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                //Cadastro de alunos
                case 1 :
                    try{
                        System.out.print("Nome do aluno: ");
                        aluno.setNome(sc.nextLine());
                        System.out.print("Matrícula do aluno: ");
                        int auxmat = sc.nextInt(); //auxiliar de verificação da matrícula, lança exceção se necessário
                        if(auxmat > 0){
                            aluno.setMatricula(auxmat);
                        } else {
                            throw new InfoInvalidaException("O valor da matrícula deve ser maior que 0");
                        }
                        sc.nextLine();
                        System.out.print("Curso do aluno: ");
                        String auxcurso = sc.nextLine().toLowerCase(); //auxiliar de verificação do curso, lança exceção se necessário
                        if(auxcurso.equalsIgnoreCase("Computação") | auxcurso.equalsIgnoreCase("Software") | auxcurso.equalsIgnoreCase("Telecomunicações")){
                            aluno.setCurso(auxcurso);
                        } else {
                            throw new InfoInvalidaException("Tipo inválido, deve ser Computação, Software e Telecomunicações");
                        }
                        System.out.print("Média do aluno: ");
                        float auxmedia = sc.nextFloat();
                        if(auxmedia > 0){
                            aluno.setMedia(auxmedia);
                        } else {
                            throw new InfoInvalidaException("O valor da média deve ser maior que 0");
                        }
                        //a função escrever é chamada para inserir o aluno no arquivo
                        arquivo.escrever(aluno);
                    } catch (InfoInvalidaException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;

                //Lista de alunos
                case 2 :
                    alunos = arquivo.ler(); //a lista de alunos armazena a lista retornada da função

                    //mostra os alunos cadastrados
                    for (Aluno valor : alunos) {
                        System.out.println("INFORMAÇÕES DO ALUNO: ");
                        System.out.println(valor.getNome());
                        System.out.println(valor.getMatricula());
                        System.out.println(valor.getCurso());
                        System.out.println(valor.getMedia());
                    }
                    break;

                //Lista de alunos ordenada
                case 3:
                    alunos = arquivo.ler(); //a lista de alunos armazena a lista retornada da função

                    Collections.sort(alunos); //lista os alunos baseado na média

                    //lista os alunos
                    for (Aluno valor : alunos) {
                        System.out.println("INFORMAÇÕES DO ALUNO: ");
                        System.out.println(valor.getNome());
                        System.out.println(valor.getMatricula());
                        System.out.println(valor.getCurso());
                        System.out.println(valor.getMedia());
                    }
                    break;

                //Mostra a quantidade de alunos por curso
                case 4:
                    alunos = arquivo.ler(); //a lista de alunos armazena a lista retornada da função
                    int comp_aluno = 0;
                    int soft_aluno = 0;
                    int teleco_aluno = 0;
                    //percorre lista de alunos
                    for (Aluno valor : alunos) {
                        switch (valor.getCurso()) {
                            case "computação" -> comp_aluno++;
                            case "software" -> soft_aluno++;
                            case "telecomunicações" -> teleco_aluno++;
                        }
                    }
                    System.out.println("Computação: " + comp_aluno);
                    System.out.println("Software: " + soft_aluno);
                    System.out.println("Telecomunicações: " + teleco_aluno);
                    break;

                //Sai do programa
                case 5:
                    continuar = false;
                    System.out.println("Saiu do programa");
                    break;
            }
        }
    }
}