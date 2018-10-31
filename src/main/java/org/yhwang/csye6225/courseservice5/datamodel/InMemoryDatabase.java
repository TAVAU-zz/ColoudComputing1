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
    private static HashMap<String, Professor> professorDB = new HashMap<>();
    private static HashMap<String, Student> studentDB = new HashMap<>();
    private static HashMap<String, Course> courseDB = new HashMap<>();
    private static HashMap<Long, Program> programDB = new HashMap<>();
    private static HashMap<String, Lecture> lectureDB = new HashMap<>();

    public InMemoryDatabase() {
        //"csye6225" "Network Structure and Cloud Computing"
        Lecture cloudl1 = new Lecture("6225001", "Introduction");
        Lecture cloudl2 = new Lecture("6225002", "Key Amazon offerings");
        Lecture cloudl3 = new Lecture("6225003", "Bundling Amazon instances");
        Lecture cloudl4 = new Lecture("6225004", "Amazon's Elastic Block Storage (EBS)");
        Lecture cloudl5 = new Lecture("6225005", "Amazon's AWS Identity Management and Security in the Cloud");
        Lecture cloudl6 = new Lecture("6225006", "Amazon's Virtual Private Cloud (VPC) and Directory Service");
        Lecture cloudl7 = new Lecture("6225007", "KJava AWS SDK, S3 API, Relational Database Service, SimlpeDB Service , NoSQL Databases");
        lectureDB().put("6225001", cloudl1);
        lectureDB().put("6225002", cloudl2);
        lectureDB().put("6225003", cloudl3);
        lectureDB().put("6225004", cloudl4);
        lectureDB().put("6225005", cloudl5);
        lectureDB().put("6225006", cloudl6);
        lectureDB().put("6225007", cloudl7);

        //"csye7245", "Big-Data Systems and Intelligence Analytics"
        Lecture bigDatal1 = new Lecture("7245001", "Basic Statistics and R");
        Lecture bigDatal2 = new Lecture("7245002", "Relationships and Representations, Graph Databases");
        Lecture bigDatal3 = new Lecture("7245003", "Introduction to Spark 2.0");
        Lecture bigDatal4 = new Lecture("7245004", "Language processing with Spark 2.0");
        Lecture bigDatal5 = new Lecture("7245005", "Analysis of Streaming Data with Spark 2.0");
        Lecture bigDatal6 = new Lecture("7245006", "Applications of Spark ML Library");
        Lecture bigDatal7 = new Lecture("7245007", "Basic Neural Network and Tensor Flow");
        lectureDB().put("7245001", bigDatal1);
        lectureDB().put("7245002", bigDatal2);
        lectureDB().put("7245003", bigDatal3);
        lectureDB().put("7245004", bigDatal4);
        lectureDB().put("7245005", bigDatal5);
        lectureDB().put("7245006", bigDatal6);
        lectureDB().put("7245007", bigDatal7);

        //"csye6230", "Operating Systems"
        Lecture OSl1 = new Lecture("6230001", "Overview of operating systems, functionalities and charateristics of OS");
        Lecture OSl2 = new Lecture("6230002", "Hardware concepts related to OS, CPU states, I/O channels, memory hierarchy, microprogramming");
        Lecture OSl3 = new Lecture("6230003", "The concept of a process, operations on processes, process states, concurrent processes, process control block, process context.");
        Lecture OSl4 = new Lecture("6230004", "UNIX process control and management, PCB, signals, forks and pipes.");
        Lecture OSl5 = new Lecture("6230005", "Interrupt processing, operating system organisation, OS kernel FLIH, dispatcher.");
        Lecture OSl6 = new Lecture("6230006", "Job and processor scheduling, scheduling algorithms, process hierarchies.");
        Lecture OSl7 = new Lecture("6230007", "Problems of concurrent processes, critical sections, mutual exclusion, synchronisation, deadlock.");
        lectureDB().put("6230001", OSl1);
        lectureDB().put("6230002", OSl2);
        lectureDB().put("6230003", OSl3);
        lectureDB().put("6230004", OSl4);
        lectureDB().put("6230005", OSl5);
        lectureDB().put("6230006", OSl6);
        lectureDB().put("6230007", OSl7);

        //"info5100","Application Engineering and Development"
        Lecture javal1 = new Lecture("5100001","Introduction to JAVA");
        Lecture javal2 = new Lecture("5100002","Arithmetic, logic and relation operators");
        Lecture javal3 = new Lecture("5100003","Switch statement");
        Lecture javal4 = new Lecture("5100004","Operations with arrays");
        Lecture javal5 = new Lecture("5100005","Introduction to Classes, objects and methods");
        Lecture javal6 = new Lecture("5100006","Introduction to modular programming");
        Lecture javal7 = new Lecture("5100007","Recursion");
        lectureDB().put("5100001", javal1);
        lectureDB().put("5100002", javal2);
        lectureDB().put("5100003", javal3);
        lectureDB().put("5100004", javal4);
        lectureDB().put("5100005", javal5);
        lectureDB().put("5100006", javal6);
        lectureDB().put("5100007", javal7);

        //"info6150", "Web Design and User Experience Engineering"
        Lecture webDesignl1 = new Lecture("6105001","Introduction, Syllabus, Calendar");
        Lecture webDesignl2 = new Lecture("6105002","Terminology, Starting a Website");
        Lecture webDesignl3 = new Lecture("6105003","HTML Coding, Wireframe");
        Lecture webDesignl4 = new Lecture("6105004","FTP, Basics of CSS Coding");
        Lecture webDesignl5 = new Lecture("6105005","CSS Coding, Internal CSS");
        Lecture webDesignl6 = new Lecture("6105006","Website Layouts");
        Lecture webDesignl7 = new Lecture("6105007","Photoshop, Image Slicing");
        lectureDB().put("6105001", webDesignl1);
        lectureDB().put("6105002", webDesignl2);
        lectureDB().put("6105003", webDesignl3);
        lectureDB().put("6105004", webDesignl4);
        lectureDB().put("6105005", webDesignl5);
        lectureDB().put("6105006", webDesignl6);
        lectureDB().put("6105007", webDesignl7);

        //"info6205", "Program Structure and Algorithms"
        Lecture algol1 = new Lecture("5100001", "Introduction");
        Lecture algol2 = new Lecture("5100002", "Recurrences");
        Lecture algol3 = new Lecture("5100003", "Divide-and-Conquer");
        Lecture algol4 = new Lecture("5100004", "Quicksort, Randomized Algorithms");
        Lecture algol5 = new Lecture("5100005", "Linear-time Sorting: Lower Bounds, Counting Sort, Radix Sort");
        Lecture algol6 = new Lecture("5100006", "Bucketsort");
        Lecture algol7 = new Lecture("5100007", "Universal Hashing, Perfect Hashing");
        lectureDB().put("5100001", algol1);
        lectureDB().put("5100002", algol2);
        lectureDB().put("5100003", algol3);
        lectureDB().put("5100004", algol4);
        lectureDB().put("5100005", algol5);
        lectureDB().put("5100006", algol6);
        lectureDB().put("5100007", algol7);

        //"info6210", "Data Management and Database Design
        Lecture databasel1 = new Lecture("6210001", "introduction; database design and ER models");
        Lecture databasel2 = new Lecture("6210002", "the relational model, relational algebra and SQL");
        Lecture databasel3 = new Lecture("6210003", "storage and indexing");
        Lecture databasel4 = new Lecture("6210004", "transactions");
        Lecture databasel5 = new Lecture("6210005", "recovery and logging");
        Lecture databasel6 = new Lecture("6210006", "semistructured data and XML");
        Lecture databasel7 = new Lecture("6210007", "distributed databases and replication");
        lectureDB().put("6210001", databasel1);
        lectureDB().put("6210002", databasel2);
        lectureDB().put("6210003", databasel3);
        lectureDB().put("6210004", databasel4);
        lectureDB().put("6210005", databasel5);
        lectureDB().put("6210006", databasel6);
        lectureDB().put("6210007", databasel7);

        //"info6215", "Business Analysis and Information Engineering"
        Lecture BIl1 = new Lecture("6215001", "What is Business Analysis");
        Lecture BIl2 = new Lecture("6215002", "The Roles and Functions of the Business Analyst");
        Lecture BIl3 = new Lecture("6215003", "Business Analysis Key Concepts");
        Lecture BIl4 = new Lecture("6215004", "Defining Stakeholders");
        Lecture BIl5 = new Lecture("6215005", "Defining the Business Need");
        Lecture BIl6 = new Lecture("6215006", "Understanding Requirements L");
        Lecture BIl7 = new Lecture("6215007", "Business Analysis Knowledge Areas");
        lectureDB().put("6215001", BIl1);
        lectureDB().put("6215002", BIl2);
        lectureDB().put("6215003", BIl3);
        lectureDB().put("6215004", BIl4);
        lectureDB().put("6215005", BIl5);
        lectureDB().put("6215006", BIl6);
        lectureDB().put("6215007", BIl7);

        //"cs1100", "Computer Science and Its Applications"
        Lecture csl1 = new Lecture("1100001", "INTRODUCTION");
        Lecture csl2 = new Lecture("1100002", "CORE ELEMENTS OF A PROGRAM");
        Lecture csl3 = new Lecture("1100003", "PROBLEM SOLVING");
        Lecture csl4 = new Lecture("1100004", "MACHINE INTERPRETATION OF A PROGRAM");
        Lecture csl5 = new Lecture("1100005", "OBJECTS IN PYTHON");
        Lecture csl6 = new Lecture("1100006", "OBJECTS IN PYTHON");
        Lecture csl7 = new Lecture("1100007", "DEBUGGING");
        lectureDB().put("1100001", csl1);
        lectureDB().put("1100002", csl2);
        lectureDB().put("1100003", csl3);
        lectureDB().put("1100004", csl4);
        lectureDB().put("1100005", csl5);
        lectureDB().put("1100006", csl6);
        lectureDB().put("1100007", csl7);

        //"cs1200", "Leadership Skill Development"
        Lecture leadershipl1 = new Lecture("1200001", "Personal leadership and leadership styles");
        Lecture leadershipl2 = new Lecture("1200002", "Learning and learning to learn");
        Lecture leadershipl3 = new Lecture("1200003", "Leadership of change");
        Lecture leadershipl4 = new Lecture("1200004", "Appreciative inquiry and Appreciative leadership");
        Lecture leadershipl5 = new Lecture("1200005", "People’s reactions to change");
        Lecture leadershipl6 = new Lecture("1200006", "Coaching skills");
        Lecture leadershipl7 = new Lecture("1200007", "Leadership in groups: building and leading efficient teams");
        lectureDB().put("1200001", leadershipl1);
        lectureDB().put("1200002", leadershipl2);
        lectureDB().put("1200003", leadershipl3);
        lectureDB().put("1200004", leadershipl4);
        lectureDB().put("1200005", leadershipl5);
        lectureDB().put("1200006", leadershipl6);
        lectureDB().put("1200007", leadershipl7);

        //"cs1800", "Discrete Structures"
        Lecture disstrl1 = new Lecture("1800001", "Logic: propositional logic, logical equivalence, predicates & quantifiers, and logical reasoning");
        Lecture disstrl2 = new Lecture("1800002", "Sets: basics, set operations");
        Lecture disstrl3 = new Lecture("1800003", "Functions: one-to-one, onto, inverse, composition, graphs");
        Lecture disstrl4 = new Lecture("1800004", "Integers: greatest common divisor, Euclidean algorithm. ");
        Lecture disstrl5 = new Lecture("1800005", "Sequences and Summations ");
        Lecture disstrl6 = new Lecture("1800006", "Mathematical reasoning and induction: Proof strategies, Mathematical Induction, Recursive ");
        Lecture disstrl7 = new Lecture("1800007", "Counting: basic rules, Pigeonhole principle, Permutations and Combinations, Binomial ");
        lectureDB().put("1800001", disstrl1);
        lectureDB().put("1800002", disstrl2);
        lectureDB().put("1800003", disstrl3);
        lectureDB().put("1800004", disstrl4);
        lectureDB().put("1800005", disstrl5);
        lectureDB().put("1800006", disstrl6);
        lectureDB().put("1800007", disstrl7);

        //"cs3500", "Object-Oriented Design"
        Lecture OODl1 = new Lecture("3500001", "Introduction");
        Lecture OODl2 = new Lecture("3500002", "Welcome to Software Design and Architecture");
        Lecture OODl3 = new Lecture("3500003", "Software Architect and Design Roles in Industry");
        Lecture OODl4 = new Lecture("3500004", "Object-Oriented Modeling");
        Lecture OODl5 = new Lecture("3500005", "Software Requirements, Conceptual and Technical Designs");
        Lecture OODl6 = new Lecture("3500006", "Competing Qualities and Trade-off");
        Lecture OODl7 = new Lecture("3500007", "Record, Organize, and Refine Components");
        lectureDB().put("3500001", OODl1);
        lectureDB().put("3500002", OODl2);
        lectureDB().put("3500003", OODl3);
        lectureDB().put("3500004", OODl4);
        lectureDB().put("3500005", OODl5);
        lectureDB().put("3500006", OODl6);
        lectureDB().put("3500007", OODl7);

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

        Student student1 = new Student("Ciera", "1000","Computer Systems Engineering");
        student1.setCourses(Arrays.asList("csye6225", "csye7245"));
        Student student2 = new Student("John","1001", "Computer Systems Engineering");
        student2.setCourses(Arrays.asList("csye7245", "csye6230"));
        Student student3 = new Student("Bob", "1002","Infomation Systems");
        student3.setCourses(Arrays.asList("info5100", "info6150",""));
        Student student4 = new Student("Jason", "1003", "Infomation Systems");
        student4.setCourses(Arrays.asList("info6205", "info6210", "info6215"));
        Student student5 = new Student("Alex","1004", "Computer Science");
        student5.setCourses(Arrays.asList("cs1100", "cs1200"));
        Student student6 = new Student("Josh","1005", "Computer Science");
        student6.setCourses(Arrays.asList("cs1200", "cs1800"));
        studentDB.put("1000", student1);
        studentDB.put("1001", student2);
        studentDB.put("1002", student3);
        studentDB.put("1003", student4);
        studentDB.put("1004", student5);
        studentDB.put("1005", student6);

        Professor professor1 = new Professor("Computer Systems Engineering", "2046", "", "Lazy", Arrays.asList("csye6225","csye7245"));
        Professor professor2 = new Professor("Computer Systems Engineering", "2047", "", "Winnie", Arrays.asList("csye7245"));
        Professor professor3 = new Professor("Infomation Systems", "2048", "", "Pool", Arrays.asList("csye7245","info6205"));
        Professor professor4 = new Professor("Infomation Systems", "2049", "", "Rabbit", Arrays.asList("info6205"));
        Professor professor5 = new Professor("Infomation Systems", "2050", "", "Yalin", Arrays.asList("info6205"));
        Professor professor6 = new Professor("Infomation Systems", "2051", "", "Lem", Arrays.asList("info6205"));
        Professor professor7 = new Professor("Computer Science", "2052", "", "Sierra", Arrays.asList("info6205"));
        Professor professor8 = new Professor("Computer Science", "2053", "", "Ping", Arrays.asList("info6205"));
        Professor professor9 = new Professor("Computer Science", "2054", "", "Jing", Arrays.asList("info6205"));
        Professor professor10 = new Professor("Computer Science", "2055", "12", "Salesforce", Arrays.asList("info6205"));
        professorDB.put("2046", professor1);
        professorDB.put("2047", professor2);
        professorDB.put("2048", professor3);
        professorDB.put("2049", professor4);
        professorDB.put("2050", professor5);
        professorDB.put("2051", professor6);
        professorDB.put("2052", professor7);
        professorDB.put("2053", professor8);
        professorDB.put("2054", professor9);
        professorDB.put("2055", professor10);

    }

    public HashMap<String, Professor> getProfessorDB() {
        return professorDB;
    }

    public HashMap<String, Student> getStudentDB() {
        return studentDB;
    }

    public HashMap<String, Course> getCourseDB() {
        return courseDB;
    }

    public HashMap<Long, Program> programDB() { return programDB; }

    public HashMap<String, Lecture> lectureDB() { return lectureDB; }
}
