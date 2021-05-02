package mx.jcc.syntax;

import java.io.File;
import java.io.IOException;

import java_cup.internal_error;

public class GenerateParser {
    public static final String path ="jcc.cup";

    public static void main(String[] args) {
        generarLexer(path);
    }

    public static void generarLexer(String path) {
        String url = GenerateParser.class.getClassLoader().getResource(path).getFile();
        System.out.println(url);
        File file = new File(url);
        // jflex.Main.generate(file);
        String[] st = new String[1];
        st[0] = url;
        try {
            java_cup.Main.main(st);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
