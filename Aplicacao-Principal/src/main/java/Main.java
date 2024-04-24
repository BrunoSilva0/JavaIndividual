import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Criptografia cripto = new Criptografia();
        String senha = "";
        Boolean senhaValida = false;

        while (!senhaValida){
            System.out.println("Digite sua senha:");
            senha = leitor.nextLine();

            if (senha.contains(" ")) {
                System.out.println("Senha não pode conter espaços");
            } else if (!senha.contains(" ")){
                senhaValida = true;
            }
        }

        String senhaCriptografada = cripto.criptografarSenha(senha);
        System.out.println("Senha criptografada: " + senhaCriptografada);

        System.out.println("Digite sua senha novamente para autenticação:");
        String senhaParaAutenticar = leitor.next();
        Boolean autenticacao = cripto.autenticarSenha(senhaParaAutenticar);

        if (autenticacao) {
            System.out.println("Autenticação bem-sucedida!");
        } else {
            System.out.println("Autenticação falhou!");
        }
    }
}
