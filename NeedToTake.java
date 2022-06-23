package prereqchecker;

import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class NeedToTake {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
            return;
        }
        HashMap<String, LinkedList<String>> map = AdjList.createMap(args[0]);
        ArrayList<String> coursesTaken = new ArrayList<String>(), needToTake = new ArrayList<String>();
        StdIn.setFile(args[1]);
        StdOut.setFile(args[2]);
        String course = StdIn.readString();
        StdIn.readLine();
        int d = StdIn.readInt();
        StdIn.readLine();
        for (int i = 0; i < d; i++) {
            Eligible.addCourses(map, coursesTaken, StdIn.readString());
            StdIn.readLine();
        }
        for (String req : map.get(course))
            addCourses(map, needToTake, coursesTaken, req);
        for (String c : needToTake)
            StdOut.println(c);
    }

    /**
    * Adds the course to list 1 of courses if the course is not in list 1 and list 2. This method
    * also checks and adds the prerequisites of the courses.
    *
    * @param map is the HashMap representing the adjacency list
    * @param list is the list of courses already taken
    * @param course is the course that is taken
    */
    public static void addCourses(HashMap<String, LinkedList<String>> map, ArrayList<String> list1, ArrayList<String> list2, String course) {
        if (!list1.contains(course) && !list2.contains(course))
            list1.add(course);
        for (String c : map.get(course))
            addCourses(map, list1, list2, c);
    }
}
