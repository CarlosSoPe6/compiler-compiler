package mx.jcc.syntax;

import mx.jcc.lexer.Lexer;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    static public void main(String argv[]) {
        try {
            String url = Main.class.getClassLoader().getResource("input.txt").getFile();
            FileReader fr = new FileReader(url);

            parser p = new parser(new Lexer(fr));
            Object result = p.parse().value;
            Map<String, List<List<Variable>>> map = p.getActions().valueTable;
            for (Map.Entry<String, List<List<Variable>>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue().toArray()));
            }
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
