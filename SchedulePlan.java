package prereqchecker;

import java.util.*;

public class SchedulePlan {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println("Execute: java -cp bin prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
            return;
        }
        HashMap<String, LinkedList<String>> map = AdjList.createMap(args[0]);
        ArrayList<String> coursesTaken = new ArrayList<String>(), needToTake = new ArrayList<String>(), eligibleCourses = new ArrayList<String>();
        ArrayList<ArrayList<String>> coursePlan = new ArrayList<ArrayList<String>>();
        StdIn.setFile(args[1]);
        StdOut.setFile(args[2]);
        String target = StdIn.readString();
        StdIn.readLine();
        int e = StdIn.readInt(), sem = 0;
        StdIn.readLine();
        for (int i = 0; i < e; i++) {
            Eligible.addCourses(map, coursesTaken, StdIn.readString());
            StdIn.readLine();
        }
        for (String req : map.get(target))
            NeedToTake.addCourses(map, needToTake, coursesTaken, req);
        while (true) {
            for (Map.Entry<String,LinkedList<String>> set : map.entrySet()) {
                if (coursesTaken.containsAll(set.getValue()) && !coursesTaken.contains(set.getKey()))
                    eligibleCourses.add(set.getKey());
            }
            if (eligibleCourses.contains(target))
                break;
            for (String c : eligibleCourses) {
                if (needToTake.contains(c)) {
                    if (coursePlan.size() <= sem)
                        coursePlan.add(new ArrayList<String>());
                    coursePlan.get(sem).add(c);
                    coursesTaken.add(c);
                    needToTake.remove(c);
                }
            }
            sem++;
        }
        StdOut.println(coursePlan.size());
        for (ArrayList<String> semester : coursePlan) {
            for (String course : semester)
                StdOut.print(course + " ");
            StdOut.println();
        }
    }
}
