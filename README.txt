ELB URL(yuhanwang001@gmail.com): http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/
gitHub: https://github.com/TAVAU/CloudComputing

GET:
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/courses
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/lectures
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/students
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/professors

GET professor by ID:
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/professors/2047

professor
POST
{  
   "courses":[  
      {  
         "courseId":"info6205",
         "courseName":"Program Structure and Algorithms",
         "lectures":[  
            {  
               "lectureId":5100001,
               "lectureName":"Introduction"
            },
            {  
               "lectureId":5100002,
               "lectureName":"Recurrences"
            },
            {  
               "lectureId":5100003,
               "lectureName":"Divide-and-Conquer"
            },
            {  
               "lectureId":5100004,
               "lectureName":"Quicksort, Randomized Algorithms"
            },
            {  
               "lectureId":5100005,
               "lectureName":"Linear-time Sorting: Lower Bounds, Counting Sort, Radix Sort"
            },
            {  
               "lectureId":5100006,
               "lectureName":"Bucketsort"
            },
            {  
               "lectureId":5100007,
               "lectureName":"Universal Hashing, Perfect Hashing"
            }
         ]
      }
   ],
   "department":"Infomation Systems",
   "firstName":"Rabbit",
   "joiningDate":"2018-10-20T02:53:24.256Z[UTC]",
   "professorId":1234
}


GET course by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/courses/info6205

POST
create a new course
body:
{  
   "courseId":"newcourse001",
   "courseName":"Program Structure and Algorithms",
   "lectures":[  
      {  
         "lectureId":5100001,
         "lectureName":"Introduction"
      },
      {  
         "lectureId":5100002,
         "lectureName":"Recurrences"
      },
      {  
         "lectureId":5100003,
         "lectureName":"Divide-and-Conquer"
      },
      {  
         "lectureId":5100004,
         "lectureName":"Quicksort, Randomized Algorithms"
      },
      {  
         "lectureId":5100005,
         "lectureName":"Linear-time Sorting: Lower Bounds, Counting Sort, Radix Sort"
      },
      {  
         "lectureId":5100006,
         "lectureName":"Bucketsort"
      },
      {  
         "lectureId":5100007,
         "lectureName":"Universal Hashing, Perfect Hashing"
      }
   ]
}

GET lecture by ID
http://csye6225-env.25auac3tzp.us-east-2.elasticbeanstalk.com/webapi/lectures/6215001

POST
create a new lecture
body:
{  
   "lectureId":00000001,
   "lectureName":"Defining Stakeholders"
}

GET student by ID

