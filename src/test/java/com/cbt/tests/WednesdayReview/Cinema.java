package com.cbt.tests.WednesdayReview;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Movie movie1=new Action();
        movie1.setIdNumber(1);
        movie1.setRating("PG-13");
        movie1.setTitle("Ford vs Ferrari");

        Movie movie2=new Movie();
        movie2.setIdNumber(1);
        movie2.setRating("PG");
        movie2.setTitle("Frozen 2");

        System.out.println(movie1.equals(movie2));
        System.out.println(movie1);
        System.out.println(movie2);

        Movie [] movies=new Movie[2];
        movies[0]=movie1;
        movies[1]=movie2;


        Scanner scanner =new Scanner(System.in);
        System.out.print("enter a movie ID");
        int movieID=scanner.nextInt();
        if(movieID<=movies.length){
            System.out.print("how many day it was late");
            int days=scanner.nextInt();
            System.out.print("late fee: "+movies[movieID-1].calculateFees(days)+"$");
                    }
        else{
            System.out.println("invalid movie id!");
        }




    }
}
