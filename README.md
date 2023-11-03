# smart_scheduler

OBJECTIVE:
                     The main objective of this program is to ease up the problem of creating a Schedule. This program basically asks for names for two Excel files, one for classrooms (which will remain constant throughout the schedule) and professors with the courses, the capacity of courses, and the availability time of professors. Based on these inputs our program generates an Excel File with classes scheduled in the suitable room for that course and the availability timings of the professor.

METHODOLOGY:
                               We used a constraint-satisfaction problem to solve this. We took classrooms as input and timeslots were hardcoded. Based on classrooms and time slots we generated a search space a random connected graph with classroom, timeslots, and Day set. Now every professor will be iterated and then the courses that the professor is teaching will be iterated and finally the available timeslots will be iterated. Before assigning a course, we ran DFS on the graph and checked all the constraints. If the constraints are not satisfied, we will backtrack to find a suitable time slot and classroom for the professor. The major constraints checked were:
1.	If the number of courses offered by a professor is more than the available timeslots, then it’s not possible to assign all courses to that professor so we’ll iterate.
2.	If the Capacity of the course and classrooms are almost equal and not differing more than 10 extra spaces, we’ll select that classroom, or else we’ll backtrack to another vertex.
3.	We will check if the professor is available at that time slot or not.
4.	If the vertex is available or not.


RESULTS/EVALUATION:
Program is Assigning Classes and Classrooms efficiently we have tried it with the data of almost 75 professors teaching around 82 courses in total which are being assigned efficiently to their respective classrooms with compatible course capacity and availability of professors and the classrooms were 25 of variable capacity.

LIMITATIONS:

The efficiency of the generation of the schedule will drop if the classrooms are very less compared to professors and available timings of professors.


FUTURE DIRECTIONS: 
We are planning to improve the GUI of this project.
Planning to add more constraints is a little harder constraint to deal with. (Like checking prerequisites and requisites of a course or checking if a certain limit of courses of a curriculum is assigned to a specific timeslot).

										
												
HOW TO RUN
1.	Open the Java project on your IDE.
2.	Import the required Libraries:
•	import org.apache.poi.ss.usermodel.Row;
•	import org.apache.poi.ss.usermodel.Sheet;
•	import org.apache.poi.ss.usermodel.Workbook;
•	import org.apache.poi.ss.usermodel.WorkbookFactory;
•	import org.jgrapht.Graph;
•	import org.jgrapht.graph.DefaultEdge;
•	import org.jgrapht.graph.SimpleGraph;
•	import org.jgrapht.traverse.DepthFirstIterator;
•	import java.io.FileInputStream;
•	import java.io.IOException;
•	import java.util.ArrayList;
•	import java.util.Arrays;
•	import java.util.Collections;
•	import java.util.List;
•	import javax.swing.*;
•	import java.awt.*;
•	import java.awt.event.ActionEvent;
•	import java.awt.event.ActionListener;
•	import java.io.IOException;
3.	Go to GUI class in the Project.
4.	Build and Run the Project.
5.	A GUI popup will appear.
6.	Enter the name of the Excel files having classrooms and professors in their respective text fields. (Make sure that the format of the name of the file should be like this “xyz.xlsx”)
7.	Both the Excel Files and the professor file should be in the project folder (Initially I have attached one).
8.	Click the button Generate Schedule to run. 
9.	Excel file will be created and saved on your desktop with the name “Generated Schedule”.
FORMATTING EXCEL FILE

File for Professors:

Professor Name, Courses, Course Capacity, Time Slots
Faisal Iradat	        DLD, DM	40,50,		8:30,10:00,11:30,

Faisal Iradat is teaching two courses DLD and DM. The capacity of students that can enroll is 40 and 50 respectively. The available timeslot is 8:30,10:00,11:30,

File for Classrooms:
 Classroom, Capacity
          MTS1	   40

Classroom No is MTS1 with a capacity of accommodating 40 students.
