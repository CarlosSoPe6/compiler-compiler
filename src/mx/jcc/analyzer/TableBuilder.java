package mx.jcc.analyzer;

import mx.jcc.analyzer.interfaces.ITableBuilder;
import mx.jcc.syntax.Variable;
import mx.jcc.syntax.VariableType;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;


public class TableBuilder implements ITableBuilder {

    public TableBuilder() {}

    private int findInsertionColumn(Map.Entry<Variable, Action> entry, int index, StringBuilder sb, List<String> sl) {
        // given a starting point on the terminals or non-terminals list
        // look on the whole remaining of the list (ordered lexicographically)
        // if the value of the Variable match any of the variable list
        // if it does append it and end the loop updating the starting point
        // if it doesn't insert white spaces to fill the gaps

        // this works because the elements of the tree and the list are ordered
        // so so if you didn't fill a place before, future entries won't fill it

        while(index < sl.size()) {
            if(entry.getKey().value.equals(sl.get(index))) {
                sb.append(entry.getValue().toString());
                break;
            } else {
                sb.append(", ");
            }
            index++;
        }
        return index;
    }

    @Override
    public void write(List<Map<Variable, Action>> automaton, List<Variable> terminals, List<Variable> nonTerminals) {
        // try with resources as fileWriter implements AutoClosable.
        try(FileWriter csvWriter = new FileWriter("Tabla LR.csv")) {
            // sorting to keep order on the table
            Collections.sort(terminals);
            Collections.sort(nonTerminals);

            // map Variable list into string list for better manipulation
            List<String> nonTerminalsStringList = nonTerminals.stream().map( e -> e.value).collect(Collectors.toList());
            List<String> terminalsStringList    = terminals.stream().map( e -> e.value).collect(Collectors.toList());

//            System.out.println(terminalsStringList);

            // write headers with terminal list
            csvWriter.append(" ,");
            csvWriter.append(String.join(", ", terminalsStringList));
            csvWriter.append(", ");
            csvWriter.append(String.join(", ", nonTerminalsStringList));
            csvWriter.append("\n");


            // for each map on the list, traverse it and fill the corresponding columns
            // with the action on the corresponding row, indexed by the list
            int index = 0;
            // go through all the rows
            for (Map<Variable, Action> state : automaton) {
                // create two string builders where the csv row is going to be stored
                StringBuilder termString = new StringBuilder(), nonTermString = new StringBuilder();

                // add the index to the row
                termString.append(index + ", ");

                int termIndex = 0;
                int nonTermIndex = 0;
                // iterate over the map and add each action to the corresponding column
                for (Map.Entry<Variable, Action> entry :  state.entrySet()) {

                    if (entry.getKey().type == VariableType.TERMINAL) {
                        // search where in the terminal list the key fits
                        // to build the comma separated string, fill the values that don't match
                        // with empty space
//                        System.out.println(termIndex);
                        termIndex = findInsertionColumn(entry, termIndex, termString, terminalsStringList);

                    } else if(entry.getKey().type == VariableType.NON_TERMINAL){
                        // search where in the non-terminal list the key fits
                        nonTermIndex = findInsertionColumn(entry, nonTermIndex, nonTermString, nonTerminalsStringList);

                    } else if(entry.getKey().type == VariableType.EOF) {
                        termString.insert(2, entry.getValue().toString());
                    }

                }

                // fill with blanks the terminals string, to have padding between
                // the end of this string and the start of the non-terminals
                while(termIndex < terminalsStringList.size()) {
                    termString.append(", ");
                    termIndex++;
                }
                // put together terminal and non-terminal string
                termString.append(nonTermString).append("\n");
//                System.out.println(termString);
                csvWriter.append(termString);
                index++;
            }

            csvWriter.flush();

        } catch (IOException e) {
            System.err.println("There was problem trying to write csv file");
            e.printStackTrace();
        }
    }
}
