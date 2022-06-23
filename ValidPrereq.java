package prereqchecker;

import java.util.*;

public class ValidPrereq {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }
        HashMap<String, LinkedList<String>> map = AdjList.createMap(args[0]);
        StdIn.setFile(args[1]);
        String course1 = StdIn.readString();
        StdIn.readLine();
        String course2 = StdIn.readString();
        StdOut.setFile(args[2]);
        if (traverseMap(map, course1, course2))
            StdOut.print("YES");
        else
            StdOut.print("NO");
    }

    /**
    * Visits all sets in the map and checks if course 1 can be taken if course 2 was
    * added as a requirement to course 1.
    *
    * @param map is the HashMap representing the adjacency list
    * @param course1 is the course being checked
    * @param course2 is the course being added as a requirement
    * @return boolean representing whether or not course 1 can be taken if course 2 was
    * added as a requirement to course 1
    */
    private static boolean traverseMap(HashMap<String, LinkedList<String>> map, String course1, String course2) {
        if (map.get(course2).contains(course1))
            return false;
        while (map.get(course2).size() > 0) {
            if (!traverseMap(map, course1, map.get(course2).removeFirst()))
                return false;
        }
        return true;
    }
}
