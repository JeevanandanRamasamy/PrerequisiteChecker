package prereqchecker;

import java.util.*;

public class AdjList {
    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }
        HashMap<String, LinkedList<String>> map = createMap(args[0]);
        StdOut.setFile(args[1]);
        for (String course : map.keySet()) {
            StdOut.print(course + " ");
            while (map.get(course).size() != 0)
                StdOut.print(map.get(course).removeFirst() + " ");
            StdOut.println();
        }
    }

    /**
    * Creates and returns a HashMap representing the input adjacency list
    * file. The HashMap has keys of type String and values that are
    * LinkedLists of Strings.
    *
    * @param file is the input adjacency list file's name
    * @return map is the HashMap representing the adjacency list
    */
    public static HashMap<String, LinkedList<String>> createMap(String file) {
        StdIn.setFile(file);
        int a = StdIn.readInt();
        StdIn.readLine();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            map.put(StdIn.readString(), new LinkedList<String>());
            StdIn.readLine();
        }
        int b = StdIn.readInt();
        StdIn.readLine();
        for (int i = 0; i < b; i++) {
            map.get(StdIn.readString()).add(StdIn.readString());
            StdIn.readLine();
        }
        return map;
    }
}
