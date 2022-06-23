# PrerequisiteChecker

Programming Assignment 5 for Data Structures course

https://ds.cs.rutgers.edu/assignment-prereqchecker/

## Problem

There are tons of courses available in the Rutgers Computer Science program, many with prerequisites that need to be satisfied before they can be taken. It can get confusing to navigate what courses you need to take before other courses, and what courses are available to you given the courses you have already taken.

## Solution

Created a DAG (Directed Acyclic Graph) that represents the course prerequisite structure. Advanced courses point to requisite courses. This program finds the optimal course schedule by using BFS (Breadth-First Search). I also expanded this program to include all courses from the Statistics and Data Science programs since I am interested in those fields.
