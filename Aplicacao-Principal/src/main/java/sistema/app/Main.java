package sistema.app;

//import sistema.database.model.*;
//import sistema.database.service.*;
//import sistema.database.template.TemplateMySQL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Criptografia criptografia = new Criptografia();

        System.out.println("Digite sua senha: ");
        String senha = leitor.nextLine();
        String senhaCripto = criptografia.criptografarSenha(senha);

        System.out.println("Confirme a senha:");
        String confirmacao = leitor.nextLine();

        System.out.println("Senha criptografada: " + senhaCripto);
        System.out.println("Segunda tentativa: " + confirmacao);

        boolean autenticacao = criptografia.autenticarSenha(confirmacao, senhaCripto);
        System.out.println("Autenticação: " + (autenticacao ? "Senha correta" : "Senha incorreta"));
    }
}