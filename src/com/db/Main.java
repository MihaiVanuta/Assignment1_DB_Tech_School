package com.db;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        //list all files from "facultate" directory
        List<Path> files = new ArrayList<>();
        try {
            Files.list(Paths.get("facultate"))
                    .forEach(System.out::println);
            files = Files.list(Paths.get("facultate"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Student> sortedSet = new TreeSet<>(Comparator.comparing(Student::getMedie).reversed()
                .thenComparing(Student::getNume)
                .thenComparing(Student::getPrenume));
            for(Path path: files) {
                String fullPath = "facultate/" + path.getFileName();
                try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        String[] attributes = line.split(",");
                        Student student = new Student();
                        student.setNume(attributes[0]);
                        student.setPrenume(attributes[1]);
                        student.setEmail(attributes[2]);
                        student.setCredite(Integer.parseInt(attributes[3]));
                        student.setMedie(Float.parseFloat(attributes[4]));
                        sortedSet.add(student);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter("facultate/studenti.txt"))){
                sortedSet.forEach((Student s) -> {
                    try {
                        bw.write(s.toString() + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }



    }
}
