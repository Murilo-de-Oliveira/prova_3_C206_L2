package org.example;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    //Métodos de escrita
    public void escrever(Aluno aluno) {
        // Instanciando os objetos que permitirão a escrita de dados
        OutputStream os = null; // fluxo de entrada
        OutputStreamWriter osw = null; //leitor de fluxo de entrada
        BufferedWriter bw = null; //buffer entrada

        // Variável auxiliar
        String linha;

        try {
            // Abrindo a saída de dados
            os = new FileOutputStream("Alunos.txt", true); // Nome do arquivo onde será salvo
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flag que indica onde começa as informações do aluno
            bw.write("-- Aluno --\n");
            bw.write(aluno.getNome() + "\n");
            bw.write(aluno.getMatricula() + "\n");
            bw.write(aluno.getCurso() + "\n");
            bw.write(aluno.getMedia() + "\n");

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        } finally {
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    //Método ler
    public ArrayList<Aluno> ler() {

        // ArrayList auxiliar para salvar os alunos encontrados no arquivo
        ArrayList<Aluno> encontreiNoArquivo = new ArrayList<>();

        // Classes que permitem leitura de dados do arquivo
        InputStream is = null; //fluxo saida
        InputStreamReader isr = null; //gerador de fluxo de saida
        BufferedReader br = null; // buffer de saida

        // Variável auxiliar que servirá de flag para o while
        String linhaLer;

        try {
            // Instanciando os objetos
            is = new FileInputStream("Alunos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            linhaLer = br.readLine();

            while (linhaLer != null) {
                // Comparando se o que está em linhaLer é igual a minha flag
                if (linhaLer.contains("-- Aluno --")) {
                    // Variável auxiliar de alunos
                    Aluno aluno = new Aluno();
                    aluno.setNome(br.readLine());
                    aluno.setMatricula(Integer.parseInt(br.readLine()));
                    aluno.setCurso(br.readLine());
                    aluno.setMedia(Float.parseFloat(br.readLine()));

                    // Adicionando o aluno no array
                    encontreiNoArquivo.add(aluno);
                }
                linhaLer = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado: " + e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        return encontreiNoArquivo;
    }
}