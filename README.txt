ELB URL(yuhanwang001@gmail.com): http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/
gitHub: https://github.com/TAVAU/CloudComputing

GET:
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/courses
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/announcements
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/students
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/professors
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/boards


GET professor by ID:
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/professors/zhifeng.sun

professor
POST
{
    "department": "CS",
    "firstName": "Zhifeng",
    "joiningDate": "11-06-2018",
    "lastName": "Sun",
    "professorId": "zhifeng.sun"
}


GET course by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/courses/info3300

POST
create a new course
body:
{
    "TAId": "ashen.wu",
    "boardId": "info3200",
    "courseId": "info3200",
    "department": "CS",
    "enrolledStudent": [
        "louise",
        "yes i see it",
        "carren.wang"
    ],
    "professorId": "dance.si"
}

GET student by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/students/ciera.wang

POST
create a new student
body:
{
    "department": "IS",
    "firstName": "Emma",
    "joiningDate": "09-01-2017",
    "lastName": "Li",
    "registeredCourses": [
        "info6205"
    ],
    "studentId": "emma.li"
}

GET board by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/boards/csye6225

POST
create a new board
body:
{
    "announcements": [
	    "What is Business Analysis",
	    "uuuu"
    ],
    "boardId": "info3311",
    "courseId": "info3311"
}

GET announcement by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/announcements/info5100_001

POST
create a new announcement
body:
{
    "announcementId": "008",
    "announcementText": "Introduction to JAVA",
    "boardId": "info5100"
}

