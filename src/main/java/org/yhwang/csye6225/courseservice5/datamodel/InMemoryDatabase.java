package org.yhwang.csye6225.courseservice5.datamodel;

import org.yhwang.csye6225.courseservice5.service.CoursesService;

import java.util.*;

public class InMemoryDatabase {

    private static InMemoryDatabase inMemoryDatabase;

    public static InMemoryDatabase getInstance() {
        if (inMemoryDatabase == null) {
            inMemoryDatabase = new InMemoryDatabase();
        }
        return inMemoryDatabase;
    }
    private static HashMap<Long, Professor> professorDB = new HashMap<>();
    private static HashMap<Long, Student> studentDB = new HashMap<>();
    private static HashMap<String, Course> courseDB = new HashMap<>();
    private static HashMap<Long, Program> programDB = new HashMap<>();
    private static HashMap<Long, Lecture> lectureDB = new HashMap<>();

    public InMemoryDatabase() {
        //"csye6225" "Network Structure and Cloud Computing"
        Lecture cloudl1 = new Lecture(6225001L, "Introduction");
        Lecture cloudl2 = new Lecture(6225002L, "Key Amazon offerings");
        Lecture cloudl3 = new Lecture(6225003L, "Bundling Amazon instances");
        Lecture cloudl4 = new Lecture(6225004L, "Amazon's Elastic Block Storage (EBS)");
        Lecture cloudl5 = new Lecture(6225005L, "Amazon's AWS Identity Management and Security in the Cloud");
        Lecture cloudl6 = new Lecture(6225006L, "Amazon's Virtual Private Cloud (VPC) and Directory Service");
        Lecture cloudl7 = new Lecture(6225007L, "KJava AWS SDK, S3 API, Relational Database Service, SimlpeDB Service , NoSQL Databases");
        lectureDB().put(6225001L, cloudl1);
        lectureDB().put(6225002L, cloudl2);
        lectureDB().put(6225003L, cloudl3);
        lectureDB().put(6225004L, cloudl4);
        lectureDB().put(6225005L, cloudl5);
        lectureDB().put(6225006L, cloudl6);
        lectureDB().put(6225007L, cloudl7);

        //"csye7245", "Big-Data Systems and Intelligence Analytics"
        Lecture bigDatal1 = new Lecture(7245001L, "Basic Statistics and R");
        Lecture bigDatal2 = new Lecture(7245002L, "Relationships and Representations, Graph Databases");
        Lecture bigDatal3 = new Lecture(7245003L, "Introduction to Spark 2.0");
        Lecture bigDatal4 = new Lecture(7245004L, "Language processing with Spark 2.0");
        Lecture bigDatal5 = new Lecture(7245005L, "Analysis of Streaming Data with Spark 2.0");
        Lecture bigDatal6 = new Lecture(7245006L, "Applications of Spark ML Library");
        Lecture bigDatal7 = new Lecture(7245007L, "Basic Neural Network and Tensor Flow");
        lectureDB().put(7245001L, bigDatal1);
        lectureDB().put(7245002L, bigDatal2);
        lectureDB().put(7245003L, bigDatal3);
        lectureDB().put(7245004L, bigDatal4);
        lectureDB().put(7245005L, bigDatal5);
        lectureDB().put(7245006L, bigDatal6);
        lectureDB().put(7245007L, bigDatal7);

        //"csye6230", "Operating Systems"
        Lecture OSl1 = new Lecture(6230001L, "Overview of operating systems, functionalities and charateristics of OS");
        Lecture OSl2 = new Lecture(6230002L, "Hardware concepts related to OS, CPU states, I/O channels, memory hierarchy, microprogramming");
        Lecture OSl3 = new Lecture(6230003L, "The concept of a process, operations on processes, process states, concurrent processes, process control block, process context.");
        Lecture OSl4 = new Lecture(6230004L, "UNIX process control and management, PCB, signals, forks and pipes.");
        Lecture OSl5 = new Lecture(6230005L, "Interrupt processing, operating system organisation, OS kernel FLIH, dispatcher.");
        Lecture OSl6 = new Lecture(6230006L, "Job and processor scheduling, scheduling algorithms, process hierarchies.");
        Lecture OSl7 = new Lecture(6230007L, "Problems of concurrent processes, critical sections, mutual exclusion, synchronisation, deadlock.");
        lectureDB().put(6230001L, OSl1);
        lectureDB().put(6230002L, OSl2);
        lectureDB().put(6230003L, OSl3);
        lectureDB().put(6230004L, OSl4);
        lectureDB().put(6230005L, OSl5);
        lectureDB().put(6230006L, OSl6);
        lectureDB().put(6230007L, OSl7);

        //"info5100","Application Engineering and Development"
        Lecture javal1 = new Lecture(5100001L,"Introduction to JAVA");
        Lecture javal2 = new Lecture(5100002L,"Arithmetic, logic and relation operators");
        Lecture javal3 = new Lecture(5100003L,"Switch statement");
        Lecture javal4 = new Lecture(5100004L,"Operations with arrays");
        Lecture javal5 = new Lecture(5100005L,"Introduction to Classes, objects and methods");
        Lecture javal6 = new Lecture(5100006L,"Introduction to modular programming");
        Lecture javal7 = new Lecture(5100007L,"Recursion");
        lectureDB().put(5100001L, javal1);
        lectureDB().put(5100002L, javal2);
        lectureDB().put(5100003L, javal3);
        lectureDB().put(5100004L, javal4);
        lectureDB().put(5100005L, javal5);
        lectureDB().put(5100006L, javal6);
        lectureDB().put(5100007L, javal7);

        //"info6150", "Web Design and User Experience Engineering"
        Lecture webDesignl1 = new Lecture(6105001L,"Introduction, Syllabus, Calendar");
        Lecture webDesignl2 = new Lecture(6105002L,"Terminology, Starting a Website");
        Lecture webDesignl3 = new Lecture(6105003L,"HTML Coding, Wireframe");
        Lecture webDesignl4 = new Lecture(6105004L,"FTP, Basics of CSS Coding");
        Lecture webDesignl5 = new Lecture(6105005L,"CSS Coding, Internal CSS");
        Lecture webDesignl6 = new Lecture(6105006L,"Website Layouts");
        Lecture webDesignl7 = new Lecture(6105007L,"Photoshop, Image Slicing");
        lectureDB().put(6105001L, webDesignl1);
        lectureDB().put(6105002L, webDesignl2);
        lectureDB().put(6105003L, webDesignl3);
        lectureDB().put(6105004L, webDesignl4);
        lectureDB().put(6105005L, webDesignl5);
        lectureDB().put(6105006L, webDesignl6);
        lectureDB().put(6105007L, webDesignl7);

        //"info6205", "Program Structure and Algorithms"
        Lecture algol1 = new Lecture(5100001L, "Introduction");
        Lecture algol2 = new Lecture(5100002L, "Recurrences");
        Lecture algol3 = new Lecture(5100003L, "Divide-and-Conquer");
        Lecture algol4 = new Lecture(5100004L, "Quicksort, Randomized Algorithms");
        Lecture algol5 = new Lecture(5100005L, "Linear-time Sorting: Lower Bounds, Counting Sort, Radix Sort");
        Lecture algol6 = new Lecture(5100006L, "Bucketsort");
        Lecture algol7 = new Lecture(5100007L, "Universal Hashing, Perfect Hashing");
        lectureDB().put(5100001L, algol1);
        lectureDB().put(5100002L, algol2);
        lectureDB().put(5100003L, algol3);
        lectureDB().put(5100004L, algol4);
        lectureDB().put(5100005L, algol5);
        lectureDB().put(5100006L, algol6);
        lectureDB().put(5100007L, algol7);

        //"info6210", "Data Management and Database Design
        Lecture databasel1 = new Lecture(6210001L, "introduction; database design and ER models");
        Lecture databasel2 = new Lecture(6210002L, "the relational model, relational algebra and SQL");
        Lecture databasel3 = new Lecture(6210003L, "storage and indexing");
        Lecture databasel4 = new Lecture(6210004L, "transactions");
        Lecture databasel5 = new Lecture(6210005L, "recovery and logging");
        Lecture databasel6 = new Lecture(6210006L, "semistructured data and XML");
        Lecture databasel7 = new Lecture(6210007L, "distributed databases and replication");
        lectureDB().put(6210001L, databasel1);
        lectureDB().put(6210002L, databasel2);
        lectureDB().put(6210003L, databasel3);
        lectureDB().put(6210004L, databasel4);
        lectureDB().put(6210005L, databasel5);
        lectureDB().put(6210006L, databasel6);
        lectureDB().put(6210007L, databasel7);

        //"info6215", "Business Analysis and Information Engineering"
        Lecture BIl1 = new Lecture(6215001L, "What is Business Analysis");
        Lecture BIl2 = new Lecture(6215002L, "The Roles and Functions of the Business Analyst");
        Lecture BIl3 = new Lecture(6215003L, "Business Analysis Key Concepts");
        Lecture BIl4 = new Lecture(6215004L, "Defining Stakeholders");
        Lecture BIl5 = new Lecture(6215005L, "Defining the Business Need");
        Lecture BIl6 = new Lecture(6215006L, "Understanding Requirements L");
        Lecture BIl7 = new Lecture(6215007L, "Business Analysis Knowledge Areas");
        lectureDB().put(6215001L, BIl1);
        lectureDB().put(6215002L, BIl2);
        lectureDB().put(6215003L, BIl3);
        lectureDB().put(6215004L, BIl4);
        lectureDB().put(6215005L, BIl5);
        lectureDB().put(6215006L, BIl6);
        lectureDB().put(6215007L, BIl7);

        //"cs1100", "Computer Science and Its Applications"
        Lecture csl1 = new Lecture(1100001L, "INTRODUCTION");
        Lecture csl2 = new Lecture(1100002L, "CORE ELEMENTS OF A PROGRAM");
        Lecture csl3 = new Lecture(1100003L, "PROBLEM SOLVING");
        Lecture csl4 = new Lecture(1100004L, "MACHINE INTERPRETATION OF A PROGRAM");
        Lecture csl5 = new Lecture(1100005L, "OBJECTS IN PYTHON");
        Lecture csl6 = new Lecture(1100006L, "OBJECTS IN PYTHON");
        Lecture csl7 = new Lecture(1100007L, "DEBUGGING");
        lectureDB().put(1100001L, csl1);
        lectureDB().put(1100002L, csl2);
        lectureDB().put(1100003L, csl3);
        lectureDB().put(1100004L, csl4);
        lectureDB().put(1100005L, csl5);
        lectureDB().put(1100006L, csl6);
        lectureDB().put(1100007L, csl7);

        //"cs1200", "Leadership Skill Development"
        Lecture leadershipl1 = new Lecture(1200001L, "Personal leadership and leadership styles");
        Lecture leadershipl2 = new Lecture(1200002L, "Learning and learning to learn");
        Lecture leadershipl3 = new Lecture(1200003L, "Leadership of change");
        Lecture leadershipl4 = new Lecture(1200004L, "Appreciative inquiry and Appreciative leadership");
        Lecture leadershipl5 = new Lecture(1200005L, "People’s reactions to change");
        Lecture leadershipl6 = new Lecture(1200006L, "Coaching skills");
        Lecture leadershipl7 = new Lecture(1200007L, "Leadership in groups: building and leading efficient teams");
        lectureDB().put(1200001L, leadershipl1);
        lectureDB().put(1200002L, leadershipl2);
        lectureDB().put(1200003L, leadershipl3);
        lectureDB().put(1200004L, leadershipl4);
        lectureDB().put(1200005L, leadershipl5);
        lectureDB().put(1200006L, leadershipl6);
        lectureDB().put(1200007L, leadershipl7);

        //"cs1800", "Discrete Structures"
        Lecture disstrl1 = new Lecture(1800001L, "Logic: propositional logic, logical equivalence, predicates & quantifiers, and logical reasoning");
        Lecture disstrl2 = new Lecture(1800002L, "Sets: basics, set operations");
        Lecture disstrl3 = new Lecture(1800003L, "Functions: one-to-one, onto, inverse, composition, graphs");
        Lecture disstrl4 = new Lecture(1800004L, "Integers: greatest common divisor, Euclidean algorithm. ");
        Lecture disstrl5 = new Lecture(1800005L, "Sequences and Summations ");
        Lecture disstrl6 = new Lecture(1800006L, "Mathematical reasoning and induction: Proof strategies, Mathematical Induction, Recursive ");
        Lecture disstrl7 = new Lecture(1800007L, "Counting: basic rules, Pigeonhole principle, Permutations and Combinations, Binomial ");
        lectureDB().put(1800001L, disstrl1);
        lectureDB().put(1800002L, disstrl2);
        lectureDB().put(1800003L, disstrl3);
        lectureDB().put(1800004L, disstrl4);
        lectureDB().put(1800005L, disstrl5);
        lectureDB().put(1800006L, disstrl6);
        lectureDB().put(1800007L, disstrl7);

        //"cs3500", "Object-Oriented Design"
        Lecture OODl1 = new Lecture(3500001L, "Introduction");
        Lecture OODl2 = new Lecture(3500002L, "Welcome to Software Design and Architecture");
        Lecture OODl3 = new Lecture(3500003L, "Software Architect and Design Roles in Industry");
        Lecture OODl4 = new Lecture(3500004L, "Object-Oriented Modeling");
        Lecture OODl5 = new Lecture(3500005L, "Software Requirements, Conceptual and Technical Designs");
        Lecture OODl6 = new Lecture(3500006L, "Competing Qualities and Trade-off");
        Lecture OODl7 = new Lecture(3500007L, "Record, Organize, and Refine Components");
        lectureDB().put(3500001L, OODl1);
        lectureDB().put(3500002L, OODl2);
        lectureDB().put(3500003L, OODl3);
        lectureDB().put(3500004L, OODl4);
        lectureDB().put(3500005L, OODl5);
        lectureDB().put(3500006L, OODl6);
        lectureDB().put(3500007L, OODl7);

        Course c1 = new Course("csye6225", "Network Structure and Cloud Computing");
        Course c2 = new Course("csye7245", "Big-Data Systems and Intelligence Analytics");
        Course c3 = new Course("csye6230", "Operating Systems");
        c1.setLectures(Arrays.asList(cloudl1, cloudl2, cloudl3, cloudl4, cloudl5, cloudl6, cloudl7));
        c2.setLectures(Arrays.asList(bigDatal1, bigDatal2, bigDatal3, bigDatal4, bigDatal5, bigDatal6, bigDatal7));
        c3.setLectures(Arrays.asList(OSl1, OSl2, OSl3, OSl4, OSl5, OSl6, OSl7));
        courseDB.put("csye6225", c1);
        courseDB.put("csye7245", c2);
        courseDB.put("csye6230", c3);
        Program csye = new Program(6000L, "Computer Systems Engineering", Arrays.asList(c1,c2,c3));
        programDB().put(6000L, csye);

        Course s1 = new Course("info5100","Application Engineering and Development");
        Course s2 = new Course("info6150", "Web Design and User Experience Engineering");
        Course s3 = new Course("info6205", "Program Structure and Algorithms");
        Course s4 = new Course("info6210", "Data Management and Database Design");
        Course s5 = new Course("info6215", "Business Analysis and Information Engineering");
        s1.setLectures(Arrays.asList(javal1, javal2, javal3, javal4, javal5, javal6, javal7));
        s2.setLectures(Arrays.asList(webDesignl1, webDesignl2, webDesignl3, webDesignl4, webDesignl5, webDesignl6, webDesignl7));
        s3.setLectures(Arrays.asList(algol1, algol2, algol3, algol4, algol5, algol6, algol7));
        s4.setLectures(Arrays.asList(databasel1, databasel2, databasel3, databasel4, databasel5, databasel6, databasel7));
        s5.setLectures(Arrays.asList(BIl1, BIl2, BIl3, BIl4, BIl5, BIl6, BIl7));
        courseDB.put("info5100", s1);
        courseDB.put("info6150", s2);
        courseDB.put("info6205", s3);
        courseDB.put("info6210", s4);
        courseDB.put("info6215", s5);
        Program info = new Program(5000L, "Infomation Systems", Arrays.asList(s1, s2, s3, s4, s5));
        programDB().put(5000L, info);

        Course r1 = new Course("cs1100", "Computer Science and Its Applications");
        Course r2 = new Course("cs1200", "Leadership Skill Development");
        Course r3 = new Course("cs1800", "Discrete Structures");
        Course r4 = new Course("cs3500", "Object-Oriented Design");
        r1.setLectures(Arrays.asList(csl1, csl2, csl3, csl4, csl5, csl6, csl7));
        r2.setLectures(Arrays.asList(leadershipl1, leadershipl2, leadershipl3, leadershipl4, leadershipl5, leadershipl6, leadershipl7));
        r3.setLectures(Arrays.asList(disstrl1, disstrl2, disstrl3, disstrl4, disstrl5, disstrl6, disstrl7));
        r4.setLectures(Arrays.asList(OODl1, OODl2, OODl3, OODl4, OODl5, OODl6, OODl7));
        courseDB.put("cs1100", r1);
        courseDB.put("cs1200", r2);
        courseDB.put("cs1800", r3);
        courseDB.put("cs3500", r4);
        Program CS = new Program(1000L, "Computer Science", Arrays.asList(r1,r2,r3,r4));
        programDB().put(1000L, CS);

        Student student1 = new Student("Ciera", 1000L,"Computer Systems Engineering");
        student1.setCourses(Arrays.asList(c1, c2));
        Student student2 = new Student("John",1001L, "Computer Systems Engineering");
        student2.setCourses(Arrays.asList(c2, c3));
        Student student3 = new Student("Bob", 1002L,"Infomation Systems");
        student3.setCourses(Arrays.asList(s1, s2, s3));
        Student student4 = new Student("Jason", 1003L, "Infomation Systems");
        student4.setCourses(Arrays.asList(s4, s5));
        Student student5 = new Student("Alex",1004L, "Computer Science");
        student5.setCourses(Arrays.asList(r1, r4));
        Student student6 = new Student("Josh",1005L, "Computer Science");
        student6.setCourses(Arrays.asList(r2, r3));
        studentDB.put(1000L, student1);
        studentDB.put(1001L, student2);
        studentDB.put(1002L, student3);
        studentDB.put(1003L, student4);
        studentDB.put(1004L, student5);
        studentDB.put(1005L, student6);

        Professor professor1 = new Professor("Computer Systems Engineering", 2046L, new Date(), "Lazy", Arrays.asList(c1,c2));
        Professor professor2 = new Professor("Computer Systems Engineering", 2047L, new Date(), "Winnie", Arrays.asList(c3));
        Professor professor3 = new Professor("Infomation Systems", 2048L, new Date(), "Pool", Arrays.asList(s1,s2));
        Professor professor4 = new Professor("Infomation Systems", 2049L, new Date(), "Rabbit", Arrays.asList(s3));
        Professor professor5 = new Professor("Infomation Systems", 2050L, new Date(), "Yalin", Arrays.asList(s4));
        Professor professor6 = new Professor("Infomation Systems", 2051L, new Date(), "Lem", Arrays.asList(s5));
        Professor professor7 = new Professor("Computer Science", 2052L, new Date(), "Sierra", Arrays.asList(r1));
        Professor professor8 = new Professor("Computer Science", 2053L, new Date(), "Ping", Arrays.asList(r2));
        Professor professor9 = new Professor("Computer Science", 2054L, new Date(), "Jing", Arrays.asList(r3));
        Professor professor10 = new Professor("Computer Science", 2055L, new Date(), "Salesforce", Arrays.asList(r4));
        professorDB.put(2046L, professor1);
        professorDB.put(2047L, professor2);
        professorDB.put(2048L, professor3);
        professorDB.put(2049L, professor4);
        professorDB.put(2050L, professor5);
        professorDB.put(2051L, professor6);
        professorDB.put(2052L, professor7);
        professorDB.put(2053L, professor8);
        professorDB.put(2054L, professor9);
        professorDB.put(2055L, professor10);

    }

    public HashMap<Long, Professor> getProfessorDB() {
        return professorDB;
    }

    public HashMap<Long, Student> getStudentDB() {
        return studentDB;
    }

    public HashMap<String, Course> getCourseDB() {
        return courseDB;
    }

    public HashMap<Long, Program> programDB() { return programDB; }

    public HashMap<Long, Lecture> lectureDB() { return lectureDB; }
}
