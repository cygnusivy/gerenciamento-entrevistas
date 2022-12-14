package com.squad2.accenture.model;

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String nome, String sobrenome, String email, LocalDate dataNascimento) {
        super(nome, sobrenome, email, dataNascimento);
    }

    @Override
    public UsuarioAdmin cadastrarUsuario(String nome, String sobrenome, String email) {

        UsuarioAdmin admin = new UsuarioAdmin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        admin.setNome(sc.nextLine());
        System.out.println("Digite seu sobrenome: ");
        admin.setSobrenome(sc.nextLine());
        System.out.println("Digite seu email: ");
        admin.setEmail(sc.nextLine());
        System.out.println("Digite sua senha: ");
        admin.setSenha(sc.nextLine());
        System.out.println("Confirme sua senha: ");
        String senhaTmp = sc.nextLine();

        if (!senhaTmp.equals(admin.getSenha())){
            System.err.println("Senhas não conferem! Reinicie o processo. ");
        }

        return admin;
    }
}
