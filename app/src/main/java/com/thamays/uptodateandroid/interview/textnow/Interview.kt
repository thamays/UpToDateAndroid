package com.thamays.uptodateandroid.interview.textnow

interface Repository<T> {
    fun get(): Iterable<T>
}

data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)

data class Course(val id: Id, val name: String, val isPaid: Boolean)

typealias Id = Int

class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> {
        val result = mutableMapOf<Course, Int>()

        val students = repository.get()
        students.forEach { student ->
            student.subscribedCourses.filter { it.isPaid }
                .forEach { course ->
                    result[course] = result.getOrDefault(course, 0) + 1
                }
        }

        return result.toList().sortedByDescending { (key, value) -> value }
            .take(coursesCount).toMap()
    }
}

//Student(
// id=1,
// name=Student Name 1,
// subscribedCourses=[
// Course(id=19, name=Course title 19, isPaid=false),
// Course(id=18, name=Course title 18, isPaid=true), Course(id=17, name=Course title 17, isPaid=false), Course(id=15, name=Course title 15, isPaid=false), Course(id=14, name=Course title 14, isPaid=true), Course(id=11, name=Course title 11, isPaid=false), Course(id=9, name=Course title 9, isPaid=false), Course(id=5, name=Course title 5, isPaid=false), Course(id=4, name=Course title 4, isPaid=true), Course(id=1, name=Course title 1, isPaid=false)])

//Student(id=2, name=Student Name 2, subscribedCourses=[Course(id=19, name=Course title 19, isPaid=false), Course(id=17, name=Course title 17, isPaid=false), Course(id=16, name=Course title 16, isPaid=true), Course(id=15, name=Course title 15, isPaid=false), Course(id=10, name=Course title 10, isPaid=true), Course(id=6, name=Course title 6, isPaid=true), Course(id=5, name=Course title 5, isPaid=false), Course(id=4, name=Course title 4, isPaid=true), Course(id=2, name=Course title 2, isPaid=true)])
