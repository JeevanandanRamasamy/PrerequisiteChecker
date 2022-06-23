package prereqchecker;

import java.util.*;

public class Eligible {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }
        HashMap<String, LinkedList<String>> map = AdjList.createMap(args[0]);
        ArrayList<String> coursesTaken = new ArrayList<String>();
        StdIn.setFile(args[1]);
        StdOut.setFile(args[2]);
        int c = StdIn.readInt();
        StdIn.readLine();
        for (int i = 0; i < c; i++) {
            addCourses(map, coursesTaken, StdIn.readString());
            StdIn.readLine();
        }
        for (Map.Entry<String,LinkedList<String>> set : map.entrySet()) {
            if (coursesTaken.containsAll(set.getValue()) && !coursesTaken.contains(set.getKey()))
                StdOut.println(set.getKey());
        }
    }

    /**
    * Adds the course to the list of courses taken if the course is not already in the list.
    * This method also checks and adds the prerequisites of the courses.
    * 
    * @param map is the HashMap representing the adjacency list
    * @param list is the list of courses already taken
    * @param course is the course that is taken
    */
    public static void addCourses(HashMap<String, LinkedList<String>> map, ArrayList<String> list, String course) {
        if (!list.contains(course))
            list.add(course);
        for (String c : map.get(course))
            addCourses(map, list, c);
    }
}
