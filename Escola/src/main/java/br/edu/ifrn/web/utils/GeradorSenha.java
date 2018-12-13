/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.utils;

import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author beatriz
 */
public class GeradorSenha {
    public static void main(String[] args) {
        System.out.println(gerador("12345")); 
    }

    public static String gerador(String senhaTexto) {
        try {
            byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());                                 
            return Base64.getEncoder().encodeToString(digest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
