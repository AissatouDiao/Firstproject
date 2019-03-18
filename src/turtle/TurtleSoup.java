/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
public class TurtleSoup{
    
        
    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
       // throw new RuntimeException("implement me!");
        for(int i=0;i<4;i++) {
        turtle.turn(90);
       turtle.forward(sideLength);
       
        }
       
    }
   
    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        //throw new RuntimeException("implement me!");
   
        //double angle=((sides-2)*180)/sides;
        //return ((double)(sides-2)*180)/sides;
        return 180. - 360./sides;
         }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        //throw new RuntimeException("implement me!");
       // return Math.round((int)(((angle-180+360)/180)));
        return (int) Math.round(360./(180.-angle));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        //throw new RuntimeException("implement me!");
        double angle = calculateRegularPolygonAngle(sides);
        for (int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turn(180. - angle);
        }
        
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    
    public static double contrainte(double A) {
        while(A>=0) {
            A+=360.;
        }
        while(A<360) {
            A-=360.;
        }
        return A;
    }
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
                                                    
       // throw new RuntimeException("implement me!");
                                                    double Disy = (double) (targetY - currentY);
                                                    double Disx = (double) (targetX - currentX);
                                                    double alpha = Math.toDegrees(Math.atan2(Disy, Disx));
                                                    double resultat = 90. - Math.abs(alpha) - currentHeading;
                                                    return contrainte(resultat);
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        //throw new RuntimeException("implement me!");
            List<Double> headings = new ArrayList<>();
            double currentHeading = 0.0;
            for (int i = 0; i < xCoords.size() - 1; i++) {
                currentHeading = calculateHeadingToPoint(
                        currentHeading,
                        xCoords.get(i),
                        yCoords.get(i),
                        xCoords.get(i+1),
                        yCoords.get(i+1));
                currentHeading = contrainte(currentHeading);
                headings.add(currentHeading);
            }
            return headings;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        //throw new RuntimeException("implement me!");
        turtle.color(PenColor.MAGENTA);
        for(int i=0;i<1000;i++)
        {turtle.turn(10);
        turtle.forward(15);
        for(int e=15;e<1000;e++)
        {turtle.turn(15);
        turtle.forward(40);
        }
        }
        turtle.color(PenColor.BLUE);
        for(int e=15;e<1000;e++)
        {
         turtle.turn(15);
        turtle.forward(40);
        for(int i=0;i<1000;i++)
        {turtle.turn(10);
        turtle.forward(15);}
        }
        turtle.color(PenColor.YELLOW);
        for(int e=300;e<1000;e++)
        {
         turtle.turn(15);
        turtle.forward(40);
        for(int i=0;i<1000;i++)
        {turtle.turn(5);
        turtle.forward(110);}
        }
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        
        DrawableTurtle turtle = new DrawableTurtle();
        
        drawSquare(turtle, 40);
        
        // draw the window
        turtle.draw();
        drawRegularPolygon(turtle, 20, 40);
        
        drawPersonalArt(turtle);
        
    }

    
  

}
