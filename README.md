# PrerequisiteChecker

Programming Assignment 5 for the Data Structures course

[Assignment Link](https://ds.cs.rutgers.edu/assignment-prereqchecker/)

## Problem

Navigating the course prerequisites in the Rutgers Computer Science program (and related fields) can be challenging, especially when trying to determine which courses must be taken before others. This program helps students plan their academic path by identifying the necessary prerequisites and available courses based on their current coursework.

## Solution

Implemented a Directed Acyclic Graph (DAG) to model the relationships between courses and their prerequisites, where advanced courses point to required foundational courses. The program utilizes Breadth-First Search (BFS) to generate an optimal course schedule, ensuring students take prerequisites in the correct order. Additionally, I extended the program to include courses from the Statistics and Data Science programs, reflecting my personal interest in those fields.
