package com.squad2.accenture.model;

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioNormal extends Usuario{
    public UsuarioNormal() {
    }

    public UsuarioNormal(String nome, String sobrenome, String email, LocalDate dataNascimento) {
        super(nome, sobrenome, email, dataNascimento);
    }

    @Override
    public UsuarioNormal cadastrarUsuario(String nome, String sobrenome, String email) {
        UsuarioNormal normal = new UsuarioNormal();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        normal.setNome(sc.nextLine());
        System.out.println("Digite seu sobrenome: ");
        normal.setSobrenome(sc.nextLine());
        System.out.println("Digite seu email: ");
        normal.setEmail(sc.nextLine());
        System.out.println("Digite sua senha: ");
        normal.setSenha(sc.nextLine());
        System.out.println("Confirme sua senha: ");
        String senhaTmp = sc.nextLine();

        if (!senhaTmp.equals(normal.getSenha())){
            System.err.println("Senhas não conferem! Reinicie o processo. ");
        }

        return normal;
    }
}
