package mx.jcc.syntax;

import mx.jcc.analyzer.sets.FirstSet;
import mx.jcc.analyzer.sets.FollowSet;
import mx.jcc.lexer.Lexer;

import java.io.FileReader;
import java.util.*;

public class Main {
    static public void main(String argv[]) {
        try {
            String url = Main.class.getClassLoader().getResource("input.txt").getFile();
            FileReader fr = new FileReader(url);

            parser p = new parser(new Lexer(fr));
            Object result = p.parse().value;
            Map<Variable, List<List<Variable>>> map = p.getActions().valueTable;
            for (Map.Entry<Variable, List<List<Variable>>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue().toArray()));
            }

            FirstSet firstSetCalulator = new FirstSet();
            FollowSet followSetCalulator = new FollowSet();
            Map<Variable, Set<Variable>> firstSet = firstSetCalulator.computeSet(map, null);
            Map<Variable, Set<Variable>> followSet = followSetCalulator.computeSet(map, firstSet, p.getActions().initial);
            for (Map.Entry<Variable, Set<Variable>> entry : firstSet.entrySet()) {
                System.out.printf("%s, %s\n", entry.getKey().value, Arrays.toString(entry.getValue().toArray()));
            }
            System.out.println("FOLLOW");
            for (Map.Entry<Variable, Set<Variable>> entry : followSet.entrySet()) {
                System.out.printf("%s, %s\n", entry.getKey().value, Arrays.toString(entry.getValue().toArray()));
            }
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
