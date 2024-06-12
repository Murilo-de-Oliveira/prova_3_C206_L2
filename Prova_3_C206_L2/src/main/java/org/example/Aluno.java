package org.example;

public class Aluno implements Comparable<Aluno>{
    //Atributos
    private String Nome;
    private int Matricula;
    private String Curso;
    private float Media;

    //Getters e Setters
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public float getMedia() {
        return Media;
    }

    public void setMedia(float media) {
        Media = media;
    }

    //Implementação do compareTo
    @Override
    public int compareTo(Aluno o) {
        return Float.compare(this.getMedia(),o.getMedia()); //compara baseado na média
    }
}
