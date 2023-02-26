package com.techmaster.testSpringRESTAPI.database;

import com.techmaster.testSpringRESTAPI.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courses = new ArrayList<>(
            List.of(new Course(
                    1,
                    "spring boot",
                    "java framework",
                    "onlab",
                    new ArrayList<String>(List.of("back-end","java")),
                    "",
                    1),
                    new Course(
                    2,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                    "",
                    2),
                    new Course(
                            3,
                            "PHP",
                            "PHP framework",
                            "onlab",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            4,
                            "Flutter",
                            "framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            5,
                            "React JS",
                            "js framework",
                            "onlab",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            6,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            7,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            8,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            9,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2),
                    new Course(
                            10,
                            "React JS",
                            "js framework",
                            "online",
                            new ArrayList<String>(List.of("front-end","js")),
                            "",
                            2)


            )
    );
}
