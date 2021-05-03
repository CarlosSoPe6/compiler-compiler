package mx.jcc.lexer;

import java.io.File;

public class GenerateLexer {

    public static final String path ="jcc.flex";

    public static void main(String[] args) {
        generarLexer(path);
    }

    public static void generarLexer(String path){
        String url = GenerateLexer.class.getClassLoader().getResource(path).getFile();
        System.out.println(url);
        File file = new File(url);
        jflex.Main.generate(file);
    }
}